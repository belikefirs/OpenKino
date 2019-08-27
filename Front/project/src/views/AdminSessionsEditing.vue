<template>
    <v-container>
        <v-layout>
            <v-flex sm6>
                <v-text-field
                v-model="searchBox"
                prepend-inner-icon="search"
                placeholder="Поиск"
                solo
                @change="search"
                />
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
                        v-model="editingItem.film"
                        label="Фильм"
                        clearable
                        no-data-text="Нет данных"
                        />
                        <v-combobox
                        v-model="editingItem.hall"
                        label="Зал"
                        clearable
                        />
                        <v-text-field
                        v-model="editingItem.beginTime"
                        label="Время начала"
                        clearable
                        />
                        <v-text-field
                        v-model="editingItem.endTime"
                        label="Время окончания"
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
                    :items="$store.state.filmList"
                    hide-actions
                    no-data-text="Нет данных">
                        <template v-slot:items="props">
                            <td>
                                <v-img max-height="76" :src="props.item.image"/>
                            </td>
                            <td>{{ props.item.film }}</td>
                            <!-- <td>{{ props.item.name }}</td>
                            <td>{{ props.item.lenght / 60 + ' мин' }}</td>
                            <td>{{ props.item.rating.rating }}</td>
                            <td>{{ props.item.genre.name }}</td> -->
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
    watch: {
        'dialog' () {
            if (!this.dialog) {
                this.$store.dispatch('GET_RATING_FILM_LIST');
                this.$store.dispatch('GET_TYPE_FILM_LIST');
                this.$store.dispatch('GET_GENRE_FILM_LIST');
                this.$store.dispatch('GET_LIMIT_AGE_FILM_LIST');
            }
        },
    },
    data(){
        return{
            searchBox: '',
            dialog: false,
            tempFileName: '',
            editingIndex: -1,
            headers: [
                {
                    text: 'Фильм',
                    align: 'center',
                    sortable: false,
                    value: 'name'
                },
                {
                    text: 'Зал',
                    align: 'center',
                    sortable: false,
                    value: 'name'
                },
                {
                    text: 'Время начала',
                    align: 'center',
                    sortable: false,
                    value: 'lenght'
                },
                {
                    text: 'Время окончания',
                    align: 'center',
                    sortable: false,
                    value: 'rating'
                },
            ],
            defaultItem: {
                film: '',
                hall: '',
                beginTime: '',
                endTime: '',
            },
            editingItem:{
                film: '',
                hall: '',
                beginTime: '',
                endTime: '',
            },
        }
    },
    methods: {
        search(){
            this.$store.dispatch('GET_FILMS_WITH_FILTERS', {name: this.searchBox});
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
                this.$store.dispatch('ADD_FILM', this.editingItem).then(() => {
                    this.$store.dispatch('GET_FILMS_WITH_FILTERS', {name: this.searchBox});
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
                this.$store.dispatch('CHANGE_FILM', this.editingItem).then(() => {
                    this.$store.dispatch('GET_FILMS_WITH_FILTERS', {name: this.searchBox});
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
            this.$store.dispatch('DELETE_FILM', {id: item.id}).then(() => {
                this.$store.dispatch('GET_FILMS_WITH_FILTERS', {name: this.searchBox});
            });
        },
        btnLoadClick(){
            if (this.editingItem.image == '') {
                this.$refs.inputUpload.click();
            } else {
                this.editingItem.image = '';
                this.tempFileName = '';
            }
        },
        loadImage(e){
            let files = e.target.files || e.dataTransfer.files;
            if (!files.length) return;

            let filteFlag = false;
            let imageFilter = ['.jpg','.png','.gif', '.tif'];
            for (let i = 0; i < imageFilter.length; i++) {
                if (files[0].name.includes(imageFilter[i])) {
                    filteFlag = true;
                    break;
                }
            }
            if (filteFlag) this.createImage(files[0]);
        },
        createImage(file){
            let image = new Image();
            let reader = new FileReader();
            let vm = this;

            reader.onload = function(e) {
                vm.editingItem.image = e.target.result;
            };
            reader.readAsDataURL(file);
            this.tempFileName = file.name;
        },
    },
    computed: {
        dialogTitle () {
            return this.editingIndex >= 0 ? 'Изменение' : 'Добавление';
        },
        confirmBtn () {
            return this.editingIndex >= 0 ? 'Изменить' : 'Добавить';
        },
        defaultLanghtValue() {
            return this.editingItem.lenght > 0 ? this.editingItem.lenght / 60 : ''; 
        }
    },
    created(){
        this.$store.dispatch('GET_FILMS_WITH_FILTERS', {name: this.searchBox});
        this.$store.dispatch('GET_RATING_FILM_LIST');
        this.$store.dispatch('GET_TYPE_FILM_LIST');
        this.$store.dispatch('GET_GENRE_FILM_LIST');
        this.$store.dispatch('GET_LIMIT_AGE_FILM_LIST');
    },
    directives:{
		myFilter:{
            bind(el, binding) {
                el.addEventListener('input', function(e){
                    binding.value.lenght = e.target.value ? e.target.value * 60 : 0;
                });
            },
		},
	},
}
</script>