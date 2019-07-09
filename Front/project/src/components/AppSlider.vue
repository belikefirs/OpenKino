<template>
    <div class="wrapper-slider" v-resize="onResize">
        <div class="previous" v-on:click="prevClick"></div>
        <transition-group name="slider" tag="div">
            <SliderItem v-for="item in uData" :key="item"
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
            type: Array,
            required: true
        }
    },
    data () {
        let uData = [];
        this.pData.forEach(function(item, index){
            uData[index] = item;
        });
        return {
            maxInPage : 1,
            uData
        }
    },
    methods:{
        onResize(){
            this.maxInPage = Math.round((document.documentElement.clientWidth - 220) / 248);
        },
        nextClick(){
            this.uData.push(this.uData.shift());
        },
        prevClick(){
            this.uData.unshift(this.uData.pop());
        }
    },
    computed:{
        
    }
}
</script>

<style lang="sass" scoped>
// .slider-move
//     transition: transform 1s
// .slider-enter-active, .slider-leave-active 
//     transition: all 1s
// .slider-enter, .slider-leave-to
//     opacity: 0
//     transform: translateY(30px)
.wrapper-slider
    position: relative
    width: 100%
    height: 466px
    background: rgba(#212121, 0.4)
    &>div
        width: 100%
        height: 100%
        display: flex
        flex-direction: row
        justify-content: center
    .previous, .next
        z-index: 1
        position: absolute
        top: calc(50% - 15px)
        width: 30px
        height: 30px
        border-radius: 15px
        background: #ff0000
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25)
        cursor: pointer
        user-select: none
        &:active
            background: white
    .previous
        left: 35px
    .next
        right: 35px        
</style>

<style scoped>
.slider-move{
    transition: transform 1s;
}
.slider-complete-item {
  transition: all 1s;
  display: inline-block;
  margin-right: 10px;
}
.slider-complete-enter, .slider-complete-leave-to
/* .list-complete-leave-active до версии 2.1.8 */ {
  opacity: 0;
  transform: translateY(30px);
}
.slider-complete-leave-active {
  position: absolute;
}
</style>
