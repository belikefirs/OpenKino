<template>
<!-- акции -->
<!-- отзывы -->
    <div class="wrapper-header" :style="{height: Height}">
        <WrapperCent>
            <router-link to="/" class="logo"></router-link>
            <div style="flex: 2"></div>
            <div class="wrapper-links">
                <AppButton v-for="item in links" :key="item.link" :url="{name: item.link}">{{item.name}}</AppButton>
            </div>
            <div class="signIn">
                <div class="signIn-logo"></div>
                <p class="link-text">Войти</p>
            </div>
        </WrapperCent>
    </div>
    
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenterize.vue'
import AppButton from '@/components/AppButton.vue'

export default {
    components: {
        WrapperCent, AppButton
    },
    props:{
        Height:{
            type: String, 
            required: true
        }
    },
    data () {
        return {
            links: [
                { name: 'Новости', link: 'name'},
                { name: 'Фильмы', link: 'films'},
                { name: 'О нас', link: 'about'},
                { name: 'Еще', link: ''},
            ]
        }
    }
}
</script>

 
<style lang="sass" scoped>
.wrapper-header
    position: fixed
    top: 0
    width: 100%
    // height: 132px
    display: flex
    flex-direction: row
    justify-content: space-around
    align-items: center
    background: #222
    .logo
        width: 170.4px
        height: 71.2px
        background: url('../assets/logo.svg') center no-repeat
    .link-text
        text-decoration: none
        font-family: 'Roboto', sans-serif
        font-size: 12px
        color: white
    .wrapper-links
        display: flex
        margin-right: 56px
        .link-button
            text-align: center
            line-height: 35px
            margin: 0 10px
            width: 121px
            height: 35px
            border: 1px solid white
            border-radius: 15px
            text-decoration: none
            user-select: none
            &:hover
                background-color: rgba(white, 0.3)
    .signIn
        display: flex
        justify-content: center
        align-items: center
        user-select: none
        cursor: pointer
        .signIn-logo
            width: 45px
            height: 45px
            background: url('../assets/signIn-logo.svg')
        &:hover .link-text
            text-decoration: underline    
</style>
