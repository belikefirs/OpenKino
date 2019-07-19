<template>
    <WrapperCent>
        <div class="wrapper-film">
            <div class="wrapper-filmFilter">
                <input type="text" class="search" placeholder="Поиск по жанру, названию, режисеру">
                <input type="text" class="date" placeholder="Дата выхода">
                <div class="rating">
                    <div class="stars">
                        <p>Рейтинг</p>
                        <div class="star" v-for="item in ImageStar" :key="item">
                            <img :src="item" alt="star">
                        </div>
                    </div>
                </div>
            </div>
            <SliderItem v-for="item in $store.state.films" :key="item.filmTitle "
                :image="item.image"
                :path="item.path"
                :filmTitle="item.filmTitle"
                :filmStyle="item.filmStyle"
                :filmType="item.filmType"
                :limitAge="item.limitAge"
            >
            </SliderItem>
        </div>
    </WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
import Star from "./../assets/temp/icons/Star.png"
import SliderItem from '@/components/AppFilmCard.vue'
export default {
    components: {
        WrapperCent, SliderItem 
    },
    data() {
        return {
            ImageStar: [
                Star, Star, Star, Star, Star
            ]
        }
    }
}
</script>

<style>
.wrapper-film {
    width: 100%;
    height: 1000px;
    display: flex;
    flex-wrap: wrap;
}
.wrapper-filmFilter {
    display: flex;
    flex-direction: row;
    margin-top: 10px;
}
.search {
    width: 590px;
    height: 40px;
    color: #f36021;
    font-family: Roboto;
    font-size: 14px;
    font-weight: 300;
    margin-right: 20px;
    padding: 5px 5px 5px 25px;
}
.search::-webkit-input-placeholder { 
    color: #f36021;
    }
.date {
    width: 180px;
    height: 40px;
    color: #f36021;
    font-family: Roboto;
    font-size: 14px;
    font-weight: 300;
    margin-right: 23px;
    padding: 5px 5px 5px 25px;
}
.date::-webkit-input-placeholder { 
    color: #f36021;
    }
.rating {
    width: 306px;
    height: 38px;
    border: 1px solid #ffffff;
}
.stars {
    display: flex;
    flex-direction: row;
} .stars p {
    color: #f36021;
    margin: 7px 22px 10px 10px;
}
</style>
