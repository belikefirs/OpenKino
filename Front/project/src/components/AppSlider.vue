<template>
    <div class="wrapper-slider" v-resize="onResize">
        <div class="previous" v-on:click="prevClick"></div>
        <transition-group name="slider" class="slider">
            <SliderItem
            v-for="(item, name) in uData" :key="name"
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
    watch:{
        'uIndex'(){},
        'uData'(){}
    },
    data () {
        let uData = [];
        this.pData.forEach(function(item, index){
            uData[index] = item;
        });
        return {
            uIndex : 0,
            maxInPage : 1,
            uData
        }
    },
    methods:{
        onResize(){
            this.maxInPage = Math.round((document.documentElement.clientWidth - 220) / 248);
        },
        nextClick(){
            //this.uIndex = (this.uIndex + 1) % this.uData.length;
            this.uData.unshift(this.uData.pop());
        },
        prevClick(){
            //this.uIndex = (this.uData.length + this.uIndex - 1) % this.uData.length;
            this.uData.push(this.uData.shift());
        }
    },
    computed:{
        
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
    .slider
        display: flex
        flex-direction: row
</style>


<style>
.list-item {
  display: inline-block;
  margin-right: 10px;
}
.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to /* .list-leave-active до версии 2.1.8 */ {
  opacity: 0;
  transform: translateY(30px);
}
</style>
