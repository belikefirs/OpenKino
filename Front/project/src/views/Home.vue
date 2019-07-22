<template>
    <div>
        <Now></Now>
        <Actions></Actions>
    </div>
</template>

<script>
import Now from '@/components/Home/Now.vue'
import Actions from '@/components/Home/Actions.vue'
import News from '@/components/Home/News.vue'
import Activity from '@/components/Home/Activity.vue'

export default {
    components: {
        Now, Actions, News, Activity
    }
}
</script>

<style lang="sass">
        
</style>