<!-- slots: item, leftBtn, rightBtn -->

<template>
    <div class="uSlider">
        <slot name="title"></slot>
        <transition-group class="uSlider-itemHolder" :name="sliderClass" tag="div" mode="out-in">
            <div class="uSlider-itemHolder-item"
            v-for="item in items" :key="item.id">
                <slot name="item" :item="item"></slot>
            </div>
        </transition-group>
        
        <div class="leftBtnHolder">
            <div class="btn" @click="leftClick">
                <slot name="leftBtn">
                    <div class="temBtn"></div>
                </slot>
            </div> 
        </div>
        <div class="rightBtnHolder">
           <div class="btn" @click="rightClick">
               <slot name="rightBtn">
                    <div class="temBtn"></div>
                </slot>
           </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        items: {type: Array},
    },
    data() {
        return {
            sliderClass: '',
        }
    },
    methods:{
        leftClick(){
            this.sliderClass = 'leftSL';
            let temp = this.items.pop();
            setTimeout(() => {
                this.items.unshift(temp);
            }, 0);
        },
        rightClick(){
            this.sliderClass = 'rightSL';
            let temp = this.items.shift();
            setTimeout(() => {
                this.items.push(temp);
            }, 0);
        },
    }
}
</script>

<style lang="sass">
.leftSL-enter 
    opacity: 0
    transform: translateX(-100%)
.leftSL-leave-to
    opacity: 0
    transform: translateX(100%)
.rightSL-enter 
    opacity: 0
    transform: translateX(100%)
.rightSL-leave-to 
    opacity: 0
    transform: translateX(-100%)
.leftSL-enter-active, .leftSL-leave-active,
.rightSL-enter-active, .rightSL-leave-active
    transition-property: opacity, transform
    transition-duration: 0.5s
.leftSL-move, .rightSL-move
    transition: transform 0.5s

.uSlider
    // padding: 10px
    // background: repeating-linear-gradient(45deg, #444, #444 10px, #222 10px, #222 20px)
    position: relative
    overflow: hidden
    &-itemHolder
        // margin: 40px
        display: flex
        flex-direction: row
        justify-content: center
        align-items: center
        transition: width 10s
    .leftBtnHolder, .rightBtnHolder
        position: absolute
        top: 0
        width: 80px
        height: 100%
        display: flex
        justify-content: center
        align-items: center
        .btn
            .temBtn
                width: 35px
                height: 100px
                border: 1px solid #aaa
                border-radius: 4px
                background: #222
                overflow: hidden
                &::before
                    content: ''
                    position: absolute
                    top: calc(50% - 15px)
                    width: 30px
                    height: 30px
    .leftBtnHolder
        left: 0
        background: linear-gradient(90deg, #0008, #0000)
        .temBtn
            left: 10px
            &::before
                left: calc(50% - 15px)
                transform: translate(28%) rotate(45deg)
                background: linear-gradient(45deg, #ffff 0%, #ffff 50%, #0000 50%, #0000 100%)
    .rightBtnHolder
        right: 0
        background: linear-gradient(-90deg, #0008, #0000)
        .temBtn
            right: 10px
            &::before
                right: calc(50% - 15px)
                transform: translate(-28%) rotate(-45deg)
                background: linear-gradient(-45deg, #ffff 0%, #ffff 50%, #0000 50%, #0000 100%)
</style>