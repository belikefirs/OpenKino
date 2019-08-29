<template>
    <v-container>
        <v-layout>
            <v-flex sm6>
                <!-- <v-text-field
                v-model="searchBox"
                prepend-inner-icon="search"
                placeholder="Поиск"
                solo
                @change="search"
                /> -->
                <v-select 
                :items="$store.state.Films.filmList"
                label="Поиск по фильму"
                no-data-text="Нет данных"
                solo
                v-model="modelSearch"
                @input="search"
                >
                    <template v-slot:item="props">
                        {{props.item.name}}
                    </template>
                    <template v-slot:selection="props">
                        {{props.item.name}}
                    </template>
                </v-select>
                
                
            </v-flex>
            <v-spacer/>
            <v-btn sm1 color="primary" @click="addItem">Добавить</v-btn>
            <v-dialog
            v-model="dialog"
            width="500">
                <v-card>
                    <v-card-title>{{dialogTitle}}</v-card-title>
                    <v-card-text>
                        <v-select
                        :items="$store.state.Films.filmList"
                        label="Фильм"
                        no-data-text="Нет данных"
                        v-model="modelFilm"
                        >
                            <template v-slot:item="props">
                                {{props.item.name}}
                            </template>
                            <template v-slot:selection="props">
                                {{props.item.name}}
                            </template>
                        </v-select>

                        <v-select
                        :items="$store.state.Hall.hallList"
                        label="Зал"
                        no-data-text="Нет данных"
                        v-model="modelHall"
                        >
                            <template v-slot:item="props">
                                {{props.item.number}}
                            </template>
                            <template v-slot:selection="props">
                                {{props.item.number}}
                            </template>
                        </v-select>

                        <v-text-field
                        label="Время начала"
                        mask="time"
                        clearable
                        v-model="editingItem.start"
                        />
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer/>
                        <v-btn @click="confirmDialog" color="primary">{{confirmBtn}}</v-btn>
                        <v-btn @click="dialog = false">Отмена</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
        <v-layout>
            <v-flex sm12>
                <v-card>
                    <v-data-table
                    :headers="headers"
                    :items="$store.state.Sessions.sessionList"
                    hide-actions
                    no-data-text="Нет данных">
                        <template v-slot:items="props">
                            <td>{{ searchFilmName }}</td>
                            <td>{{ props.item.hall.id }}</td>
                            <td>{{ props.item.start.substring(props.item.start.length - 5) }}</td>
                            <td class="text-xs-right">
                                <v-btn flat icon color="amber" @click="changeItem(props.item, props.index)">
                                    <v-icon>edit</v-icon>
                                </v-btn>
                                <v-btn flat icon color="red" @click="deleteItem(props.item)">
                                    <v-icon>delete</v-icon>
                                </v-btn>
                            </td>
                        </template>
                    </v-data-table>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { setTimeout } from 'timers';
export default {
    data(){
        return{
            searchFilmName: '',
            searchId: null,
            dialog: false,
            editingIndex: -1,
            headers: [
                {
                    text: 'Фильм',
                    align: 'left',
                    sortable: false,
                    value: 'filmName'
                },
                {
                    text: 'Зал',
                    align: 'left',
                    sortable: false,
                    value: 'hall'
                },
                {
                    text: 'Время начала',
                    align: 'left',
                    sortable: false,
                    value: 'timeBegin'
                },
                {
                    text: 'Действия',
                    align: 'right',
                    sortable: false,
                    value: 'timeEnd'
                },
            ],
            defaultItem: {
                start: null,
                hall:{ id: null },
                film:{ id: null },
            },
            editingItem:{
                start: null,
                hall:{ id: null },
                film:{ id: null },
            },
        }
    },
    methods: {
        search(){
            if (this.searchId) this.$store.dispatch('Sessions/GET_SESSION_LIST', { id: this.searchId });
        },
        confirmDialog(){
            if (!this.editingItem.start || this.editingItem.start.length < 4 ||
                !this.editingItem.hall.id || this.editingItem.hall.id.length == 0 ||
                !this.editingItem.film.id || this.editingItem.film.id.length == 0) return;
            setTimeout(() => {
            if (this.editingIndex == -1) {
                this.$store.dispatch('Sessions/ADD_SESSION', this.editingItem).then(() => this.search());
            } else {
                //code to change here
            }
            this.dialog = false;
            }, 100);
            
        },
        addItem(){
            Object.assign(this.editingItem, this.defaultItem);
            this.editingIndex = -1;
            this.tempFileName = '';
            this.dialog = true;
        },
        changeItem(item, index){
            Object.assign(this.editingItem, item);
            this.editingIndex = index;
            this.dialog = true;
        },
        deleteItem(item){
            this.$store.dispatch('Sessions/DELETE_SESSION', {id: item.id}).then(() => this.search());
        },
    },
    computed: {
        dialogTitle () {
            return this.editingIndex >= 0 ? 'Изменение' : 'Добавление';
        },
        confirmBtn () {
            return this.editingIndex >= 0 ? 'Изменить' : 'Добавить';
        },

        modelSearch: {
            get() {},
            set: function(obj){
                this.searchId = obj.id;
                this.searchFilmName = obj.name;
            }
        },
        modelFilm: {
            get() {},
            set: function (obj) {
                this.editingItem.film.id = obj.id;
            },
        },
        modelHall: {
            get() {},
            set: function(obj) {
                this.editingItem.hall.id = obj.id;
            }
        },
    },
    created(){
        this.$store.dispatch('Films/GET_FILMS_WITH_FILTERS', {name: ''});
        this.$store.dispatch('Hall/GET_ALL_HALLS');
    },
}
</script>