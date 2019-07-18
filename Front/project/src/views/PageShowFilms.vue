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
import SliderItem from '@/components/Slider/SliderItem.vue'
export default {
    components:{
        SliderItem
    }
}
</script>

<style>
.wrapper-films {
    /* display: grid;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-columns: 1fr 1fr 1fr;
    grid-gap: 1vw; */
    display: flex;
    flex-wrap: wrap;
    padding: 5px;
}
/* .wrapper-film > div {
    font-size: 6.5vw;
    padding: .5em;
    background: gold;
    text-align: center;
} */
</style>
