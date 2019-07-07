<template>
	<WrapperCent style="background: #212121">
		<div class="footer-wrapper">
			<div class="block1 b">
				<div class="title_1">
					<p>Мы находимся</p>
				</div>
				<div class="map_our">
					<iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A6ac60f48d30a3bb5f9c2a48637f5bf13073315e990b2f3eb7c111d92824aba5b&amp;source=constructor" 
					width="280" height="131" frameborder="1">
					</iframe>
				</div>
				<div class="Our_info">
					<p><u>О нас</u><br>
					У нас Вы найдете море интересных фильмов, мы<br>
					показываем новинки, ретро и у нас даже есть возможность
					забронировать зал для дружеской компании</p>
				</div>
			</div>
			<div class="block2 b">
				<div class="title_2">
					<p>Карта сайта</p>
				</div>
				<div class="column_left">
				<AppButton style="margin: 0 0 10px;" v-for="item in Foot_links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
				</div>
				<div class="column_right">
				<AppButton style="margin: 0 0 10px;" v-for="item in Foot_links_2" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
				</div>
			</div>
			<div class="block3 b">
				<div class="title_3">
					<p>Мы в социальных сетях</p>
				</div>
				<div class="icons">
					<a href="#"><img src="assets/icons/vk.png" alt=""></a>
					<a href="#"><img src="" alt=""></a>
					<a href="#"><img src="" alt=""></a>
					<a href="#"><img src="" alt=""></a>
				</div>
			</div>
			<div class="block4 b">
				<div class="title_4">
					<p>Наши фесты</p>
				</div>
				<AppButton style="margin: 0 0 10px;" v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
			</div>
		</div>
	</WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
import AppButton from '@/components/AppButton.vue'
export default {
	components: {
		WrapperCent, AppButton
	},
	data () {
		return {
			links: [
				{name: 'Новости', link: ' '},
				{name: 'Фильмы', link: ' '},
			],
			Foot_links: [
				{name: 'Фильмы', link: ' '},
				{name: 'Новости', link: ' '},
				{name: 'Вакансии', link: ' '},
				{name: 'Вакансии', link: ' '},
			],
			Foot_links_2: [
				{name: 'Наши встречи', link: ' '},
				{name: 'Планы', link: ' '},				
				{name: 'Авторизация', link: ' '},
				{name: 'Отзывы', link: ' '},
			]
		}
	}
}

</script>

<style lang="sass">
.footer-wrapper
	display: flex
	width: 100%
	height: 300px
	.b
		//border: 1px solid red
		width: 100%
		height: 100%
	.block1
		display: flex
		flex-direction: column
		.title_1
			color: white
			margin-top: 30px
			font-size: 16px
			margin-bottom: 20px
		.map_our
			border-radius: 20px
		.Our_info
			color: white
			height: 100%
			font-size: 12px
			u
				font-size: 14px
	.block2
		position: relative
		color: white
		display: flex
		.title_2
			flex-direction: row
			flex-grow: 1
			color: white
			margin-top: 30px
			font-size: 16px
			margin-bottom: 20px
		.column_left
			position: absolute
			left: 0px
			top: 68px
		.column_right
			position: absolute
			left: 130px
			top: 68px
	.block3
		.title_3
			color: white
			margin-top: 30px
			font-size: 16px
			margin-bottom: 20px
	.block4
		.title_4
			color: white
			margin-top: 30px
			font-size: 16px
			margin-bottom: 20px
</style>
