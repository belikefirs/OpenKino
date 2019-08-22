<template>
	<div class="wrapper-now">
		<WrapperCent class="wrapper-now-title">Сейчас в кино</WrapperCent>
		<!-- <Slider :pData="sliderArray"></Slider> -->
		<uSlider :items="sliderArray">
            <template v-slot:default="slotItem">
				<FilmCard
				:image="slotItem.item.image"
				:path="slotItem.item.path"
				:filmTitle="slotItem.item.filmTitle"
				:filmStyle="slotItem.item.filmStyle"
				:filmType="slotItem.item.filmType"
				:limitAge="slotItem.item.limitAge"
				/>
            </template>
		</uSlider>
	</div>
	
</template>

<script>
import Slider from '@/components/AppSlider.vue'
import WrapperCent from '@/components/AppWrapperCenter.vue'
import uSlider from '@/components/uSlider.vue'
import FilmCard from '@/components/AppFilmCard.vue'
export default {
	components: {
		WrapperCent, Slider, uSlider, FilmCard
	},
	data () {
		return {
			sliderArray: [
				{ 
					id: 0,
					image: "https://images.kinomax.ru/films/4/4327/560x302/p_2ef3fc9.jpg",
					path: "path1",
					filmTitle: "Алладин",
					filmStyle: "Приключения",
					filmType: "2D",
					limitAge: 6,
				},
				{ 
					id: 1,
					image: "https://images.kinomax.ru/films/4/4470/560x302/p_44491c7.jpg",
					path: "path1",
					filmTitle: "Битва за Землю",
					filmStyle: "Фантастика, Экшн",
					filmType: "2D",
					limitAge: 16,
				},
				{ 
					id: 2,
					image: "https://images.kinomax.ru/films/4/4479/560x302/p_53834f0.jpg",
					path: "path1",
					filmTitle: "План побега 3",
					filmStyle: "Экшн, Триллер",
					filmType: "2D",
					limitAge: 18,
				},
				{ 
					id: 3,
					image: "https://images.kinomax.ru/films/4/4477/560x302/p_8157f91.jpg",
					path: "path1",
					filmTitle: "Человек-паук: Вдали от дома",
					filmStyle: "Приключения, Экшн",
					filmType: "2D, 3D",
					limitAge: 12,
				},
				{ 
					id: 4,
					image: "https://images.kinomax.ru/films/4/4456/560x302/p_b351c28.jpg",
					path: "path1",
					filmTitle: "История игрушек 4",
					filmStyle: "Анимация, Приключения",
					filmType: "2D",
					limitAge: 6,
				},
				{ 
					id: 5,
					image: "https://images.kinomax.ru/films/4/4474/560x302/p_9e4a973.jpg",
					path: "path1",
					filmTitle: "Собачья жизнь 2",
					filmStyle: "Семейный",
					filmType: "2D",
					limitAge: 6,
				},
				{ 
					id: 6,
					image: "https://images.kinomax.ru/films/4/4469/560x302/p_da43f15.jpg",
					path: "path1",
					filmTitle: "Проклятье Аннабель 3",
					filmStyle: "Ужасы",
					filmType: "2D",
					limitAge: 18,
				},
				
			]
		}
	}
}
</script>

<style lang="sass" scoped>
.wrapper-now
	z-index: 0
	&-title
		height: 50px
		line-height: 50px
		background-color: rgba(red, 0.4)
		color: white
</style>