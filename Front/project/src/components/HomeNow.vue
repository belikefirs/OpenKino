<template>
    <div class="wrapper-now">
        <WrapperCent class="wrapper-now-title">
            Сейчас в кино
        </WrapperCent>
        <Slider></Slider>
    </div>
    
</template>

<script>
import Slider from '@/components/AppSlider.vue'
import WrapperCent from '@/components/AppWrapperCenterize.vue'
export default {
    components: {
        WrapperCent, Slider
    }
}
</script>

<style lang="sass" scoped>
.wrapper-now-title
    height: 50px
    line-height: 50px
    background-color: rgba(red, 0.4)
    color: white
</style>