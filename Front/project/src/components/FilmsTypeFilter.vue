<template>
    <div class="search">
        <input type="text" placeholder="Введите жанр фильма:" v-model="searchtype" @focus="showList = true" @blur="showList = false">
        <ul v-if="showList">
            <li v-for="(item) in searchwords" :key="item.name" class="listType">
                <label>{{item.name}}</label>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    props:{
        filmTypeList: Object,
    },
    data() {
        return {
            showList: false,
            searchtype: '',
        }
    },
    computed: {
        searchwords: function() {
            var searchwords = this.searchtype && this.searchtype.toLowerCase();
            var searcharray = this.filmTypeList;

            searcharray = this.filmTypeList.filter(function(item){
                if(item.name.toLowerCase().indexOf(searchwords) !== -1) {
                    return item;
                }
            }
            )
            return searcharray;
        }
    }
}
</script>

<style>
.search{
    z-index: 0;
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
.listType {
    list-style-type: none;
}
</style>