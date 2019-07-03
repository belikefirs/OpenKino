<template>
    <div class="wrapper">
        <div class="logo"></div>
        <router-link to="/films" class="link">Фильмы</router-link>
        <router-link to="/news" class="link">Новости</router-link>
        <router-link to="/contacts" class="link">Контакты</router-link>
        <button class="signIn">Войти</button>
    </div>
</template>
 
<style lang="sass" scoped>
$logo-width : 200px
$logo-height : $logo-width
.wrapper
    background-color: #F73
    padding: 70px
    width: 100%
    height: 240px
    display: flex
    justify-content: space-around
    align-items: center
    .logo
        width: $logo-width
        height: $logo-height
        background-color: #F33
    .link
        text-decoration: none
        color: black
        font-size: 24px
        font-weight: 100
</style>
