<template>
  <div id="app">
    <div id="nav">
      <Header></Header>
    </div>
    <router-view/>
    
  </div>
</template>

<style lang="css">
#app{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
</style>

<script>
import Header from '@/components/Header.vue'

export default {
  name: 'home',
  components: {
    Header
  }
}
</script>
