import Vue from 'vue';
import Vuex from 'vuex';
import AXIOS from 'axios';
import { request } from 'https';

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
		halldata: null,
		typeFilmList: [],
		genreFilmList: [],
		ratingFilmList: [],
		limitAgeFilmList: [],
		filmList: [],
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
		newsFilm: [
			{
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				path: "path1",
				filmTitle: "На Кипре обнаружили стереоскопических Таноса и Тони Старка",
				filmNews: "В городе Лимасол, Кипр, неизвестные художники нарисовали на стене одного из зданий впечатляющий стереоскопический мурал, с изображениями двух главных персонажей фильмов Мстители 3: Война бесконечности и Мстители 4: Финал - Тони Старка и Таноса...",
				newTitle: "Новость кино",
			},
			{
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				path: "path1",
				filmTitle: "Ученые объяснили успех киновселенной Marvel",
				filmNews: "Ученые из Университета Аделаиды использовали математическую модель, чтобы оценить причины феноменального успеха у зрителей киновселенной Marvel и пришли к выводу, что они в значительно меньшей степени кроются в визуальных эффектах и действии и в большей - в умелом манипулировании большим актерским составом и продуманными сюжетными линиями...",
				newTitle: "Новость кино",
			},
			{
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				path: "path1",
				filmTitle: "Автор Маски призвал создать женскую версию фильма",
				filmNews: "Создатель комиксов о Маске Майк Ричардсон уверен, что пришло время создать римейк знаменитого фильма с участием Джима Керри, но в этот раз главную роль стоит доверить женщине. Об этом он рассказал в беседе с корреспондентами издания Forbes...",
				newTitle: "Новость кино",
			},
			{
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				path: "path1",
				filmTitle: "ОгласКА. Рецензия Киноакадемии на фильм Доброе сердце",
				filmNews: "Наше путешествие по бескрайнему морю кинематографа продолжается. В этот раз наша команда наткнулась на проект режиссера Дагюра Каури Доброе сердцe 2009 года выпуска. И надо сказать, что с самого начала пути мы ожидали встретить странные авторские работы, но не так скоро.",
				newTitle: "Наше кино",
			},
			{
				image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
				path: "path1",
				filmTitle: "Собираем пользовательскую рецензию на фильм Человек-паук: Вдали от дома",
				filmNews: "Фильм Человек-паук: Вдали от дома вызвал почти единодушное одобрение западных кинокритиков, выразившееся в 92-балльном рейтинге портала Rotten Tomatoes...",
				newTitle: "Новость сайта",
			}
		]
	},
	mutations: {
		//Films
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
		//Other
		setHall (state, data) {
			state.halldata = data
		},
		showHall(state, data) {
			state.halldata = data
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
		//FILMS
		ADD_FILM (context, filmData) {
			context.commit('addToLocalFilm', filmData.film);
			return AXIOS.post("/Film", filmData.film).then(({data}) => {
				const formData = new FormData();
				formData.append('file', filmData.image);
				formData.append('id', data);
				AXIOS.post('Film/load', formData);
			});
		},
		CHANGE_FILM(context, data){
			context.commit('addToLocalFilm', data);
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
			context.commit('addImageFilm', {id: filmId ,image: `Film/get-image?id=${filmId}`});
			// return AXIOS.get('Film/get-image', {params: {id: filmId}}).then(({data, headers}) =>{
			// 	// let img = new Blob([JSON.stringify(data)]).toString();
				
			// 	// context.commit('addImageFilm', {id: filmId ,image: `data:image/jpeg;base64,${img.substring(1)}`});
			// });
		},
		//AUTH
		AUTHORIZATION_LOGIN (context, data) {
			return AXIOS.post('/auth', data).then((response) => {
				//context.commit('putLogin', data);
				console.log(response);
				var str = response.headers.authorization;
				localStorage.setItem('token', str.substring(7));
			});
		},
		AUTHORIZATION_REG (context, data) {
			return AXIOS.post('KinoUser/save', data).then((response) => {
				console.log(response);
			});
		},
		GET_HALL (context) {
			return AXIOS.get('/hall/get/6').then(({data}) => {
				return data;
			})
		},
		BALANCE_UP (context, data) {
			const authHeader = localStorage.getItem('token')
			return AXIOS.post('/card', data, { headers: {
				Authorization: 'Bearer ' + authHeader
			}}).then((response) => {

			})
		},
		GET_LIST_CARDS (context, data) {
			return AXIOS.get('/card/allByKInoUser', data).then((response) => {
					
			})
		}
	},
});
