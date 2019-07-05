<template>
    <v-carousel
    :cycle="false"
    :value="2"
    :hide-controls="true"
    >
        <v-carousel-item
        v-for="(item,i) in items"
        :key="i"
        :src="item.src"
        ></v-carousel-item>
  </v-carousel>
</template>

<script>
export default {
    data () {
      return {
        publicPath: process.env.BASE_URL,
        items: [
            {
                src: 'slider-images/img1.png'
            },
            {
                src: 'https://www.seruvenkitabevi.com/resimler/k-2018-03-21-2878686786.jpg'
            },
            {
                src: "https://game-3k.ru/wp-content/uploads/489cd2e781671b45f9b1a98e7b9c9bab.jpg"
            },
            {
                src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg'
            },
            {
                src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg'
            }
        ]
      }
    }
}
</script>
