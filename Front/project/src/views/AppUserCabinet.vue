<template>
    <WrapperCent>
        <div class="wrapper-user">
            <router-link to="/usercabinet/yourcards" class="item1 item">
                <div>
                    <p>Ваши карты</p>
                </div>
            </router-link>
            <router-link to="#" class="item2 item">
                <div @click="flagBalance = true">
                    <p>Пополнить</p>
                </div>
            </router-link>
            <Modal :show="flagBalance" @showBlur="flagBalance = false">
                <template v-slot:content>
                    <Donate></Donate>
                </template>
            </Modal>
            <div class="item3 item"><p>Избранное</p></div>
            <div class="item4 item"><p>Настройки</p></div>
            <router-link to="/usercabinet/buy" class="item5 item"><div><p>Покупки</p></div></router-link>
            <div class="item6 item"><p>VIP</p></div>
            <div class="item7 item"><p>Добавить карту</p></div>
            <router-link to="#" class="item8 item"><div><p>Помощь</p></div></router-link>
            <div class="item9 item"><p>Выход</p></div>
        </div>
    </WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
import Modal from '@/components/AppModalWindow.vue'
import Donate from '@/components/UserDonateBalance.vue'
export default {
    components: {
        WrapperCent, Modal, Donate
    },
    data() {
        return {
            flagBalance: false
        }
    }
}
</script>

<style>
.wrapper-user {
    background: rgba(34, 34, 34, 0.8);
    width: 100%;
    height: 700px;
    display: grid;
    overflow: hidden;
    color: white;
    font-weight: 500;
    font-size: 28px;
    grid-template: repeat(3, 1fr) / repeat(5, 1fr);
    grid-gap: 10px 10px;
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
    color:white;
    text-decoration: none;
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
