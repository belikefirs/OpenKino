<template>
    <v-container>
        <v-layout>
            <v-flex sm6>
                <v-text-field
                v-model="searchBox"
                prepend-inner-icon="search"
                placeholder="Поиск"
                solo
                />
            </v-flex>
            <v-spacer/>
            <v-dialog
            v-model="dialog"
            width="500">
                <template v-slot:activator="{ on }">
                    <v-btn sm1 color="primary" v-on="on">Добавить</v-btn>
                </template>
                <v-card>
                    <v-card-title>{{dialogTitle}}</v-card-title>
                    <v-card-text>
                        <v-text-field
                        v-model="editingItem.name"
                        label="Название"
                        clearable
                        />
                        <v-text-field
                        v-model="editingItem.lenght"
                        label="Длительность"
                        clearable
                        />
                        <v-text-field
                        v-model="editingItem.rating"
                        label="Рейтинг"
                        clearable
                        />
                        <v-combobox
                        :items="genres"
                        v-model="editingItem.genre"
                        label="Жанр"
                        clearable
                        dense
                        hide-selected
                        />
                        <v-combobox
                        :items="filmTypes"
                        v-model="editingItem.typeFilm"
                        label="Тип фильма"
                        clearable
                        sort
                        dense
                        /><!-- multiple -->
                        <v-text-field
                        v-model="editingItem.limitAge"
                        label="Возрастное ограничение"
                        clearable
                        mask="###"
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
                    :items="items"
                    hide-actions
                    no-data-text="Нет данных">
                        <template v-slot:items="props">
                            <td>{{ props.item.name }}</td>
                            <td>{{ props.item.lenght / 60 + ' мин'}}</td>
                            <td>{{ props.item.rating }}</td>
                            <td>{{ props.item.genre }}</td>
                            <td>{{ props.item.typeFilm }}</td>
                            <td>{{ props.item.limitAge + '+' }}</td>
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
export default {
    watch: {
        'dialog' () {
            if (!this.dialog) {
                Object.assign(this.editingItem, this.defaultItem);
                this.editingIndex = -1;
            }
        },
    },
    data(){
        return{
            searchBox: '',
            dialog: false,
            editingIndex: -1,
            genres: [],
            filmTypes: ['2D', '3D', 'Imax'],
            headers: [
                {
                    text: 'Название',
                    align: 'left',
                    sortable: false,
                    value: 'name'
                },
                {
                    text: 'Длительность',
                    align: 'left',
                    sortable: false,
                    value: 'lenght'
                },
                {
                    text: 'Рейтинг',
                    align: 'left',
                    sortable: false,
                    value: 'rating'
                },
                {
                    text: 'Жанр',
                    align: 'left',
                    sortable: false,
                    value: 'genre'
                },
                {
                    text: 'Тип фильма',
                    align: 'left',
                    sortable: false,
                    value: 'typeFilm'
                },
                {
                    text: 'Возрастное ограничение',
                    align: 'left',
                    sortable: false,
                    value: 'limitAge'
                },
                {
                    text: 'Действия',
                    align: 'right',
                    sortable: false,
                    value: 'actions'
                },
            ],
            items: [
                { 
                    id: 0,
                    name: 'Человек-паук: Вдали от дома',
                    lenght: 7740,
                    rating: 7.536,
                    genre: 'фантастика, боевик, приключения',
                    typeFilm: '2D, 3D',
                    limitAge: 12,
                },
            ],
            defaultItem: {
                name: '',
                lenght: null,
                rating: null,
                genre: '',
                typeFilm: '',
                limitAge: null,
            },
            editingItem:{
                name: '',
                lenght: null,
                rating: null,
                genre: '',
                typeFilm: '',
                limitAge: null,
            }
        }
    },
    methods: {
        confirmDialog(){
            if (this.editingItem.name.length == 0 ||
                this.editingItem.lenght.length == 0 || 
                this.editingItem.rating.length == 0 || 
                this.editingItem.genre.length == 0 || 
                this.editingItem.typeFilm.length == 0 ||
                this.editingItem.limitAge.length == 0) return;
            if (this.editingIndex == -1)
                this.items.push({
                    name: this.editingItem.name,
                    lenght: this.editingItem.lenght,
                    rating: this.editingItem.rating,
                    genre: this.editingItem.genre,
                    typeFilm: this.editingItem.typeFilm,
                    limitAge: this.editingItem.limitAge,
                });
            else {
                Object.assign(this.items[this.editingIndex], this.editingItem);
            }
            this.dialog = false;
            this.$store.dispatch('ADD_FILM', this.editingItem);
        },
        changeItem(item, index){
            Object.assign(this.editingItem, item);
            this.editingIndex = index;
            this.dialog = true;
        },
        deleteItem(item){
            const index = this.items.indexOf(item);
            this.items.splice(index, 1);
        },
    },
    computed: {
        dialogTitle () {
            return this.editingIndex >= 0 ? 'Изменение' : 'Добавление';
        },
        confirmBtn () {
            return this.editingIndex >= 0 ? 'Изменить' : 'Добавить';
        },
    },
}
</script>
