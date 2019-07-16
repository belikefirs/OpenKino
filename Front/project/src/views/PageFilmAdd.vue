<template>
    <div class="wrapper-admin">
        <p>Здравствуйте: Иван</p>
        <form class="log inputCont">
            <input type="name" placeholder="Название фильма">
            <input type="length" placeholder="Продолжительность">
            <input type="view" placeholder="Тип">
            <AddFilm></AddFilm>
            <input type="age" placeholder="Возрастное ограничение">
            <input type="rating" placeholder="Рейтинг">
            <br>
            <button class="button">Сохранить</button>
        </form>  
    </div>
</template>

<script>
import AdddFilm from '@/views/Admin.vue'
export default {
    components: {
        AddFilm
    }
}
</script>

<style>
.wrapper-admin {
    width: 500px;
    height: 500px;
    background: white;
    overflow: hidden;
    position: relative;
    z-index: 100;
}
.wrapper-admin p {
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
    text-align: center;
    padding: 10px 0 10px;

}
.inputCont{
    z-index: 0;
    padding: 18px 27px;
    display: flex;
    flex-direction: column;
    background: #eee;
}
.inputCont input{
    margin: 9px 0;
    padding: 0 15px;
    height: 42px;
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
}
.inputCont input:focus{
    outline: 0;
}
.button{
    overflow: hidden;
    text-align: center;
    line-height: 44px;
    min-width: 115px;
    height: 42px;
    text-decoration: none;
    user-select: none;
    background: white;
    cursor: pointer;
    text-decoration: none;
    font-family: 'Roboto', sans-serif;
    font-size: 16px;
    font-weight: 400;
    color: black;
    outline: none;
}
</style>