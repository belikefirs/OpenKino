<template>
  <v-carousel>
    <v-carousel-item
      v-for="(item,i) in items"
      :key="i"
      :src="item.src"
      height="250px"
    ></v-carousel-item>
  </v-carousel>
</template>

<script>
  export default {
    data () {
      return {
        items: [
          {
            src: '../assets/1.jpg'
          },
          {
            src: '../assets/2.jpg'
          },
          {
            src: '../assets/3.jpg'
          },
          {
            src: '../assets/4.jpg'
          },
          {
            src: '../assets/5.jpg'
          },
          {
            src: '../assets/6.jpg'
          },
          {
            src: '../assets/7.jpg'
          }
        ]
      }
    }
  }
</script>

