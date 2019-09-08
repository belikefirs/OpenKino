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
import PageFilms from './modules/PageFilms'

Vue.use(Vuex);

export default new Vuex.Store({
	modules: {
		Films, CabinetUser, Authorization, Hall, Sessions, PageFilms
	},
	state: {
		Title: 'Вход',
		flagEnter: false,
}
});
