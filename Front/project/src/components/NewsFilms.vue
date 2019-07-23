<template>
	<div class="wrapper-for">
		<WrapperCent class="wrapper-for-title">Подборки для вас</WrapperCent>
		<Slider :pData="sliderArray"></Slider>
	</div>
	
</template>

<script>
import Slider from '@/components/AppSlider.vue'
import WrapperCent from '@/components/AppWrapperCenter.vue'
export default {
}
</script>

<style lang="sass" scoped>
.wrapper-for
	z-index: 0
	&-title
		height: 100%
		line-height: 50px
		background-color: rgba(139, 67, 247, 0.4)
		color: white
</style>
