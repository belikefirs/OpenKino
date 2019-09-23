<template>
    <div class="wrapper-infobuy">
        <p>Ваши покупки:</p>
        <ul>
            <li v-for="(item, index) in listInfo" :key="index">
                <p>Цена {{item[0]}}</p>
                <p>Номер зала {{item[1]}}</p>
                <p>Время {{item[2]}}</p>
                <p>Название фильма {{item[3]}}</p>
                <p>Место {{item[4]}}</p>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                listInfo: null
            }
        },
        mounted() {
            this.$store.dispatch('CabinetUser/GET_INFO_BUY')
            .then(listInfo => this.listInfo = listInfo,
            console.log(this.listInfo)
            )
            
        }
    }
</script>

<style>

</style>
