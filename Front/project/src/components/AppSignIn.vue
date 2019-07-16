<template>
    <div class="wrapper-auto">
            <div class="login_password">
                <input type="email" placeholder="E-mail">
                <input type="password" placeholder="Пароль">
            </div>
            <div class="buttons" style="margin: 0px 0px 0 20px;">
                <AppButton class="wrapper-button" style="margin: 14px 0px 15px" v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
                <a href="#" style="margin: 14px 8px 15px 15px"><u>Восстановить пароль</u></a>
                <AppButton @click="$emit('changeReg')" class="button-registration" style="margin: 14px 0px 15px 22px" v-for="item in links2" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
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
			links: [
                {name: 'Войти', link: '#'},
                
            ],
            links2: [
                {name: 'Регистрация', link: '#'},
            ]
		}
    },

}
</script>

<style lang="sass">
.wrapper-auto
    width: 500px
    height: 100%
    background: #212121
    border-radius: 8px
    opacity: 0.7
    text-align: center
    .login_password
        input
            border-radius: 2px
            padding: 0 10px 0
            font-size: 20px
            font-weight: 100
            font-height: 900
            width: 460px
            height: 38px
            background: rgba(#ffffff, 0.9)
            margin: 10px 0 10px 0
            // letter-spacing: 2px
            border-radius: 10px
            outline: none
    .buttons
        display: flex
        flex-direction: row
        justify-content: start
        a
            text-decoration: none
            color: white
            font-size: 18px
            font-weight: 100
</style>