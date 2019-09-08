<template>
    <div class="map">

    </div>
</template>

<script>
import ymaps from 'ymaps';

export default {
    mounted(){
        ymaps.load().then(maps => {
            const map = new maps.Map(this.$el, {
            center: [53.20006, 50.15],
            zoom: 15,
            });
            var placemark = new maps.Placemark([53.2, 50.15], {iconCaption: 'OpenCinema'});
            map.geoObjects.add(placemark);
        })

        ymaps.load('https://api-maps.yandex.ru/2.1/?lang=ru_US').then(maps => {
            // *** //
        })
    }
}
</script>

<style scoped>
.map {
    height: 170px;
    width: 300px;
}
</style>
