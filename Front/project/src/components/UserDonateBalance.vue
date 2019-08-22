<template>
    <div class="wrapper_dona" @click="$emit('click')">
        <form @submit.prevent="donate_card()">
            <input type="text" class="usercab" placeholder="Номер карты" v-model="id">
            <input type="text" class="usercab" placeholder="Сумма пополнения" v-model="money">
            <button class="buttonSave" style="margin: 0 0 0 67px">Пополнить</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            donatecard: {
                id_card: '',
                donate_sum: ''
            },
            id: '',
            money: ''
        }
    },
    methods: {
        donate_card() {
            this.$store.dispatch('CabinetUser/DONATE_CARD', {id: this.id, money: this.money});
        }
    }
}
</script>

<style>
.wrapper_donate {
    width: 700px;
    height: 700px;
    background: rgba(255,255,255,0.6);
}
.usercab {
    width: 80%;
    height: 50px;
    border: 1px solid #222;
    background: white;
    padding: 2px 0 2px 15px;
    outline: none;
    margin-bottom: 20px;
    color: black;
    font-size: 18px;
}
.buttonSave {
    width: 320px;
    height: 50px;
    color: #222;
    background: white;
    border: 1px solid #222;
    font-size: 24px;
    letter-spacing: 1px;
    display: block;
    border-radius: 0 0 5px 5px;
    margin: 0 0 10px 0;
}
</style>
