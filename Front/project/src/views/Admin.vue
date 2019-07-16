<template>
    <form class="search">
        <input type="text" placeholder="Введите жанр фильма:" v-model.trim="searchtype">
        <ul>
            <li v-for="(item) in types" :key="item.types">
                <label>
            </li>
        </ul>
    </form>
</template>

<script>
export default {
    data() {
        return {
            types: [
                {name: 'Боевик'},
                {name: 'Комедия'},
                {name: 'Экшен'},
                {name: 'Ужасы'},
                {name: 'Драма'},
                {name: 'Триллер'},
            ]
        }
    },
    computed: {
        searchwords: function() {
            var searchwords = this.searchwords;

        }
    }
}
</script>

<style>
.search{
    z-index: 0;
    padding: 18px 27px;
    display: flex;
    flex-direction: column;
    background: #eee;
}
.search input{
    margin: 9px 0;
    padding: 0 15px;
    height: 42px;
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
}
</style>
