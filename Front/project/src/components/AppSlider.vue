<template>
    <div class="wrapper-slider" v-resize="onResize">
        <div class="previous" v-on:click="prevClick"></div>
        <transition-group name="slider">
            <SliderItem
            v-for="(item, name, index) in uData" :key="name"
            :image="item.image"
            :path="item.path"
            :filmTitle="item.filmTitle"
            :filmStyle="item.filmStyle"
            :filmType="item.filmType"
            />
        </transition-group>
        <div class="next" v-on:click="nextClick"></div>
    </div>
</template>

<script>
import SliderItem from '@/components/Slider/SliderItem.vue'
export default {
    components: {
        SliderItem
    },
    props:{
        pData: {
            type: Object,
            required: true
        }
    },
    data () {
        return{
            uIndex : 0,
            maxInPage : 1,
            uData: this.pData
        }
    },
    methods:{
        onResize(){
            this.maxInPage = Math.round((document.documentElement.clientWidth - 220) / 248);
        },
        forSlider(){
            this.uIndex = this.uIndex % this.uData.length;
            this.data.concat(this.data).slice(this.indexCurrent, this.indexCurrent + this.maxInPage);
        },
        nextClick(){
            this.uIndex++;
        },
        prevClick(){
            this.uIndex = this.maxInPage - this.uIndex;
        }
    },
    computed:{
        
    }
}
</script>

<style lang="sass" scoped>
.slider-enter-active 
    transition: all .3s ease
.slider-leave-active 
    transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0)
.wrapper-slider
    position: relative
    width: 100%
    height: 466px
    background: rgba(#212121, 0.4)
    display: flex
    justify-content: center
    .previous, .next
        position: absolute
        top: calc(50% - 15px)
        width: 30px
        height: 30px
        border-radius: 15px
        background: #ff0000
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25)
        cursor: pointer
        user-select: none
    .previous
        left: 35px
    .next
        right: 35px
</style>
