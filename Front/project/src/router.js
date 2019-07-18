import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
	routes: [
		{
			path: '/',
			name: 'home',
			component: Home,
		},
		{
			path: '/news',
			name: 'news',
			component: () => import('./views/News.vue')
		},
		{
			path: '/films',
			name: 'films',
			component: () => import('./views/Films.vue'),
		},
		{
			path: '/about',
			name: 'about',
			component: () => import('./views/About.vue')
		},
		{
			path: '/admin/add',
			name: 'addFilm',
			component: () => import('./views/AdminFilmAdd.vue')
		},
		{
			path: '/admin/show',
			name: 'showFilm',
			component: () => import('./views/AdminChangeFilms.vue')
		},
		
	],
});
