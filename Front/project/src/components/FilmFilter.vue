<template>
    <WrapperCent>
        <div class="wrapper-film">
            <div class="wrapper-filmFilter">
                <input type="text" class="search" placeholder="Поиск по жанру, названию" v-model="searchFilm" @click="search()">
            </div>
            <!-- <ul>
                <li class="listFilms" v-for="(item, index) in listFilms" :key="index.id">
                    <div>{{item.name}}</div>
                    <div>{{item.lenght / 60 + 'мин'}}</div>
                    <div>{{item.typeFilm.name}}</div>
                    <div>{{item.genre.name}}</div>
                    <div class="sessions" v-for="(session, index2) in listSession" :key="index2.id" v-if="">
                        <span @click="showInformation(session.id), flagCinema = true">{{session.start}}</span>
                    </div>
                </li>
            </ul> -->

            <SliderItem v-for="(item, index) in listFilms" :key="index.id"
                :filmTitle="item.name"
                :filmStyle="item.typeFilm.name"
                :filmType="item.genre.name"
                :limitAge="item.limitAge.age"
                @click="showInformation(item.id)"
            >
            </SliderItem>
        </div>
    </WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
import SliderItem from '@/components/AppFilmCard.vue'
export default {
    components: {
        WrapperCent, SliderItem
    },
    data() {
        return {
            listFilms: null,
            searchFilm: '',
            flagCinema: false,
            idFilm: null
        }
    },
    methods: {
      showInformation(sId) {
        this.$router.push({name: 'FilmsInformation', params:{Sid:sId}});
      },
      search() {
        this.$store.dispatch('Films/GET_FILMS_WITH_FILTERS', {name: this.searchFilm})
      }
    },
    mounted() {
      this.$store.dispatch('PageFilms/GET_FILMS_SEARCH')
      .then(listFilms => this.listFilms = listFilms)
    },

    /*computed: {
        filterFilms: function() {
            var searchwords = this.searchFilm && this.searchFilm.toLowerCase();
            var searcharray =  this.$store.state.films;

            searcharray = this.$store.state.films.filter(function(item){
                if(item.filmTitle.toLowerCase().indexOf(searchwords) !== -1 || 
                item.filmType.toLowerCase().indexOf(searchwords) !== -1 || 
                item.filmStyle.toLowerCase().indexOf(searchwords) !== -1) {
                    return item;
                }
            }
            )
            return searcharray;
        }
    }*/
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
    width: 1440px;
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
.listFilms {
    height: 150px;
    width: 100%;
    list-style-type: none;
}
.listFilms div {
    margin-right: 30px;
    font-size: 24px;
    display: inline;
}

</style>