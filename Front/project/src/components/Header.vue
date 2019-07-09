<template>
<!-- акции -->
<!-- отзывы -->
	<WrapperCent style="top: 0; position: fixed; z-index: 100" :style="{height: height, background: bg}">
		<div class="wrapper-header">
			<router-link to="/" class="logo"></router-link>
			<div style="flex: 2"></div>
			<AppButton style="margin: 0 10px" v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
			<div class="signIn" v-on:click="changeBlur">
				<div class="signIn-logo"></div>
				<p class="text">Войти</p>
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
			} else {
				this.currentHeight = this.minHeight;
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
			links: [
				{name: 'Новости', link: 'news'},
				{name: 'Фильмы', link: 'films'},
				{name: 'О нас', link: 'about'},
				{name: 'Еще', link: ''},
			]
		}
	},
	methods:{
		changeBlur(){
			this.$emit("showBlur");
		}
	},
	computed: {
		height() {
			return this.currentHeight + "px";
		},
		bg() {
			return "rgba(31, 31, 31, " + this.bgOpacity + ")";
		},
	}
}
</script>


<style lang="sass" scoped>
.text
	text-decoration: none
	font-family: 'Roboto', sans-serif
	font-size: 14px
	font-weight: 100
	color: white
.wrapper-header
	height: 100%
	display: flex
	justify-content: space-around
	align-items: center
	.logo
		width: 240px
		align-self: stretch
		background: url('../assets/logo.svg') center no-repeat
		background-position: left
		background-size: contain
	.signIn
		margin-left: 56px
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
