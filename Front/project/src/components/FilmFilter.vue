<template>
    <div class="wrapper-film">
        <div class="wrapper-filmFilter">
            <input type="text" class="search">
            <input type="text" class="date">
            <div class="rating"></div>
        </div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style>
.wrapper-film {
    width: 100%;
    height: 1000px;
}
.wrapper-filmFilter {
    display: flex;
    flex-direction: row;
}
.search {
    width: 590px;
    height: 40px;
    color: #f36021;
    font-family: Roboto;
    font-size: 14px;
    font-weight: 300;
    margin-right: 20px;
}
.date {
    width: 180px;
    height: 40px;
    color: #f36021;
    font-family: Roboto;
    font-size: 14px;
    font-weight: 300;
    margin-right: 23px;
}
.rating {
    width: 306px;
    height: 38px;
    border: 1px solid #ffffff;
}
</style>
