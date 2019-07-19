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

		// Test
		films: [
			{ 
				image: "https://images.kinomax.ru/films/4/4327/560x302/p_2ef3fc9.jpg",
				path: "path1",
				filmTitle: "Алладин",
				filmStyle: "Приключения",
				filmType: "2D",
				limitAge: 6,
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4470/560x302/p_44491c7.jpg",
				path: "path1",
				filmTitle: "Битва за Землю",
				filmStyle: "Фантастика, Экшн",
				filmType: "2D",
				limitAge: 16,
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4479/560x302/p_53834f0.jpg",
				path: "path1",
				filmTitle: "План побега 3",
				filmStyle: "Экшн, Триллер",
				filmType: "2D",
				limitAge: 18,
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4477/560x302/p_8157f91.jpg",
				path: "path1",
				filmTitle: "Человек-паук: Вдали от дома",
				filmStyle: "Приключения, Экшн",
				filmType: "2D, 3D",
				limitAge: 12,
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4456/560x302/p_b351c28.jpg",
				path: "path1",
				filmTitle: "История игрушек 4",
				filmStyle: "Анимация, Приключения",
				filmType: "2D",
				limitAge: 6,
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4474/560x302/p_9e4a973.jpg",
				path: "path1",
				filmTitle: "Собачья жизнь 2",
				filmStyle: "Семейный",
				filmType: "2D",
				limitAge: 6,
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				path: "path1",
				filmTitle: "Проклятье Аннабель 3",
				filmStyle: "Ужасы",
				filmType: "2D",
				limitAge: 18,
			},
		],
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
		addToLocalFilm(state, data){
			state.films.push({ 
				image: "https://images.kinomax.ru/films/4/4327/560x302/p_2ef3fc9.jpg",
				path: "path1",
				filmTitle: data.name,
				filmStyle: data.genre.name,
				filmType: data.typeFilm.name,
				limitAge: data.limitAge.age,
			});
		},
	},
	actions: {
		ADD_FILM (context, data) {
			context.commit('addToLocalFilm', data);
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
