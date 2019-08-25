import Vue from 'vue';
import Vuex from 'vuex';
import AXIOS from 'axios';
import { request } from 'https';
//modules
import Films from './modules/Films.js'
import CabinetUser from './modules/CabinetUser.js'
import Hall from './modules/Hall.js'
import Authorization from './modules/Authorization.js'
import Sessions from './modules/Sessions.js'

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
	modules: {
		Films, CabinetUser, Authorization, Hall, Sessions,
	},
	state: {
		Title: 'Максим',
		// Test
		films: [
			{ 
				image: "https://images.kinomax.ru/films/4/4327/560x302/p_2ef3fc9.jpg",
				filmTitle: "Алладин",
				filmStyle: "Приключения",
				filmType: "2D",
				limitAge: 6,
				filmId: 1
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4470/560x302/p_44491c7.jpg",
				filmTitle: "Битва за Землю",
				filmStyle: "Фантастика, Экшн",
				filmType: "2D",
				limitAge: 16,
				filmId: 2
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4479/560x302/p_53834f0.jpg",
				filmTitle: "План побега 3",
				filmStyle: "Экшн, Триллер",
				filmType: "2D",
				limitAge: 18,
				filmId: 3
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4477/560x302/p_8157f91.jpg",
				filmTitle: "Человек-паук: Вдали от дома",
				filmStyle: "Приключения, Экшн",
				filmType: "2D, 3D",
				limitAge: 12,
				filmId: 4
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4456/560x302/p_b351c28.jpg",
				filmTitle: "История игрушек 4",
				filmStyle: "Анимация, Приключения",
				filmType: "2D",
				limitAge: 6,
				filmId: 5
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4474/560x302/p_9e4a973.jpg",
				filmTitle: "Собачья жизнь 2",
				filmStyle: "Семейный",
				filmType: "2D",
				limitAge: 6,
				filmId: 6
			},
			{ 
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				filmTitle: "Проклятье Аннабель 3",
				filmStyle: "Ужасы",
				filmType: "2D",
				limitAge: 18,
				filmId: 7
			},
		],
}
});
