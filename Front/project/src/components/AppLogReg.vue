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
        <div class="log inputCont" v-if="log">
            <input type="email" placeholder="E-mail">
            <input type="password" placeholder="Пароль">
        </div>
        <div class="reg inputCont" v-else>
                <input type="surname" placeholder="Фамилия">
                <input type="name" placeholder="Имя">
                <input type="age" placeholder="Возраст">
                <input type="email" placeholder="E-mail">
                <input type="phone" placeholder="Номер телефона">
                <input type="password" placeholder="Пароль">
        </div>
    </div>
</template>

<script>
import AppButton from '@/components/AppButton.vue'

export default {
	components: {
		AppButton
	},
	data () {
		return {
            log: true,
		}
	}
}
</script>

<style scoped>
.LogReg{
    width: 500px;
    
}
.nav{
    height: 60px;
    display: flex;
    flex-direction: row;
    color: white;
    user-select: none;
    font-family: 'Roboto', sans-serif;
	font-size: 24px;
	font-weight: 100;
    /* background: #111; */
}
.nav > div{
    width: 50%;
    text-align: center;
    line-height: 60px;
}
.inputCont{
    padding: 18px;
    display: flex;
    flex-direction: column;
    background: #eee;
}
.inputCont input{
    margin: 9px;
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
</style>