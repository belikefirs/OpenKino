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
					показываем новинки, ретро и у нас даже есть возможность<br>
					забронировать зал для дружеской компании</p>
				</div>
			</div>
			<div class="block2 b">

			</div>
			<div class="block3 b">

			</div>
			<div class="block4 b">

			</div>
		</div>
	</WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
export default {
	components: {
		WrapperCent
	}
}
</script>

<style lang="sass">
.footer-wrapper
	display: flex
	width: 100%
	height: 300px
	justify-content: center	
	color: white
	.b
		display: flex
		border: 1px solid red
		width: 100%
		height: 100%
	.block1
		flex-direction: column
		.title_1
			font-size: 16px
			margin-bottom: 20px
		.map_our
			border-radius: 20px
		.Our_info
			height: 100%
			font-size: 12px
			u
				font-size: 14px

</style>
