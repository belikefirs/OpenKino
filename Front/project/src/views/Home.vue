<template>
    <div class="wrapper-home">
        <Now></Now>
    </div>
</template>

<script>
import Now from '@/components/HomeNow.vue'
import Actions from '@/components/HomeActions.vue'
import News from '@/components/HomeNews.vue'
import Activity from '@/components/HomeActivity.vue'

export default {
    components: {
        Now, Actions, News, Activity
    }
}
</script>

<style lang="sass">
        
</style>