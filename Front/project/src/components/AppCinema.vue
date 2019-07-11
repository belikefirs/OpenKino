<template>
    <div class="wrapper-cinema">
        <div class="screen"></div>
    </div>    
</template>

<script>
export default {
    data () {
        return {
            halls: [
                {
                    id: 0,
                    width: 30,
                    height: 12,
                    places: [
                        {id: 0, x: 0, y: 0, type: 'Free'},
                        {id: 1, x: 0, y: 1, type: 'NotFree'},
                        {id: 2, x: 0, y: 2, type: 'Empty'},
                        {id: 3, x: 0, y: 3, type: 'NotFree'},
                        {id: 4, x: 0, y: 4, type: 'Free'},
                    ],
                }
            ]
        }
    }
}
</script>

<style lang="sass" scoped>
.screen
    width: 100%
    height: 5px
    background: white
</style>
