<template>
	<div id="app" v-scroll="onScroll">
		<div class="wrapper-page">
			<Header :offsetTop="offsetTop"></Header>
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
import PageAuthorization from '@/components/PageAuthorization.vue'
import Home from '@/views/Home.vue'
import News from '@/views/News.vue'
import Films from '@/views/Films.vue'
import About from '@/views/About.vue'

export default {
	components: {
		Header, Footer, PageAuthorization, Home, News, Films, About
	},

	data() {
		return {
			offsetTop: 0
		}
	},

	methods: {
		onScroll (e) {
			this.offsetTop = window.pageYOffset || document.documentElement.scrollTop;
		}
	},

	computed: {
		news () {
			return this.$store.state.news;
		},
	},
	created () {
		this.$store.dispatch('fetchGetNews')
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
	font-family: 'Roboto'
	background: #fff url('assets/bg-image.jpg') top no-repeat
.wrapper-page
	margin-top: 200px
	width: 100%
	display: flex
	flex-direction: column
#page
	width: 100%
	//min-height: 150vh
	
</style>