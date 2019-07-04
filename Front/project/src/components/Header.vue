<template>
    <div class="wrapper-header">
        <div style="flex: 1"></div>
        <router-link to="/" class="logo"></router-link>
        <div style="flex: 2"></div>
        <div class="wrapper-links">
            <router-link to="/films" class="link-button">
                <p class="link-text">Фильмы</p>
            </router-link>
            <router-link to="/news" class="link-button">
                <p class="link-text">Новости</p>
            </router-link>
            <router-link to="/contacts" class="link-button">
                <p class="link-text">О нас</p>
            </router-link>
            <div class="link-button">
                <p class="link-text">Еще</p>
            </div>
        </div>
        <div class="signIn">
            <div class="signIn-logo"></div>
            <p class="link-text">Войти</p>
        </div>
        <div style="flex: 1"></div>
    </div>
</template>
 
<style lang="sass" scoped>
.wrapper-header
    padding-top: 15px
    padding-bottom: 45px
    width: 100%
    height: 132px
    display: flex
    flex-direction: row
    justify-content: space-around
    align-items: center
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
