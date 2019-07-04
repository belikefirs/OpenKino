<template>
  <div id="app">
      <div class="wrapper-page">
        <div id="page">
            <Header></Header>
            <Footer></Footer>
        </div>
      </div>
    <router-view/>
  </div>
</template>

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

<style lang="sass">
@import '/assets/fonts/raleway/raleway.css'
*
    margin: 0
    padding: 0
    box-sizing: border-box
#app
    display: flex
    flex-direction: row
    justify-content: center
    align-items: center
    -webkit-font-smoothing: antialiased
    -moz-osx-font-smoothing: grayscale
    font-family: 'Roboto'
.wrapper-page
    width: 1440px
    
    background: #fff url('assets/bg-image.png') center no-repeat
#page
    width: 100%
    min-height: 100vh
    background: rgba(#502090, 0.5)
</style>