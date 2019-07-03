<template>
    <div class="header">
        <ul>
            <li>
                <router-link to="/films">Фильмы</router-link>
            </li>
            <li>
                <router-link to="/news">Новости</router-link>
            </li>
            <li>
                <router-link to="/contacts">Контакты</router-link>
            </li>
        </ul>
    </div>
</template>

<style>
.header{
    width: 600px;
    height: 200px;
    background-color: #F52;
}
.header ul li{
    float: left;
}
</style>
