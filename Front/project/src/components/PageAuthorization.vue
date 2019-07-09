<template>
    <Module>
        <div class="wrapper_window">
            <p class="title_auto">Вход</p>
            <div class="login_password">
                <input type="email" placeholder="e-mail">
                <input type="password" placeholder="Пароль">
            </div>
            <div class="buttons">
                <AppButton style="margin: 20px 0px 10px 0;" v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
                <a href="#" style="margin: 30px 0px 10px 15px;">Восстановить пароль</a>
            </div>
        </div>
    </Module>
</template>

<script>
import AppButton from '@/components/AppButton.vue'
import Module from '@/components/AppModuleWindow.vue'
export default {
	components: {
		AppButton, Module
	},
	data () {
		return {
			links: [
                {name: 'Войти', link: ' '},
			],
		}
	}
}

</script>

<style lang="sass">
.wrapper_window
    padding: 20px
    .title_auto
        font-size: 27px
        color: #ffffff   
        text-align: left
        letter-spacing: 1px
        font-height: 100
    .login_password
        input
            border-radius: 2px
            padding: 0 10px 0
            font-size: 24px
            font-height: 900
            width: 460px
            height: 38px
            background: #ffffff
            opacity: 0.5
            margin: 10px 0 10px 0
            letter-spacing: 2px
    .buttons
        display: flex
        flex-direction: row
        justify-content: start
        a
            text-decoration: none
            color: white
            font-size: 16px

</style>