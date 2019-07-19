<template>
    <div class="wrapper-films">
        <SliderItem v-for="item in $store.state.films" :key="item.filmTitle"
        :image="item.image"
        :path="item.path"
        :filmTitle="item.filmTitle"
        :filmStyle="item.filmStyle"
        :filmType="item.filmType"
        :limitAge="item.limitAge"
        ></SliderItem>
    </div>
</template>

<script>
import SliderItem from '@/components/AppFilmCard.vue'
export default {
    components:{
        SliderItem
    }
}
</script>

<style>
.wrapper-films {
    display: flex;
    flex-wrap: wrap;
    padding: 5px;
}
</style>
