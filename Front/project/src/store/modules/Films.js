import AXIOS from 'axios';

const state = {
    typeFilmList: [],
    genreFilmList: [],
    ratingFilmList: [],
    limitAgeFilmList: [],
    filmList: [],
}

const mutations = {
    setTypeFilmList(state, data){
        state.typeFilmList = data;
    },
    setRatingFilmList(state, data){
        state.ratingFilmList = data;
    },
    setGenreFilmList(state, data){
        state.genreFilmList = data;
    },
    setLimitAgeFilmList(state, data){
        state.limitAgeFilmList = data;
    },
    setFilmList(state, data){
        state.filmList = data;
    },
    addImageFilm(state, data){
        state.filmList.find(item => item.id == data.id).image = data.image;
    },
}

const actions = {
    ADD_FILM (context, filmData) {
        return AXIOS.post("/Film/save", filmData.film).then(({data}) => {
            const formData = new FormData();
            formData.append('id', data);
            formData.append('file', filmData.image);
            AXIOS.post('Film/load', formData);
        });
    },
    CHANGE_FILM(context, data){
        return AXIOS.put('/Film', data);
    },
    DELETE_FILM(context, data){
        return AXIOS.delete('/Film/' + data.id);
    },
    GET_RATING_FILM_LIST(context){
        return AXIOS.get('/Film/rating').then(({data}) => {
            context.commit('setRatingFilmList', data);
        });
    },
    GET_TYPE_FILM_LIST (context) {
        return AXIOS.get('/Film/type').then(({data}) => {
            context.commit('setTypeFilmList', data);
        });
    },
    GET_GENRE_FILM_LIST (context) {
        return AXIOS.get('/Film/genre').then(({data}) => {
            context.commit('setGenreFilmList', data);
        });
    },
    GET_LIMIT_AGE_FILM_LIST(context){
        return AXIOS.get('/Film/limitAge').then(({data}) => {
            context.commit('setLimitAgeFilmList', data);
        });
    },
    GET_FILMS_WITH_FILTERS(context, data){
        let params = {};
        Object.keys(data).forEach(key => {
            params[key] = data[key];
        });
        return AXIOS.get('/Film', {params}).then(({data}) => {
            context.commit('setFilmList', data.map(item => {return {...item, image: null}}));
            data.forEach(film => {
                context.dispatch('GET_IMAGE', film.id);
            });
        });
    },
    GET_IMAGE(context, filmId){
        return AXIOS.get('Film/get-image', {params: {id: filmId} }).then(({data}) =>{
            let img = new Blob([JSON.stringify(data)]).toString();
        	context.commit('addImageFilm', {id: filmId ,image: `data:image/jpeg;base64,${img.substring(1)}`});
        });
    },
}

export default {
    namespaced: true,
    state, mutations, actions
}