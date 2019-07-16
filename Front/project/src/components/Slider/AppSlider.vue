<template>
    <div class="wrapper-slider" v-resize="onResize">
        <div class="previous" v-on:click="prevClick">
            <div class="arrow"></div>
        </div>
        <transition-group name="slider" tag="div" mode="out-in">
            <SliderItem v-for="item in uData" :key="item.filmTitle"
            :image="item.image"
            :path="item.path"
            :filmTitle="item.filmTitle"
            :filmStyle="item.filmStyle"
            :filmType="item.filmType"
            :limitAge="item.limitAge"
            />
        </transition-group>
        <div class="next" v-on:click="nextClick">
            <div class="arrow"></div>
        </div>
    </div>
</template>

<script>
import SliderItem from '@/components/Slider/SliderItem.vue'
import { setTimeout } from 'timers';
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
            uData,
            animFlag : false,
        }
    },
    methods:{
        onResize(){
            this.maxInPage = Math.round((document.documentElement.clientWidth - 220) / 248);
        },
        nextClick(){
            if (this.animFlag) return;
            this.animFlag = true;
            let temp = this.uData.shift();
            setTimeout(() => {
                this.uData.push(temp);
            }, 300);
            setTimeout(() => {
                this.animFlag = false;
            }, 650);
        },
        prevClick(){
            if (this.animFlag) return;
            this.animFlag = true;
            let temp = this.uData.pop();
            setTimeout(() => {
                this.uData.unshift(temp);
            }, 300);
            setTimeout(() => {
                this.animFlag = false;
            }, 650);
        },
    },
    computed:{
        
    }
}
</script>

<style scoped>
.slider-enter, .slider-leave-to{
    opacity: 0;
    transform: scale(0.3);
}
.slider-enter-to, .slider-leave{
    opacity: 1;
}
.slider-enter-active, .slider-leave-active{
    transition: all 0.5s;
    transform-origin: center 165px;
}
.slider-move{
    transition: transform 0.5s;
}
</style>

<style lang="sass" scoped>
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
        width: 50px
        height: 50px
        border-radius: 50px
        background: #ff0000
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25)
        cursor: pointer
        user-select: none
        &:active
            background: black 
        .arrow
            width: 100%
            height: 100%
            background: url('../../assets/arrow.svg') center no-repeat
            background-size: 25%
            // display: flex
            // justify-content: center
            // align-items: center
            // &::before, &::after
            //     content: ""
            //     position: absolute
            //     transform-origin: right
            //     width: 15px
            //     height: 1px
            //     background: #fff
            //     box-shadow: 0px 4px 4px black
            // &::before
            //     transform: rotate(30deg)
            // &::after
            //     transform: rotate(-30deg)   
    .previous
        left: 35px
        .arrow
            transform: scaleX(-1)
    .next
        right: 35px        
</style>

