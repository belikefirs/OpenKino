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
                v-model="modalSearch"
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
                        v-model="modalFilm"
                        >
                            <template v-slot:item="props">
                                {{props.item.name}}
                            </template>
                            <template v-slot:selection="props">
                                {{props.item.name}}
                            </template>
                        </v-select>
                        <v-combobox
                        v-model="editingItem.hall"
                        label="Зал"
                        clearable
                        />
                        <v-text-field
                        v-model="editingItem.beginTime"
                        label="Время начала"
                        mask="time"
                        clearable
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
                            <td>{{ props.item.start + ' мин' }}</td>
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
                filmId: '',
                hall: '',
                beginTime: '',
            },
            editingItem:{
                filmId: '',
                hall: '',
                beginTime: '',
            },
        }
    },
    methods: {
        search(){
            if (this.searchId) this.$store.dispatch('Sessions/GET_SESSION_LIST', { id: this.searchId });
        },
        confirmDialog(){
            if (this.editingItem.name == null || this.editingItem.namelength == 0 ||
                this.editingItem.lenght == null || this.editingItem.lenght.length == 0 || 
                this.editingItem.rating == null || this.editingItem.rating.length == 0 || 
                this.editingItem.genre == null || this.editingItem.genre.length == 0 ||
                this.editingItem.typeFilm == null || this.editingItem.typeFilm.length == 0 ||
                this.editingItem.limitAge == null || this.editingItem.limitAge.length == 0) return;
            setTimeout(() => {
            if (this.editingIndex == -1) {
                if (this.editingItem.typeFilm.name == null) 
                    this.editingItem.typeFilm = {name: this.editingItem.typeFilm};
                if (this.editingItem.genre.name == null) 
                    this.editingItem.genre = {name: this.editingItem.genre};
                if (this.editingItem.limitAge.age == null) 
                    this.editingItem.limitAge = {age: this.editingItem.limitAge};
                if (this.editingItem.rating.rating == null) 
                    this.editingItem.rating = {rating: this.editingItem.rating};
                this.$store.dispatch('Films/ADD_FILM', this.editingItem).then(() => {
                    this.$store.dispatch('Films/GET_FILMS_WITH_FILTERS', {name: this.searchBox});
                });
            } else {
                if (this.editingItem.typeFilm.name != this.$store.state.filmList[this.editingIndex].typeFilm.name) 
                    this.editingItem.typeFilm = {name: this.editingItem.typeFilm};
                if (this.editingItem.genre.name != this.$store.state.filmList[this.editingIndex].genre.name) 
                    this.editingItem.genre = {name: this.editingItem.genre};
                if (this.editingItem.limitAge.age != this.$store.state.filmList[this.editingIndex].limitAge.age) 
                    this.editingItem.limitAge = {age: this.editingItem.limitAge};
                if (this.editingItem.rating.rating != this.$store.state.filmList[this.editingIndex].rating.rating) 
                    this.editingItem.rating = {rating: this.editingItem.rating};
                this.$store.dispatch('Films/CHANGE_FILM', this.editingItem).then(() => {
                    this.$store.dispatch('Films/GET_FILMS_WITH_FILTERS', {name: this.searchBox});
                });
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
            this.$store.dispatch('Films/DELETE_FILM', {id: item.id}).then(() => {
                this.$store.dispatch('Films/GET_FILMS_WITH_FILTERS', {name: this.searchBox});
            });
        },
    },
    computed: {
        dialogTitle () {
            return this.editingIndex >= 0 ? 'Изменение' : 'Добавление';
        },
        confirmBtn () {
            return this.editingIndex >= 0 ? 'Изменить' : 'Добавить';
        },

        modalFilm: {
            get() {},
            set: function (obj) {
                this.editingItem.filmId = obj.id;
            },
        },
        modalSearch: {
            get() {},
            set: function(obj){
                this.searchId = obj.id;
                this.searchFilmName = obj.name;
            }
        }
    },
    created(){
        this.$store.dispatch('Films/GET_FILMS_WITH_FILTERS', {name: ''});
    },
}
</script>