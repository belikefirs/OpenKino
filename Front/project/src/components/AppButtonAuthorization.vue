<template>
    <div class="wrapper-buttonAuthorization">
        <router-link v-if="url" :to="url" class="text">
            <p><slot></slot></p>
        </router-link>
        <div v-else>
            <p><slot></slot></p>
        </div>
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
    line-height: 44px
    min-width: 115px
    height: 42px
    border-radius: 10px
    text-decoration: none
    user-select: none
    transition: background 0.2s
    background: white
    cursor: pointer
    &:hover
        background: rgba(white, 0.8)
    .text
        text-decoration: none
        font-family: 'Roboto', sans-serif
        font-size: 16px
        font-weight: 100
        color: black
</style>