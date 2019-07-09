<template>
    <div class="wrapper-buttonAuthorization">
        <router-link v-if="url" :to="url" class="textA">
            <p><slot></slot></p>
            </router-link>
        <div v-else><slot></slot></div>
    </div>
</template>

<script>
export default {
    props:{
    url:{
        type: Object
    }
},
}
</script>

<style lang="sass" scoped>
.wrapper-buttonAuthorization
    text-align: center
    line-height: 40px
    width: 109px
    height: 42px
    border: 1px solid white
    border-radius: 10px
    text-decoration: none
    user-select: none
    transition: background 0.2s
    &:hover
        background: rgba(white, 0.3)
    .textA
        text-decoration: none
        font-family: 'Roboto', sans-serif
        font-size: 16px
        font-weight: 100
        color: white
</style>