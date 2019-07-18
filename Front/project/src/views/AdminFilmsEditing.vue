<template>
    <v-container>
        <v-layout>
            <v-flex sm6>
                <v-text-field
                v-model="searchBox"
                label="Solo"
                prepend-inner-icon="search"
                placeholder="Поиск"
                solo
                ></v-text-field>
            </v-flex>
            <v-spacer></v-spacer>
            <v-btn sm1 color="primary" @click="addClick">Добавить</v-btn>
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
                                <v-btn flat icon color="amber" >
                                    <v-icon>edit</v-icon>
                                </v-btn>
                                <v-btn flat icon color="red" @click="deleteClick(props.item)">
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
    data(){
        return{
            searchBox: '',
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
        }
    },
    methods: {
        addClick(){
            this.items.push({
                name: 'newName',
                lenght: 60,
                rating: 2,
                genre: 'newGenre',
                typeFilm: 'newType',
                limitAge: 3,
            });
        },
        deleteClick(item){
            const index = this.items.indexOf(item);
            this.items.splice(index, 1);
        }
    },
}
</script>
