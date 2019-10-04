<template>
    <WrapperCent>
        <div class="wrapper-reser">
                <li v-for="(item, index) in dataListReser" :key="index" class="itemReservation">
                    <p>Цена: {{item[0]}}</p>
                    <p>Номер зала: {{item[1]}}</p>
                    <p>Время: {{item[2].month}} {{item[2].dayOfYear}} {{item[2].hour}}:{{item[2].minute}}</p>
                    <p>Название фильма: {{item[3]}}</p>
                    <p v-for="(item2, index2) in item[4]" :key="index2">Место №{{item2[0]}} Ряд №{{item2[1]}}</p>
                    <button class="buttonBuy">Купить</button>
                </li>
        </div>
    </WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
export default {
    components: {
        WrapperCent
    },
    data() {
        return {
            dataListReser: null
        }
    },
    mounted() {
        this.$store.dispatch('CabinetUser/GET_INFO_RESER')
        .then(dataListReser => this.dataListReser = dataListReser)
    }
}
</script>

<style>
.wrapper-reser {
  display: flex;
  width: 100%;
  flex-wrap: wrap;
}
.itemReservation {
    background: rgb(253, 253, 253, 0.8);
    color: #222;
    font-size: 16px;
    display: inline-block;
    width: 20%;
    height: 100%;
    min-height: 250px;
    margin:10px 10px 10px 10px;
    position: relative;
    border-radius: 10px;
    padding: 10px 0 15px 10px;
    font-weight: 400;
}
.buttonBuy {
    height: 30px;
    width: 100px;
    position: absolute;
    bottom: 5px;
    right: 5px;
    background: rgb(22, 22, 22);
    color: white;

}

</style>