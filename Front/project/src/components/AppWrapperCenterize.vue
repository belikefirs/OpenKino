<template>
    <div class="wrapper-center">
        <div class="center">
             <slot></slot>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="sass" scoped>
.wrapper-center
    width: 100%
    display: flex
    justify-content: center
    .center
        padding: 0 30px
        width: 1400px
</style>
