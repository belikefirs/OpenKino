<template>
    <div class="wrapper-auto">
        <div class="wrapper_window">
            <p class="title_auto">Вход</p>
            <div class="login_password">
                <input type="email" placeholder="E-mail">
                <input type="password" placeholder="Пароль">
            </div>
            <div class="buttons">
                <AppButton style="margin: 20px 0px 10px 0;" v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
                <a href="#" style="margin: 28px 0px 10px 20px;"><u>Восстановить пароль</u></a>
                <AppButtonSignIn style="margin: 18px 0px 10px 25px;" v-for="item in links_2" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButtonSignIn>
            </div>
        </div>
    </div>
</template>

<script>
import AppButton from '@/components/AppButton.vue'
import AppButtonSignIn from '@/components/AppButtonAuthorization.vue'
export default {
	components: {
		AppButton, AppButtonSignIn
	},
	data () {
		return {
			links: [
                {name: 'Войти', link: '#'}
            ],
            links_2: [
                {name: 'Регистрация', link: '#'}
			],
		}
	}
}
</script>

<style lang="sass">
.wrapper-auto
    width: 500px
    height: 270px
    background: #212121
    border-radius: 8px
    opacity: 0.7
    border: 1px solid white
    .wrapper_window
        padding: 20px
        .title_auto
            font-size: 27px
            font-weight: 100
            color: #ffffff   
            text-align: left
            letter-spacing: 2px
            font-height: 100
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