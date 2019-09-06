<template>
    <WrapperCent>
        <div class="wrapper-User">
            <div class="block">
            <form @submit.prevent="add_cards">
                <label for="card" class="textLabel">Введите номер карты: </label>
                <input type="text" class="usercab Card" placeholder="Номер карты" v-model="dataBalance.id">
                <label for="balance" class="textLabel">Баланс карты: </label>
                <input type="text" class="usercab Balance" placeholder="Сумма пополнения" v-model.number="dataBalance.balance">
                <button class="buttonSave" style="margin-bottom: 150px">Создать</button>
                <hr class="VerticalLine">
            </form>
            </div>
            <div class="block">
                <form @submit.prevent="">
                    <p class="textLabel">Список ваших карт:</p>
                    <ul>
                        <li v-for="(item, index) in listCards" :key="index.id" class="cardsUser">
                           Номер карты: {{item.id}} <br>
                           Баланс карты: {{item.balance}}
                           <button @click="delete_card(item)" class="btnDelete">Удалить</button>
                        </li>
                    </ul>
                </form>
            </div>
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
            listCards: null,
            dataBalance: {
                id: '',
                balance: ''
            },
            id: '',
            money: ''
        }
    },
    methods: {
        add_cards() {
            this.$store.dispatch('CabinetUser/ADD_CARD', this.dataBalance).then(() => {
                this.$store.dispatch('CabinetUser/GET_LIST_CARDS', {id: this.$store.state.Title.id})
                .then(listCards => this.listCards = listCards);
                console.log(this.listCards)
            });
        },
        delete_card(item) {
            this.$store.dispatch('CabinetUser/DELETE_CARD', {id: item.id}).then(() => {
                this.$store.dispatch('CabinetUser/GET_LIST_CARDS', {id: this.$store.state.Title.id}).then(listCards => this.listCards = listCards);
            });
        }
    },
    mounted() {
        this.$store.dispatch('CabinetUser/GET_LIST_CARDS', {id: this.$store.state.Title.id})
        .then(listCards => this.listCards = listCards)
    }
}
</script>

<style>
.wrapper-User {
    width: 100%;
    height: 100%;
    display: flex;
    background: rgba(255,255,255,0.6);
    overflow: hidden;
}
.textLabel {
    font-size: 28px;
    color: #222;
    display: block;
}
.usercab {
    width: 80%;
    height: 50px;
    border: 1px solid #222;
    background: white;
    padding: 2px 0 2px 15px;
    outline: none;
    margin-bottom: 20px;
}
.buttonBalance:hover {
    color: #222;
    background: white;
}
.block {
    width: 50%;
    margin: 0 0 0 5px;
    position: relative;
}
.VerticalLine {
    position: absolute;
    right: 30px;
    top: 0;
    height: 100%;
    width: 2px;
    color: black;
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
.btnDelete {
    width: 120px;
    height: 30px;
    border: 1px solid black;
    background: rgba(255, 255, 255, 0.9);
    font-size: 20px;
    font-weight: 400;
    margin-right: 10px;
    position: absolute;
    right: 0;
    margin-bottom: 5px;
    color: black;
}
.btnDelete:hover{
    font-weight: 500;
}
</style>
