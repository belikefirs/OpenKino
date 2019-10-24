<template>  
    <div class="wrapperBuyReser">
        <div @click="$emit('click')">
            <form @submit.prevent="BuyReservation">
                <label for="card" class="textLabel">Введите номер карты: </label>
                <input type="text" class="usercab Card" placeholder="Номер карты" v-model="BuyReser.cardMask.id">
                <label for="balance" class="textLabel">Баланс карты: </label>
                <input type="text" class="usercab Balance" placeholder="Сумма пополнения" v-model="BuyReser.cardMask.balance">
                <p>{{Id}}</p>
                <button class="buttonSave" style="margin-bottom: 150px">Оплатить</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    props:["Id"],
    data(){
        return {
            BuyReser: {
                cardMask: {
                    id: null,
                    balance: null
                },
                idReservation: this.IdR
            }
        }
    },
    methods: {
        BuyReservation(){
            this.$store.dispatch('PageFilms/BUY_RESERVATION_FROM_USER', this.BuyReser);
        }
    },
    created() {
        console.log(this.Id)
    }
}
</script>

<style>
.wrapperBuyReser {
    width: 100%;
    height: 100%;
    display: flex;
    background: rgba(255,255,255,1);
    overflow: hidden;
}
.textLabel {
    font-size: 22px;
    color: #222;
    display: block;
}
.usercab {
    width: 90%;
    height: 50px;
    border: 1px solid #222;
    background: white;
    padding: 2px 0 2px 15px;
    outline: none;
    margin: 0 10px 10px 20px;
}
.block {
    width: 50%;
    margin: 0 0 0 5px;
    position: relative;
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
.buttonSave:hover {
    font-weight: 900;
    letter-spacing: 2px;
}
.cardsUser {
    list-style: none;
    font-size: 24px;
    color: white;
    margin: 0 20px 5px -30px;
    background: rgba(22, 22, 22, 0.7);
    padding: 10px 20px 10px 15px;
    border-radius: 5px;
    font-weight: 400;
    position: relative;
}
</style>