<template>
    <WrapperCent>
        <div class="wrapper-User">
            <div class="block">
            <form @submit.prevent="add_cards">
                <label for="card" class="Textlabel">Введите номер карты: </label>
                <input type="text" class="usercab Card" placeholder="Номер карты" v-model="dataBalance.id">
                <label for="balance" class="Textlabel">Баланс карты: </label>
                <input type="text" class="usercab Balance" placeholder="Сумма пополнения" v-model="dataBalance.balance">
                <button class="buttonSave">Создать</button>
                <hr class="VerticalLine">
            </form>
            </div>
            <div class="block">
                <form>
                    <p class="Textlabel">Список карта</p>
                    <ul>
                        <li v-for="(item, index) in listCards" :key="index.id">
                           Номер: {{item.id}} 
                           Баланс: {{item.balance}}
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
            Balance: 0,
            listCards: null,
            dataBalance: {
                id: '',
                balance: ''
            }
        }
    },
    methods: {
        add_cards(item) {
            this.$store.dispatch('CabinetUser/ADD_CARD', this.dataBalance);
        }
    },
    mounted() {
        this.$store.dispatch('CabinetUser/GET_LIST_CARDS')
        .then(listCards => this.listCards = listCards)
        .catch(error => console.log(error));
    }
}
</script>

<style>
.wrapper-User {
    width: 100%;
    height: 500px;
    display: flex;
    background: rgba(255,255,255,0.6);
    overflow: hidden;
}
.Textlabel {
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
.balanceYour {
    position: absolute;
    top: 30px;
    right: 55px;
    color: white;
}
.title_Name {
    color: white;
    font-size: 44px;
}
ul li {
    list-style: none;
    font-size: 24px;
    color: black;
    margin: 0 20px 5px -30px;
}
</style>
