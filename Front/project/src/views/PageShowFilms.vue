<template>
    <div class="wrapper-film">
        <div class="film1">1</div>
        <div class="film2">2</div>
        <div class="film3">3</div>
        <div class="film4">4</div>
        <div class="film5">5</div>
        <div class="film6">6</div>
        <div class="film7">7</div>
        <div class="film8">8</div>
        <div class="film9">9</div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style>
    .wrapper-film {
    display: grid;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-columns: 1fr 1fr 1fr;
    grid-gap: 1vw;
    padding: 5px;
}
.wrapper-film > div {
    font-size: 6.5vw;
    padding: .5em;
    background: gold;
    text-align: center;
}
</style>
