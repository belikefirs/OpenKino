import Vue from 'vue';
import Vuex from 'vuex';
import AXIOS from 'axios';
Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		// news: []
	},
	getters:{

	},
	mutations: {
		// setNews (state, data) {
		// 	state.news = data
		// }
	},
	actions: {
		// fetchGetNews (contex, params) {
		// 	AXIOS.get('/news').finally(request => {
		// 		contex.commit('setNews', [
		// 		{name: 'news 1', id: 1},
		// 		{name: 'news 21', id: 21},
		// 		{name: 'news 31', id: 31},
		// 		])
		// 	})
		// }
	},
});
