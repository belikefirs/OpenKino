<template>
    <div class="wrapper-cinema" v-if="hall">
        <div class="place free"></div>
        <div class="screen"></div>
        <div class="places" :style="{width : hall.width * 40 + 160 + 'px', height : hall.height * 40 + 'px'}">
            <div class="place" v-for="(item, index) in hall.places" :key="item.id"
            :class="{free : item.reservation, notFree : !item.reservation, selected : selectedItems.includes(item)}"
            :style="{top : item.y * 40 - 40 + 'px', left : 70 + item.x  * 40 + 'px'}"
            v-on:click="selectItem(item)"
            >
                <p>{{index + 1}}</p>
            </div>
            <div class="place empty" v-for="n in hall.height" :key="'left' + n" style="left: 25px"
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
            hall: null
        }
    },
    methods:{
        setReservation() {
            
        },
        selectItem(item){
            if (!item.reservation) {
                if (this.selectedItems.includes(item)) this.selectedItems.splice(this.selectedItems.indexOf(item),1);
                else this.selectedItems.push(item);
                if (this.selectedItems.length > 5) this.selectedItems.shift();
            }
        },
        setNotFree(){
            this.selectedItems.forEach(item => {
                this.hall.places[this.hall.places.indexOf(item)].reservation = true;
            });
            this.selectedItems = [];
        }
    },
        mounted () {
            this.$store.dispatch('Hall/GET_PLACES')
            .then(hall => this.hall = hall)
            .then(() => {
                this.$store.dispatch('PageFilms/RESERVATION')
            })
        },

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
