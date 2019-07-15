<template>
    <div class="LogReg">
        <div class="nav">
            <div class="toLog" :class="{active: log}" @click="log = true">
                <p>Вход</p>
            </div>
            <div class="toReg" :class="{active: !log}" @click="log = false">
                <p>Регистрация</p>
            </div>
        </div>
        <transition :name="trSwitch">
            <form class="log inputCont" key="log" v-if="log" @submit.prevent="logIn">
                <input type="email" placeholder="E-mail">
                <input type="password" placeholder="Пароль">
                <input type="submit" value="Войти">
            </form>   
            <form class="reg inputCont" key="reg" v-else @submit.prevent="regIn">
                <input type="surname" placeholder="Фамилия">
                <input type="name" placeholder="Имя">
                <input type="age" placeholder="Возраст">
                <input type="email" placeholder="E-mail">
                <input type="phone" placeholder="Номер телефона">
                <input type="password" placeholder="Пароль">
                <input type="submit" value="Зарегистрироваться">
            </form>
        </transition>
    </div>
</template>

<script>
import AppButton from '@/components/AppButton.vue'
import { setTimeout } from 'timers';

export default {
	components: {
		AppButton
	},
	data () {
		return {
            log: true,
		}
    },
    methods:{
        logIn(){

        },
        regIn(){

        },
        getHeight(){
            if (this.$el) {
                this.$el.style.minHeight = '100vh';
                setTimeout(() => {
                         this.$el.style.minHeight = '';
                }, 1100);
            }
        }
    },
    computed:{
        trSwitch(){
            const {log, getHeight} = this;
            getHeight()
            return log ? 'trSwitch-left' : 'trSwitch-right';
        },
    }
}
</script>

<style scoped>
.LogReg{
    width: 500px;
    background: #00000000;
    overflow: hidden;
    position: relative;
    /* height: 100vh; */
}
.nav{
    z-index: 400;
    height: 60px;
    display: flex;
    flex-direction: row;
    color: white;
    user-select: none;
    font-family: 'Roboto', sans-serif;
	font-size: 24px;
	font-weight: 100;
}
.nav > div{
    width: 50%;
    text-align: center;
    line-height: 60px;
}
.inputCont{
    z-index: 0;
    padding: 18px 27px;
    display: flex;
    flex-direction: column;
    background: #eee;
}
.inputCont input{
    margin: 9px 0;
    padding: 0 15px;
    height: 42px;
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
}
.inputCont input:focus{
    outline: 0;
}
.active{
    background: #eee;
    color: black;
}

.trSwitch-left-enter{
    transform: translateX(-100%);
    opacity: 0;
}
.trSwitch-left-leave-to{
    transform: translateX(100%);
    opacity: 0;
}
.trSwitch-right-enter{
    transform: translateX(100%);
    opacity: 0;
}
.trSwitch-right-leave-to{
    transform: translateX(-100%);
    opacity: 0;
}

.trSwitch-left-enter-active, .trSwitch-left-leave-active, .trSwitch-right-enter-active, .trSwitch-right-leave-active{
    transition: all 1s;   
    top: 60px;
    position: absolute;
    width: 100%;
}
</style>