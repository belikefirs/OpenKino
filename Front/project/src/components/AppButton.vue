<template>
    <div class="wrapper-button">
        <router-link to=""></router-link>
        <slot></slot>
    </div>
</template>

<script>
export default {
    data: () => ({

    }),
}
</script>


<style lang="sass" scoped>
.link-button
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
