<template>
    <div class="wrapper-admin">
        <p>Здравствуйте: Гость</p>
        <form class="log inputCont" @submit.prevent="savaFilm">
            <input v-model="form.name" placeholder="Название фильма">
            <input v-model="form.lenght" placeholder="Продолжительность">
            <AddFilm v-model="form.typeFilm.name" :filmTypeList="this.$store.state.typeFilmList" :ph="'Тип'" @clickItem="getType" @clickClear="getClearType"></AddFilm>
            <AddFilm :filmTypeList="this.$store.state.genreFilmList" :ph="'Жанр'" v-model="form.genre.name" @clickItem="getGenre" @clickClear="getClearGenre"></AddFilm>
            <input v-model="form.limitAge.age" placeholder="Возрастное ограничение">
            <input v-model="form.rating.rating" placeholder="Рейтинг">
            <br>
            <button class="button">Сохранить</button>
        </form>  
    </div>
</template>

<script>
import AddFilm from '@/components/FilmsGenre.vue'
export default {
    components: {
        AddFilm
    },
    data() {
        return {
            form: {
                name: '',
                lenght: '',
                typeFilm: {
                    name: "",
                },
                genre: {
                    name: ""
                },
                limitAge: {
                    age:""
                },
                rating: {
                    rating:""
                }
                
            }
        }
    },
    methods: {
        savaFilm() {
            this.$store.dispatch('ADD_FILM', this.form);
        },
        getType (val) {
            this.form.typeFilm.name = val.name;
        },
        getGenre (val) {
            this.form.genre.name = val.name;
        },
        getClearType () {
            this.form.typeFilm.name = '';
        },
        getClearGenre () {
            this.form.genre.name = '';
        }
    },
    created() {
        this.$store.dispatch('GET_TYPE_FILM_LIST');
        this.$store.dispatch('GET_GENRE_FILM_LIST');
    },
}
</script>

<style>
.wrapper-admin {
    width: 500px;
    height: 100%;
    background: white;
    overflow: hidden;
    position: relative;
    z-index: 100;
}
.wrapper-admin p {
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
    text-align: center;
    padding: 10px 0 10px;

}
.inputCont{
    z-index: 0;
    padding: 18px 27px;
    display: flex;
    flex-direction: column;
    background: #eee;
}
.inputCont input{
    margin: 9px 0;
    padding: 0 15px;
    height: 42px;
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
    list-style-type: none;
}
.inputCont input:focus{
    outline: 0;
}
.button{
    overflow: hidden;
    text-align: center;
    line-height: 44px;
    min-width: 115px;
    height: 44px;
    text-decoration: none;
    user-select: none;
    background: #fff;
    cursor: pointer;
    text-decoration: none;
    font-family: 'Roboto', sans-serif;
    font-size: 20px;
    font-weight: 300;
    color: black;
    outline: none;
    border: 1px solid #aaa;
}
.button:hover {
    background: #222;
    color: white;
    transition: all 0.3s ease-out;
}
</style>