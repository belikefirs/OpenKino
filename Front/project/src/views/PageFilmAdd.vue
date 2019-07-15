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
            <div class="button">Сохранить</div>
        </form>  
    </div>
</template>

<script>
import AddFilm from '@/components/FilmsTypeFilter.vue'
export default {
    components: {
        AddFilm
    }
}
</script>

<style>
.wrapper-admin {
    width: 500px;
    height: 100%;
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
    list-style-type: none;
}
.inputCont input:focus{
    outline: 0;
}
.button{
    overflow: hidden;
    text-align: center;
    line-height: 44px;
    min-width: 115px;
    height: 44px;
    text-decoration: none;
    user-select: none;
    background: #fff;
    cursor: pointer;
    text-decoration: none;
    font-family: 'Roboto', sans-serif;
    font-size: 20px;
    font-weight: 300;
    color: black;
    outline: none;
    border: 1px solid #aaa;
}
.button:hover {
    background: #222;
    color: white;
    transition: all 0.3s ease-out;
}
</style>