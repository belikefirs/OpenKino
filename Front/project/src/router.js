import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
	routes: [
		//Admin
		{
			path: '/admin',
			name: 'admin',
			//component: () => import('./views/Admin.vue')
		},
		{
			path: '/admin/films_editing',
			name: 'filmsEditing',
			component: () => import('./views/AdminFilmsEditing.vue')
		},
		{
			path: '/admin/genre_editing',
			name: 'genreEditing',
			component: () => import('./views/AdminGenreEditing.vue')
		},
		{
			path: '/admin/sessions_editing',
			name: 'sessionsEditing',
			component: () => import('./views/AdminSessionsEditing.vue')
		},
		//Other
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
			path: '/films/FilmsInformation:Pid',
			name: 'FilmsInformation',
			component: () => import('./views/FilmsInformation.vue')
		},
		{
			path: '/films/FilmsInformation:Pid',
			name: 'FilmsInformation',
			component: () => import('./views/FilmsInformation.vue')
		},
		{
			path: '/usercabinet',
			name: 'usercabinet',
			component: () => import('./views/AppUserCabinet.vue')
		},
		{
			path: '/usercabinet/yourcards',
			name: 'yourcards',
			component: () => import('./views/UserCabinetCarts.vue')
		}
		
	],
});
