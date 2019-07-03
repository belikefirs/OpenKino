<template>
  <div id="app">
    <div id="page">
      <Header></Header>
      <Footer></Footer>
    </div>
    <router-view/>
    
  </div>
</template>

<style lang="css">
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
#app{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;

  font-family: 'Avenir', Halvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
#page{
  width: 100vw;
}
</style>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
export default {
  name: 'home',
  components: {
    Header
  }
}
</script>
