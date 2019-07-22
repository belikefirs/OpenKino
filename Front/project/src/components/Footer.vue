<template>
	<WrapperCent style="background: #212121">
		<div class="footer-wrapper">
			<div class="block">
				<div class="title">
					<p>Мы находимся</p>
				</div>
				<div class="map_our">
					<Map></Map>
				</div>
				<div class="our_info">
					<p><u>О нас</u><br><br>
					У нас Вы найдете море интересных фильмов, мы<br>
					показываем новинки, ретро и у нас даже есть возможность
					забронировать зал для дружеской компании</p>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<p>Карта сайта</p>
				</div>
				<div class="map_links">
					<AppButton style="margin: 0 10px 10px 0;" v-for="(item, key) in Foot_links" :key="key" :url="{name: item.link}">{{item.name}}</AppButton>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<p>Мы в социальных сетях</p>
				</div>
				<div class="icons">
					<a v-for="item in images" :key="item" href="#"><img :src="item" alt=""></a>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<p>Наши фесты</p>
				</div>
				<AppButton style="margin: 0 10px 0 0;" v-for="(item, key) in links" :key="key" :url="{name: item.link}">{{item.name}}</AppButton>
			</div>
		</div>
	</WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
import AppButton from '@/components/AppButton.vue'
import vk from "./../assets/temp/icons/vk.png"
import twitter from "./../assets/temp/icons/twitter.png"
import gp from "./../assets/temp/icons/google-plus.png"
import instagram from "./../assets/temp/icons/instagram.png"
import Map from '@/components/AppMap.vue'


export default {
	components: {
		WrapperCent, AppButton, Map
	},
	data () {
		return {
			links: [
				{name: 'Новости', link: '#'},
				{name: 'Фильмы', link: '#'},
			],
			Foot_links: [
				{name: 'Фильмы', link: '#'},
				{name: 'Новости', link: '#'},
				{name: 'Вакансии', link: '#'},
				{name: 'Вакансии', link: '#'},
				{name: 'Наши встречи', link: '#'},
				{name: 'Планы', link: '#'},				
				{name: 'Авторизация', link: '#'},
				{name: 'Отзывы', link: '#'},
			],
			images: [
				vk, twitter, gp, instagram
			]
		}
	},
	methods: {
		map_cinema(){

		}
	}
}

</script>

<style lang="sass">
.title
	color: white
	margin-top: 30px
	font-size: 16px
	margin-bottom: 20px
.footer-wrapper
	display: flex
	width: 100%
	height: 100%
	overflow: hidden
	.block
		width: 25%
		padding: 10px		
		.map_our
			border-radius: 20px
			iframe
				width: 87%
		.map_links
			display: flex
			flex-direction: row
			flex-wrap: wrap
		.our_info
			color: white
			height: 100%
			font-size: 12px
			u
				font-size: 14px
</style>
