<template>
    <div class="wrapper-button">
        <router-link v-if="url" :to="url">
            <p class="link-text"><slot></slot></p>
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
.link-text
    text-decoration: none
    font-family: 'Roboto', sans-serif
    font-size: 12px
    color: white
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
    &:hover
        background-color: rgba(white, 0.3)
</style>
