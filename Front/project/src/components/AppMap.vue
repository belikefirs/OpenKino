<template>
    <div class="map">

    </div>
</template>

<script>
import ymaps from 'ymaps';


export default {
    mounted(){
        ymaps
        .load()
        .then(maps => {
            const map = new maps.Map(this.$el, {
            center: [53.20006, 50.15],
            zoom: 15
            });
        })
        .catch(error => console.log('Failed to load Yandex Maps', error));

        ymaps.load('https://api-maps.yandex.ru/2.1/?lang=ru_US').then(maps => {
  /* ... */
});
    }
}
</script>

<style>
.map {
    height: 170px;
    width: 300px;
}
</style>
