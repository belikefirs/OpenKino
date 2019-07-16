import Vue from 'vue';
import Vuex from 'vuex';
import AXIOS from 'axios';

Vue.use(Vuex);

const hall = {
	id: 1,
	width: 50,
	height: 50,
	places: [
		{id: 0, x: 0, y: 0, type: 'Free', value: 1},
		{id: 1, x: 1, y: 0, type: 'Free', value: 2},
		{id: 2, x: 2, y: 0, type: 'Free', value: 3},
		{id: 3, x: 3, y: 0, type: 'Free', value: 4},
		{id: 4, x: 4, y: 0, type: 'NotFree', value: 5},
	],
}

export default new Vuex.Store({
	state: {
		halldata: [],
		typeFilmList: [],
	},
	mutations: {
		setHall (state, data) {
			state.halldata = data
		},
		setTypeFilmList(state, data){
			state.typeFilmList = data;
		},
		setGenreFilmList(state, data){
			state.genreFilmList = data;
		},
	},
	actions: {
		ADD_FILM (context, data) {
			return AXIOS.post("/Film", data);
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
	},
});
