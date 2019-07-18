<template>
    <div class="search">
        <input type="text"  
            :value="value"
            @input="$emit('input', $event.target.value)" 
            :placeholder="ph"
            @focus="showList = true"
            @blur="showList = false" 
        >
        <transition name="list  Tipes">  
            <ul v-if="showList" class="list">
                <li v-for="(item) in searchwords" :key="item.name" @click="clickword(item)" class="Types" >
                    <label>{{item.name}}</label>
                </li>
            </ul>
        </transition>  
    </div>
</template>

<script>
export default {
    props:{
        value: String,
        List: Array,
        ph: String,
    },
    data() {
        return {
            showList: false,
        }
    },
    computed: {
        searchwords: function() {
            var searchwords = this.value && this.value.toLowerCase();
            var searcharray =  [] || this.List;

            searcharray = this.List.filter(function(item){
                if(item.name.toLowerCase().indexOf(searchwords) !== -1) {
                    return item;
                }
            }
            )
            return searcharray;
        }
    },
    methods: {
        clickword: function(item) {
            this.$emit('clickWord', item);
        }
    }
}
</script>

<style>
.search{
    z-index: 0;
    display: flex;
    flex-direction: column;
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