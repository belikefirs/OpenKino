<template>
    <div class="LogRegi">
        <div class="nav">
            <div :class="{toAutoYes: !log, toAutoNo : log}" @click="log = true">
                <p>Вход</p>
            </div>
            <div :class="{toAutoYes: log, toAutoNo : !log}" @click="log = false">
                <p>Регистрация</p>
            </div>
        </div>
        <transition :name="trSwitch">
            <form class="log inputCont" key="log" v-if="log" @submit.prevent="logIn">
                <input type="text" placeholder="E-mail" v-model="authdata.mail">
                <input type="password" placeholder="Пароль" v-model="authdata.password">
                <input class="button_auto" type="submit" value="Войти">
            </form>   
            <form class="reg inputCont" key="reg" v-else @submit.prevent="regIn">
                <input type="surname" placeholder="Фамилия" v-model="regdata.name">
                <input type="name" placeholder="Имя" v-model="regdata.fName">
                <input type="age" placeholder="Возраст" v-model="regdata.age">
                <input type="text" placeholder="E-mail" v-model="regdata.mail">
                <input type="phone" placeholder="Номер телефона" v-model="regdata.phone">
                <input type="password" placeholder="Пароль" v-model="regdata.password">
                <input class="button_auto" type="submit" value="Зарегистрироваться">
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
            authdata: {
                mail: '',
                password: ''
            },
            regdata: {
                name: '',
                fName: '',
                age: '',
                mail: '',
                phone: '',
                password: ''
            }
		}
    },
    methods:{
        logIn(){
            this.$store.dispatch('Authorization/AUTHORIZATION_LOGIN', this.authdata);
        },
        regIn(){
            this.$store.dispatch('Authorization/AUTHORIZATION_REG', this.regdata);
        },
        getHeight(){
            if (this.$el) {
                this.$el.style.minHeight = '100vh';
                setTimeout(() => {
                         this.$el.style.minHeight = '';
                }, 1100);
            }
        },
        parseJwt () {
            const token = localStorage.getItem(STORAGE_NAME_ACCESSTOKEN)
            if (user) {
                const base64Url = token.split('.')[1]
                const base64 = base64Url.replace('-', '+').replace('', '/')
                return JSON.parse(Base64.decode(base64))
            } else {
                return null
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

<style>
.LogRegi{
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
    border: 1px solid #222;
}
.inputCont input:focus{
    outline: 0;
}
.button_auto:hover {
    background: black;
    color: white;
}
.toAutoYes {
    background: #222;
    color: #eee;
}
.toAutoNo {
    background: #eee;
    color: #222;
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