import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
	mode: 'history',
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
			component: () => import('./views/FilmsInformation.vue'),
			props: true
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
		},
		{
			path: '/usercabinet/buy',
			name: 'buy',
			component: () => import('./views/UserCabinetBuy.vue')
		},
		{
			path: '/films/FilmSession:Sid',
			name: 'FilmSession',
			component: () => import('./views/FilmSession.vue'),
			props: true
		},
	]
	
});
