<template>
  <div id="app">
        <Header></Header>
        <div class="wrapper-page">
        <div id="page">
            <router-view/>
        </div>
        </div>
        <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import PageAuthorization from '@/components/PageAuthorization.vue'
import Home from '@/views/Home.vue'
export default {

name: 'home',
    components: {
        Header, Home, Footer, PageAuthorization
    }
}
</script>

<style lang="sass">
*
    margin: 0
    padding: 0
    box-sizing: border-box
#app
    display: flex
    flex-direction: column
    justify-content: center
    align-items: center
    -webkit-font-smoothing: antialiased
    -moz-osx-font-smoothing: grayscale
    background: #fff url('assets/bg-image.png') center no-repeat
    font-family: 'Roboto'
.wrapper-page
    width: 100%
    background: #fff url('assets/bg-image.png') center no-repeat
#page
    width: 100%
    //min-height: 100vh
    background: rgba(#502090, 0.5)
</style>