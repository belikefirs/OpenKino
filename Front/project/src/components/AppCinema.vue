<template>
    <div class="wrapper-cinema">
        <div class="place free"></div>
        <div class="screen"></div>
        <div class="places" :style="{width : halls[0].width * 40 + 160 + 'px', height : halls[0].height * 40 + 'px'}">
            <div class="place" v-for="item in halls[0].places" :key="item.id"
            :class="{free : item.type == 'Free', notFree : item.type == 'NotFree', selected : selectedItems.includes(item)}"
            :style="{top : item.y * 40 + 'px', left : 80 + item.x  * 40 + 'px'}"
            v-on:click="selectItem(item)"
            >
                <p>{{item.value}}</p>
            </div>
            <div class="place empty" v-for="n in halls[0].height" :key="'left' + n" style="left: 25px"
            :style="{top : (n - 1) * 40 + 'px'}"
            >
                <p>{{n}}</p>
            </div>
            <div class="place empty" v-for="n in halls[0].height" :key="'right' + n" style="right: 25px"
            :style="{top : (n - 1) * 40 + 'px'}"
            >
                <p>{{n}}</p>
            </div>
        </div>
        <AppButton style="margin: 0 0 0 30px" class="toBookButton" v-on:click.native="setNotFree()">Забронировать билет</AppButton>
    </div>    
</template>

<script>
import AppButton from '@/components/AppButton.vue'
export default {
    components:{
        AppButton
    },
    data () {
        return {
            selectedItems: [],
            halls: [
                {
                    id: 0,
                    width: 14,
                    height: 12,
                    places: [
                        {id: 0, x: 0, y: 0, type: 'Free', value: 1},
                        {id: 1, x: 1, y: 0, type: 'Free', value: 2},
                        {id: 2, x: 2, y: 0, type: 'Free', value: 3},
                        {id: 3, x: 3, y: 0, type: 'Free', value: 4},
                        {id: 4, x: 4, y: 0, type: 'NotFree', value: 5},
                        {id: 5, x: 5, y: 0, type: 'NotFree', value: 6},
                        // {id: 6, x: 6, y: 0, type: 'Free', value: 7},
                        // {id: 7, x: 7, y: 0, type: 'Free', value: 8},
                        {id: 8, x: 8, y: 0, type: 'NotFree', value: 7},
                        {id: 9, x: 9, y: 0, type: 'NotFree', value: 8},
                        {id: 10, x: 10, y: 0, type: 'Free', value: 9},
                        {id: 11, x: 11, y: 0, type: 'Free', value: 10},
                        {id: 12, x: 12, y: 0, type: 'Free', value: 11},
                        {id: 13, x: 13, y: 0, type: 'Free', value: 12},

                        {id: 14, x: 0, y: 1, type: 'Free', value: 1},
                        {id: 15, x: 1, y: 1, type: 'Free', value: 2},
                        {id: 16, x: 2, y: 1, type: 'Free', value: 3},
                        {id: 17, x: 3, y: 1, type: 'Free', value: 4},
                        {id: 18, x: 4, y: 1, type: 'NotFree', value: 5},
                        {id: 19, x: 5, y: 1, type: 'NotFree', value: 6},
                        // {id: 20, x: 6, y: 1, type: 'Free', value: 7},
                        // {id: 21, x: 7, y: 1, type: 'Free', value: 8},
                        {id: 22, x: 8, y: 1, type: 'Free', value: 7},
                        {id: 23, x: 9, y: 1, type: 'Free', value: 8},
                        {id: 24, x: 10, y: 1, type: 'Free', value: 9},
                        {id: 25, x: 11, y: 1, type: 'Free', value: 10},
                        {id: 26, x: 12, y: 1, type: 'Free', value: 11},
                        {id: 27, x: 13, y: 1, type: 'Free', value: 12},

                        {id: 28, x: 0, y: 2, type: 'Free', value: 1},
                        {id: 29, x: 1, y: 2, type: 'Free', value: 2},
                        {id: 30, x: 2, y: 2, type: 'Free', value: 3},
                        {id: 31, x: 3, y: 2, type: 'Free', value: 4},
                        {id: 32, x: 4, y: 2, type: 'Free', value: 5},
                        {id: 33, x: 5, y: 2, type: 'Free', value: 6},
                        // {id: 34, x: 6, y: 2, type: 'Free', value: 7},
                        // {id: 35, x: 7, y: 2, type: 'Free', value: 8},
                        {id: 36, x: 8, y: 2, type: 'Free', value: 7},
                        {id: 37, x: 9, y: 2, type: 'Free', value: 8},
                        {id: 38, x: 10, y: 2, type: 'Free', value: 9},
                        {id: 39, x: 11, y: 2, type: 'Free', value: 10},
                        {id: 40, x: 12, y: 2, type: 'Free', value: 11},
                        {id: 41, x: 13, y: 2, type: 'Free', value: 12},
                    ],
                }
            ],
        }
    },
    methods:{
        selectItem(item){
            if (item.type == 'Free') {
                if (this.selectedItems.includes(item)) this.selectedItems.splice(this.selectedItems.indexOf(item),1);
                else this.selectedItems.push(item);
                if (this.selectedItems.length > 5) this.selectedItems.shift();
            }
        },
        setNotFree(){
            this.selectedItems.forEach(item => {
                this.halls[0].places[this.halls[0].places.indexOf(item)].type = 'NotFree';
            });
            this.selectedItems = [];
        }
    },
    computed:{

    },
    mounted () {
    this.$store.dispatch('TEXT')
    .then(hall => {console.log('APP', hall.data)})
    .catch()
    }
}
</script>

<style scoped>
.wrapper-cinema{
    background: #313166;
    border-radius: 0 0 8px 8px;
    padding: 0 0 15px;
}
.wrapper-cinema .screen{
    margin: 20px auto 60px;
    width: 80%;
    height: 5px;
    background: white;
    box-shadow: 0 8px 15px rgba(230,236,242,.7);
}
.places{
    position: relative;
}
.places .place{
    position: absolute;
    user-select: none;
    width: 30px;
    height: 30px;
    border: 1px solid transparent;
    border-radius: 6px;
    font-size: 16px;
    color: white;
    line-height: 30px;
    text-align: center;
    transition: all 0.5s;
}
.free{
    background: rgb(67, 189, 37);
    cursor: pointer;
}
.notFree{
    background: #111;
    cursor: default;
}
.empty{
    cursor: default;
}
.free:hover:not(.selected){
    box-shadow: 0 0 7px rgba(230,236,242,.7);
    transform: scale(1.1);
}
.selected{
    background: red;
    box-shadow: 0 0 7px red;
    transform: scale(1.1);
}
.toBookButton{
    margin: 15px 15px 0 auto;
    width: 220px;
    border-radius: 6px;
}
</style>
