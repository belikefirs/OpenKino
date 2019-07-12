<template>
    <div class="wrapper-registra">
        <div class="wrapper_window">
            <p class="title_auto">Регистрация</p>
            <div class="login_password" style="margin: 30px 0 0 0">
                <input type="name" placeholder="Имя">
                <input type="surname" placeholder="Фамилия">
                <input type="email" placeholder="E-mail">
                <input type="password" placeholder="Пароль">
                <input type="password" placeholder="Повторите пароль">
            </div>
            <div class="buttons">
                <AppButtonSignIn style="margin: 18px 0px 10px 25px;" v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButtonSignIn>
            </div>
        </div>
    </div>
</template>

<script>
import AppButtonSignIn from '@/components/AppButtonAuthorization.vue'
export default {
    components: {
        AppButtonSignIn
    },
    data() {
        return {
            links: [
                {name: 'Регистрация', link: ''}
            ]
        }
    }
}
</script>

<style lang="sass">
.wrapper-registra
    width: 400px
    height: 450px
    background: linear-gradient(to top left, #d1d1d1, #212121)
    border-radius: 8px
    opacity: 0.8
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
                width: 100%
                height: 38px
                background: rgba(#ffffff, 0.9)
                margin: 10px 0 10px 0
                // letter-spacing: 2px
                border-radius: 10px
                outline: none
        .buttons
            display: flex
            flex-direction: row
            justify-content: center
</style>
