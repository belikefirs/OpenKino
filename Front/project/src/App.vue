<template>
  <div id="app">
    <div id="nav">
      <Header/>
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
