<template>
	<div class="wrapper-NewsFilm">
		<div class="newTitle">{{newTitle}}</div>
		<div class="filmImage" style="background-size: contain;" :style="{backgroundImage: bgImage}" >
		</div>
		<div class="textCont">
			<p class="filmText">{{filmTitle}}</p>
		</div>
		<div class="textCont">
			<p class="filmTextInfo">{{filmNews}}</p>
		</div>
	</div>
</template>

<script>
export default {
	props:{
		image: {
			type: String,
			required: true
		},
		path: {
			type: String,
			required: true
		},
		filmTitle: {
			type: String,
			required: true
		},
		filmNews: {
			type: String,
			required: true
		},
		newTitle: {
			type: String,
			required: true,
			default: 'Новость сайта'
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
.wrapper-NewsFilm
	margin: 15px
	width: 400px
	height: 420px
	background: rgba(white, 0.4)
	.filmImage
		position: relative
		width: 300px
		height: 200px
	.newTitle
		position: absolute
		top: 5px
		right: 5px
		width: 114px
		height: 30px
		font-size: 14px
		color: white
		line-height: 30px
		background: #F36021
		border-radius: 0 0 0 30px
	.textCont
		display: flex
		align-items: center
		.filmText
			font-family: 'Roboto', sans-serif
			font-size: 16px
			font-weight: 300
			color: white
			width: 400px
			height: 100%
			text-align: center
		.filmTextInfo
			width: 400px
			height: 100%
			font-family: 'Roboto', sans-serif
			font-size: 12px
			font-weight: 300
			color: white
			text-align: center
</style>
