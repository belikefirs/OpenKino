<template>
	<div class="wrapper-FilmCard" @click="$emit('click')">
		<div class="filmImage" style="background-size: contain;" :style="{backgroundImage: bgImage}">
			<div class="limitAge">{{limitAge}}+</div>
		</div>
		<div class="textCont">
			<p class="filmText">{{filmTitle}}</p>
		</div>
		<div class="textCont">
			<p class="filmText">{{filmStyle}}</p>
		</div>
		<div class="textCont">
			<p class="filmText">{{filmType}}</p>
		</div>
	</div>
</template>

<script>
export default {
	props:{
		image: {
			type: String,
			required: false
		},
		path: {
			type: String,
			required: false
		},
		filmTitle: {
			type: String,
			required: false
		},
		filmStyle: {
			type: String,
			required: false
		},
		filmType: {
			type: String,
			required: false
		},
		limitAge: {
			type: Number,
			required: false,
			default: 0
		},
		
	},
	computed:{
		bgImage(){
			return "url(" + this.image + ")";
		}
	}
}
</script>

<style lang="sass" scoped>
.wrapper-FilmCard
	margin: 15px
	width: 218px
	height: 451px
	user-select: none
	.filmImage
		position: relative
		width: 218px
		height: 330px
	.limitAge
		position: absolute
		top: 5px
		right: 5px
		width: 30px
		height: 30px
		font-size: 15px
		color: white
		line-height: 30px
		text-align: center
		background: #ff3131
		border-radius: 5px
	.textCont
		display: flex
		align-items: center
		height: 40px
		.filmText
			display: block
			font-family: 'Roboto', sans-serif
			font-size: 16px
			font-weight: 300
			vertical-align: text-bottom
			color: white
</style>
