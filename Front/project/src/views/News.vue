<template>
    <div>
        <div class="wrapper-NewsFilm">
            <!--<NewsFilm v-for="item in $store.state.newsFilm" :key="item.filmTitle "
                :image="item.image"
                :path="item.path"
                :filmTitle="item.filmTitle"
                :filmNews="item.filmNews"
                :newTitle="item.newTitle"
            >
        </NewsFilm>-->
        </div>
        <SelectionsForYou></SelectionsForYou>
    </div>
</template>
<script>
import SelectionsForYou from '@/components/FilmsSelectionsForYou.vue'
import NewsFilm from '@/components/NewsFilms.vue'

export default {
    components: {
        SelectionsForYou, NewsFilm
    }
}
</script>

<style>
.wrapper-NewsFilm{
    display: flex;
    flex-wrap: wrap;
    width: 100%;
}
</style>
