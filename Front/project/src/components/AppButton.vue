<template>
        <router-link v-if="url" class="wrapper-button" tag="button" :to="url">
            <slot></slot>
        </router-link>
        <button class="wrapper-button" v-else>
            <slot></slot>
        </button>
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
.wrapper-button
    text-align: center
    background: transparent
    line-height: 35px
    min-width: 121px
    height: 35px
    border: 0
    border: 1px solid white
    border-radius: 15px
    text-decoration: none
    user-select: none
    transition: background 0.5s
    cursor: pointer
    text-decoration: none
    font-family: 'Roboto', sans-serif
    font-size: 14px
    color: white
    font-weight: 100
    outline: none
    &:hover
        background: rgba(white, 0.3)

.button-registration 
    text-align: center
    line-height: 44px
    min-width: 115px
    height: 42px
    border-radius: 10px
    text-decoration: none
    user-select: none
    transition: background 0.2s
    background: white
    cursor: pointer
    text-decoration: none
    font-family: 'Roboto', sans-serif
    font-size: 16px
    font-weight: 400
    color: black
    &:hover
        background: rgba(white, 0.8)
</style>
