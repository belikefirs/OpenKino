<template>
	<div class="wrapper-actions">
		<WrapperCent class="wrapper-actions-title">Акции</WrapperCent>
		<Slider :pData="sliderArray"></Slider>
	</div>
	
</template>

<script>
import Slider from '@/components/Slider/AppSlider.vue'
import WrapperCent from '@/components/AppWrapperCenter.vue'
export default {
	components: {
		WrapperCent, Slider
	},
	data () {
		return {
			sliderArray: [
				{ 
					image: "https://images.kinomax.ru/films/4/4327/560x302/p_2ef3fc9.jpg",
					path: "path1",
					filmTitle: "Алладин",
					filmStyle: "Приключения",
					filmType: "2D",
				},
				{ 
					image: "https://images.kinomax.ru/films/4/4470/560x302/p_44491c7.jpg",
					path: "path1",
					filmTitle: "Битва за Землю",
					filmStyle: "Фантастика, Экшн",
					filmType: "2D",
				},
				{ 
					image: "https://images.kinomax.ru/films/4/4479/560x302/p_53834f0.jpg",
					path: "path1",
					filmTitle: "План побега 3",
					filmStyle: "Экшн, Триллер",
					filmType: "2D",
				},
				{ 
					image: "https://images.kinomax.ru/films/4/4477/560x302/p_8157f91.jpg",
					path: "path1",
					filmTitle: "Человек-паук: Вдали от дома",
					filmStyle: "Приключения, Экшн",
					filmType: "2D, 3D",
				},
				{ 
					image: "https://images.kinomax.ru/films/4/4456/560x302/p_b351c28.jpg",
					path: "path1",
					filmTitle: "История игрушек 4",
					filmStyle: "Анимация, Приключения",
					filmType: "2D",
				},
				{ 
					image: "https://images.kinomax.ru/films/4/4474/560x302/p_9e4a973.jpg",
					path: "path1",
					filmTitle: "Собачья жизнь 2",
					filmStyle: "Семейный",
					filmType: "2D",
				},
				{ 
					image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
					path: "path1",
					filmTitle: "Проклятье Аннабель 3",
					filmStyle: "Ужасы",
					filmType: "2D",
				},
				
			]
		}
	}
}
</script>

<style lang="sass" scoped>
.wrapper-actions
	z-index: 0
	background: #000 url('../../assets/bg-image2.jpg') center no-repeat
	background-size: cover
	&-title
		height: 50px
		line-height: 50px
		background-color: rgba(red, 0.4)
		color: white
</style>