<template>
    <WrapperCent>
        <div class="wrapper-film">
            <div class="wrapper-filmFilter">
                <input type="text" class="search" placeholder="Поиск по жанру, названию" v-model="searchFilm">
                <input type="text" class="date" placeholder="Дата выхода">
                <div class="rating">
                    <div class="stars">
                        <p>Рейтинг</p>
                        <div id="reviewStars-input">
                            <input id="star-4" type="radio" name="reviewStars"/>
                            <label title="Отлично" for="star-4"></label>

                            <input id="star-3" type="radio" name="reviewStars"/>
                            <label title="Хорошо" for="star-3"></label>

                            <input id="star-2" type="radio" name="reviewStars"/>
                            <label title="Нормально" for="star-2"></label>

                            <input id="star-1" type="radio" name="reviewStars"/>
                            <label title="Плохо" for="star-1"></label>

                            <input id="star-0" type="radio" name="reviewStars"/>
                            <label title="Очень плохо" for="star-0"></label>
                        </div>
                    </div>
                </div>
            </div>
            <SliderItem v-for="item in filterFilms" :key="item.filmTitle "
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
import Star1 from "./../assets/temp/icons/Star1.png"
import Star2 from "./../assets/temp/icons/Star2.png"
import Star3 from "./../assets/temp/icons/Star3.png"
import Star4 from "./../assets/temp/icons/Star4.png"
import Star5 from "./../assets/temp/icons/Star5.png"
import SliderItem from '@/components/AppFilmCard.vue'
import Slider from '@/components/AppSlider.vue'

export default {
    components: {
        WrapperCent, SliderItem, Slider
    },
    data() {
        return {
            ImageStar: [
                Star1, Star2, Star3, Star4, Star5
            ],
            searchFilm: ''
        }
    },
    computed: {
        filterFilms: function() {
            var searchwords = this.searchFilm && this.searchFilm.toLowerCase();
            var searcharray =  this.$store.state.films;

            searcharray = this.$store.state.films.filter(function(item){
                if(item.filmTitle.toLowerCase().indexOf(searchwords) !== -1 || item.filmType.toLowerCase().indexOf(searchwords) !== -1) {
                    return item;
                }
            }
            )
            return searcharray;
        }
    }
}
</script>

<style>
.wrapper-film {
    width: 100%;
    height: 100%;
    display: flex;
    flex-wrap: wrap;
}
.wrapper-filmFilter {
    display: flex;
    flex-direction: row;
    margin-top: 10px;
}
.search {
    background: #fff;
    width: 590px;
    height: 40px;
    color: #f36021;
    font-family: Roboto;
    font-size: 14px;
    font-weight: 300;
    margin-right: 20px;
    padding: 5px 5px 5px 25px;
    border: 1px solid #f36021;
}
.search::-webkit-input-placeholder { 
    color: #f36021;
    }
.date {
    border: 1px solid #f36021;
    background: #fff;
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
#reviewStars-input input:checked ~ label, #reviewStars-input label, #reviewStars-input label:hover, #reviewStars-input label:hover ~ label {
  background: url('http://positivecrash.com/wp-content/uploads/ico-s71a7fdede6.png') no-repeat;
}

#reviewStars-input {
  
  /*fix floating problems*/
  overflow: hidden;
  *zoom: 1;
  /*end of fix floating problems*/
  
  position: relative;
  float: left;
}

#reviewStars-input input {
  filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
  opacity: 0;
  
  width: 43px;
  height: 40px;
  
  position: absolute;
  top: 0;
  z-index: 0;
}

#reviewStars-input input:checked ~ label {
  background-position: 0 -40px;
  height: 40px;
  width: 43px;
}

#reviewStars-input label {
  background-position: 0 0;
  height: 40px;
  width: 43px;
  float: right;
  cursor: pointer;
  margin-right: 10px;
  
  position: relative;
  z-index: 1;
}

#reviewStars-input label:hover, #reviewStars-input label:hover ~ label {
  background-position: 0 -40px;
  height: 40px;
  width: 43px;
}

#reviewStars-input #star-0 {
  left: 0px;
}
#reviewStars-input #star-1 {
  left: 53px;
}
#reviewStars-input #star-2 {
  left: 106px;
}
#reviewStars-input #star-3 {
  left: 159px;
}
#reviewStars-input #star-4 {
  left: 212px;
}
#reviewStars-input #star-5 {
  left: 265px;
}
</style>
