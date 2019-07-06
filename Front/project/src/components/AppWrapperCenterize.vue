<template>
    <div class="wrapper-centerize">
        <slot></slot>
    </div>
</template>

<script>
export default {
    
}
</script>

<style lang="sass" scoped>
.wrapper-centerize
    padding: 0 30px
    width: 1400px
    height: 100%
    display: flex
    justify-content: center
    align-items: center
</style>
