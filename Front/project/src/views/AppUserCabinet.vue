<template>
    <WrapperCent>
        <div class="Title">
            <p class="title_Name">{{Title}}</p>
            <p class="balanceYour">Ваш баланс: {{Balance}}</p>
        </div>
        <div class="wrapper-User">
            <div class="block">
            <form @submit.prevent="balance_Donate">
                <label for="card" class="Textlabel">Введите номер карты: </label>
                <input type="text" class="usercab Card" placeholder="Номер карты" v-model="dataBalance.id">
                <label for="balance" class="Textlabel">Сумма пополнения: </label>
                <input type="text" class="usercab Balance" placeholder="Сумма пополнения" v-model="dataBalance.balance">
                <button class="buttonSave">Пополнить</button>
                <hr class="VerticalLine">
            </form>
            </div>
            <div class="block">
                <form>
                    <p class="Textlabel">Редактирование профиля</p>
                    <input type="text" placeholder="Фамилия" class="usercab">
                    <input type="text" placeholder="Имя" class="usercab">
                    <input type="text" placeholder="Отчество" class="usercab">
                    <input type="text" placeholder="Город" class="usercab">
                    <input type="text" placeholder="Номер телефона" class="usercab">
                    <button class="buttonSave">Сохранить изменения</button>
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
            Title: 'Иван Иванов',
            Balance: 0,
            dataBalance: {
                id: '',
                balance: ''
            }
        }
    },
    methods: {
        balance_Donate() {
            this.$store.dispatch('BALANCE_UP', this.dataBalance);
        }
    }
}
</script>

<style>
.wrapper-User {
    width: 100%;
    height: 700px;
    display: flex;
    background: rgba(255,255,255,0.6);
    overflow: hidden;
}

.Title {
    background: rgba(48, 47, 47, 0.9);
    position: relative;
    text-align: center;
    border-radius: 0 0 10px 10px;
}
.Textlabel {
    font-size: 28px;
    color: #222;
    display: block;
}
.usercab {
    width: 600px;
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
</style>
