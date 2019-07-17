<template>
    <div class="search">
        <input type="text" :placeholder="ph" v-model="searchtype" @focus="showList = true" @blur="showList = false">
        <transition name="listTipes">  
            <ul v-if="showList" class="list">
                <li v-for="(item) in searchwords" :key="item.name" class="Types">
                    <label>{{item.name}}</label>
                </li>
            </ul>
        </transition>  
    </div>
</template>

<script>
export default {
    props:{
        filmTypeList: Object,
        ph: String,
    },
    data() {
        return {
            showList: false,
            searchtype: '',
            types:[
                {name: 'Комедия'},
                {name: 'Боевик'},
                {name: 'Триллер'},
                {name: 'Экшен'},
                {name: 'Драма'},
            ]
        }
    },
    computed: {
        searchwords: function() {
            var searchwords = this.searchtype && this.searchtype.toLowerCase();
            var searcharray = this.types;

            searcharray = this.types.filter(function(item){
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
.Types {
    list-style-type: none;
    height: 100%;
    background: rgb(255, 255, 255);
    width: 100%;

}
.Types:hover {
    background: rgb(85, 150, 247);
    opacity: 0.8;
}
.listTipes{
    padding: 10px;
}
.list-enter-active{
  transition: opacity .5s;
}
.list-enter{
  opacity: 0;
}
</style>