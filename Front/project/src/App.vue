<template>
	<div id="app" v-scroll="onScroll">

		<div class="user" v-if="!isAdminPage">
			<Modal style="z-index: 200" :show="blurFlag" @showBlur="blurFlag = false">
				<template v-slot:content>
					<AppLogReg></AppLogReg>
				</template>
			</Modal>

			<div class="wrapper-user-page">
				<Header :offsetTop="offsetTop" @showBlur="blurFlag = true"></Header>
				<BackToTop v-if="offsetTop > 400" @goTop="goTop"></BackToTop>
				<router-view style="margin-top: 200px"/>
				<Footer></Footer>
			</div>
		</div>


		<div class="admin" v-else>
			<div class="wrapper-admin-page">
				<AdminPanel/>
				<div class="admin-tool">
					<router-view/>
				</div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import AdminPanel from '@/components/AppAdminPanel.vue'

import AppButton from '@/components/AppButton.vue'
import AppLogReg from '@/components/AppLogReg.vue'

import Home from '@/views/Home.vue'
import News from '@/views/News.vue'
import Films from '@/views/Films.vue'
import About from '@/views/About.vue'
import Admin from '@/views/Admin.vue'

import Modal from '@/components/AppModalWindow.vue'
import BackToTop from '@/components/AppButtonToTop.vue'

export default {
	components: {
		Header, Footer, AdminPanel,
		Home, News, Films, About, Admin,
		Modal, BackToTop, AppLogReg, AppButton
	},

	data() {
		return {
			offsetTop: 0,
			blurFlag: false,
			RegFlag: false,
			isAdminPage: false,
		}
	},

	watch:{
		$route(route){
			this.isAdminPage = route.path.indexOf('admin') > -1;
		}
	},

	methods: {
		onScroll () {
			this.offsetTop = window.pageYOffset || document.documentElement.scrollTop;
		},
		goTop () {
			const scroll = window.pageYOffset || document.documentElement.scrollTop;
			scroll = 0
			this.offsetTop = scroll;
		},
	},

	computed: {

	},

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
.wrapper-user-page
	display: flex
	flex-direction: column
	background: #000 url('assets/bg-image.jpg') top no-repeat
.wrapper-admin-page
	display: flex
	flex-direction: row
	background: linear-gradient(60deg, #f42,#24f)
	.admin-tool
		flex: 1
		// display: flex
		// justify-content: center
		// align-items: center
</style>