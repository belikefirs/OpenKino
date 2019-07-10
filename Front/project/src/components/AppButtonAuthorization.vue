<template>
    <div class="wrapper-buttonAuthorization">
        <router-link v-if="url" :to="url" class="text">
            <p><slot></slot></p>
            </router-link>
        <div v-else><slot></slot></div>
    </div>
</template>

<script>
export default {
}
</script>

<style lang="sass" scoped>
.wrapper-buttonAuthorization
    text-align: center
    line-height: 40px
    width: 115px
    height: 42px
    border: 1px solid white
    border-radius: 10px
    text-decoration: none
    user-select: none
    transition: background 0.2s
    background: white
    &:hover
        background: rgba(white, 0.8)
    .text
        text-decoration: none
        font-family: 'Roboto', sans-serif
        font-size: 16px
        font-weight: 100
        color: black
</style>