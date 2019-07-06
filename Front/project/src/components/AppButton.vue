<template>
    <div class="wrapper-button">
        <router-link v-if="url" :to="url" class="text">
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
.wrapper-button
    text-align: center
    line-height: 35px
    margin: 0 10px
    width: 121px
    height: 35px
    border: 1px solid white
    border-radius: 15px
    text-decoration: none
    user-select: none
    transition: background 0.5s
    &:hover
        background: rgba(white, 0.3)
    .text
        text-decoration: none
        font-family: 'Roboto', sans-serif
        font-size: 14px
        font-weight: 100
        color: white
    
</style>
