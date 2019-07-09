<template>
    <div class="wrapper-totop" @click="$emit('goTop')">
        <a v-for="item in imagetotop" :key="item" href="#"><img :src="item" width="110px" height="105px" alt=""></a>
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
    position: fixed
    bottom: 100px
    right: 50px
    &:hover
        border-radius: 50%
        background: rgb(white, 0.9)
        transition: background 0.5s
</style>
