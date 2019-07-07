<template>
    <div class="wrapper-Slider-Item">
        <div class="filmImage" style="background-size: contain;" :style="{backgroundImage: bgImage}" ></div>
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
        filmStyle: {
            type: String,
            required: true
        },
        filmType: {
            type: String,
            required: true
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
.wrapper-Slider-Item
    margin: 15px
    width: 218px
    height: 451px
    .filmImage
        width: 218px
        height: 330px
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
