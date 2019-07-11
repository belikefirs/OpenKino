<template>
    <div class="wrapper-totop" @click="$emit('goTop')">
        <a v-for="item in imagetotop" :key="item" href="#"><img :src="item" width="50px" height="45px" alt=""></a>
    </div>
</template>

<script>
import backtotop from "./../assets/temp/icons/2.png"

export default {
    data() {
        return {
            imagetotop:[
                backtotop
            ]
        }
    }
}
</script>

<style lang="sass">
.wrapper-totop
    z-index: 400
    position: fixed
    bottom: 50px
    right: 50px
    opacity: 0.6
    &:hover
        border-radius: 50%
        background: rgb(white, 0.9)
        transition: background 0.5s
</style>
