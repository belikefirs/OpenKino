<template>
    <NowFilm></NowFilm>
</template>

<script>
import Now from '@/components/HomeNow.vue'
import Actions from '@/components/HomeActions.vue'
import News from '@/components/HomeNews.vue'
import Activity from '@/components/HomeActivity.vue'
import NowFilm from '@/components/HomeNowFilm'
export default {
    components: {
        Now, Actions, News, Activity, NowFilm
    }
}
</script>

