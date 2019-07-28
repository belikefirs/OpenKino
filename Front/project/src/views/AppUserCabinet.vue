<template>
    <WrapperCent>
        <div class="wrapper_User">
            <div class="item1 item"><p>Ваши карты</p></div>
            <div class="item2 item">
                <p>Пополнить</p>
                <p class="YourBalance">Ваш баланс: {{Balance}}</p>
                </div>
            <div class="item3 item"><p>Избранное</p></div>
            <div class="item4 item"><p>Настройки</p></div>
            <div class="item5 item"><p>Покупки</p></div>
            <div class="item6 item"><p>VIP</p></div>
            <div class="item7 item"><p>Добавить карту</p></div>
            <div class="item8 item"><p>Помощь</p></div>
            <div class="item9 item"><p>Выход</p></div>
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
            Title: 'Глеб Игоревич',
            Balance: 0,
            dataCard: {
                id: 0,
                balance: 0
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
.wrapper_User {
    background: rgba(34, 34, 34, 0.8);
    width: 100%;
    height: 700px;
    display: grid;
    overflow: hidden;
    color: white;
    font-weight: 500;
    font-size: 28px;
    grid-template: repeat(3, 1fr) / repeat(5, 1fr);
    grid-gap: 20px 10px;
    text-align: center;
    margin: 10px 0 10px 0;
}
.item1 {
    grid-column: 1/5;
}
.item3 {
    grid-column: 1/4;
}
.item4 {
    grid-column: 4/6;
}
.item {
    background: rgba(65, 65, 65, 0.7);
}
.item p {
    margin-top: 90px;
}
.item:hover {
    font-weight: 700;
    letter-spacing: 1px;
}
.YourBalance {
    font-size: 16px;
    text-align: start;
    margin-left: 30px;
}
</style>
