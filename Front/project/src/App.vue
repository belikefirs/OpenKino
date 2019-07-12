<template>
<!-- style="filter: blur(30px);" -->
	<div id="app" v-scroll="onScroll">
		<Modal v-if="blurFlag" style="z-index: 200" :width="500" :height="270" @showBlur="blurFlag = false">
			<template v-slot:title>Вход</template>
			<template v-slot:content>
				<AppSignIn></AppSignIn>
			</template>
		</Modal>	
		
		<div class="wrapper-page">
			<Header :offsetTop="offsetTop" @showBlur="blurFlag = true"></Header>
			<BackToTop v-if="offsetTop > 400" @goTop="goTop"></BackToTop>
			<div id="page">
				<router-view/>
			</div>
			
			<Footer></Footer>
		</div>
		
	</div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import AppSignIn from '@/components/AppSignIn.vue'
import Home from '@/views/Home.vue'
import News from '@/views/News.vue'
import Films from '@/views/Films.vue'
import About from '@/views/About.vue'
import Modal from '@/components/AppModalWindow.vue'
import BackToTop from '@/components/AppButtonToTop.vue'
import Registration from '@/components/AppRegistration.vue'

export default {
	components: {
		Header, Footer, Home, News, Films, About, Modal, BackToTop, AppSignIn
	},

	data() {
		return {
			offsetTop: 0,
			blurFlag: false
		}
	},

	methods: {
		onScroll (e) {
			this.offsetTop = window.pageYOffset || document.documentElement.scrollTop;
		},
		goTop () {
			const scroll = window.pageYOffset || document.documentElement.scrollTop;
			scroll = 0
			this.offsetTop = scroll;

		}
	},

	computed: {
		// news () {
		// 	return this.$store.state.news;
		// },
	},
	// created () {
	// 	this.$store.dispatch('fetchGetNews')
	// }
	mounted () {
		this.$store.dispatch('TEXT')
		.then(hall => {console.log('APP', hall.data)})
		.catch()
	}
}
</script>

<style lang="sass">
*
	margin: 0
	padding: 0
	box-sizing: border-box
	overflow: none
#app
	display: flex
	flex-direction: column
	-webkit-font-smoothing: antialiased
	-moz-osx-font-smoothing: grayscale
	font-family: 'Roboto', sans-serif
	font-size: 18px
	font-weight: 300
	background: #fff
.wrapper-page
	width: 100%
	display: flex
	flex-direction: column
	background: #000 url('assets/bg-image.jpg') top no-repeat
#page
	margin-top: 200px
	width: 100%
	//min-height: 150vh
</style>

<style>
	.blur{
		filter: blur(15px)
	}
</style>