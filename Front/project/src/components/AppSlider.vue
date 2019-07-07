<template>
    <div class="wrapper-slider" v-resize="onResize">
        <div class="previous" v-on:click="indexCurrent = indexCurrent + 4"></div>
        <SliderItem v-for="(item, index) in forSlider" :key="'item' + index"
        :image="item.image"
        :path="item.path"
        :filmTitle="item.filmTitle"
        :filmStyle="item.filmStyle"
        :filmType="item.filmType"
        />
        <div class="next" v-on:click="indexCurrent++"></div>
    </div>
</template>

<script>
import SliderItem from '@/components/Slider/SliderItem.vue'
export default {
    components: {
        SliderItem
    },
    props:{
        data: {
            type: Array,
            required: true
        }
    },
    data () {
        return {
            indexCurrent : 0,
            maxInPage : 1
        }
    },
    methods:{
        onResize(){
            this.maxInPage = Math.round((document.documentElement.clientWidth - 220) / 248);
        },
    },
    computed:{
        forSlider(){
            this.indexCurrent = this.indexCurrent % this.data.length;
            return this.data.concat(this.data).slice(this.indexCurrent, this.indexCurrent + this.maxInPage);
        },
    }
}
</script>

<style lang="sass" scoped>
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
