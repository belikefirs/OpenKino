<template>
    <header>
        <div class="links-list">
            <router-link to="/films" class="link">Фильмы</router-link>
            <router-link to="/news" class="link">Новости</router-link>
            <router-link to="/contacts" class="link">Контакты</router-link>
        </div>
    </header>
</template>
 
 <style scoped>
 header{
    background-color: #F73;
    width: 100%;
    height: 240px;
 }
 .link{
    text-decoration: none;
    color: black;
    margin: 4px;
 }
 </style>
 
