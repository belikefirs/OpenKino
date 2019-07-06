<template>
<!-- акции -->
<!-- отзывы -->
	<div class="wrapper-header" :style="{height: height, background: bg, position: pos}">
		<WrapperCent>
			<router-link to="/" class="logo"></router-link>
			<div style="flex: 2"></div>
			<div class="wrapper-links">
				<AppButton v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
			</div>
			<div class="signIn">
				<div class="signIn-logo"></div>
				<p class="text">Войти</p>
			</div>
		</WrapperCent>
	</div>
	
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenterize.vue'
import AppButton from '@/components/AppButton.vue'

export default {
	components: {
		WrapperCent, AppButton
	},
	props:{
		offsetTop:{
			type: Number, 
			required: true
		}
	},
	watch:{
		'offsetTop'(){
			if (this.offsetTop < this.maxHeight - this.minHeight) {
				this.currentHeight = (this.maxHeight - this.offsetTop);
				//this.pos = "static";
			} else {
				this.currentHeight = this.minHeight;
				//this.pos = "fixed";
			}
			this.bgOpacity = this.minHeight / this.currentHeight;
		}
	},
	data () {
		return {
			maxHeight: 200,
			minHeight: 80,
			currentHeight: 200,
			bgOpacity: 0.4,
			pos: "fixed",
			links: [
				{name: 'Новости', link: 'news'},
				{name: 'Фильмы', link: 'films'},
				{name: 'О нас', link: 'about'},
				{name: 'Еще', link: ''},
			]
		}
	},
	methods:{
		
	},
	computed: {
		height() {
			return this.currentHeight + "px";
		},
		bg() {
			return "rgba(34, 34, 34, " + this.bgOpacity + ")";
		},
		// pos() {
		// 	if (this.Height > this.maxHeight - this.minHeight) return "static";
		// 	else return "fixed";
		// }
	}
}
</script>


<style lang="sass" scoped>
.text
	text-decoration: none
	font-family: 'Roboto', sans-serif
	font-size: 12px
	color: white
.wrapper-header
	top: 0
	width: 100%
	display: flex
	flex-direction: row
	justify-content: space-around
	align-items: center
	transition-delay: 1s
	transition: position 2s
	.logo
		width: 240px
		align-self: stretch
		background: url('../assets/logo.svg') center no-repeat
		background-position: left
		background-size: contain
	.wrapper-links
		display: flex
		margin-right: 56px
	.signIn
		display: flex
		justify-content: center
		align-items: center
		user-select: none
		cursor: pointer
		.signIn-logo
			width: 45px
			height: 45px
			background: url('../assets/signIn-logo.svg')
		&:hover .text
			text-decoration: underline    
</style>
