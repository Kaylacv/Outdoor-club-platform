<template>
  <div style="margin-top: 10px">
     <ClubSideMenu1 id="side-menu"></ClubSideMenu1>
      <div class="home">
        <router-view/>
      </div>
  </div>
</template>

<script>
  import ClubSideMenu1 from './ClubSideMenu1'
  export default {
    name: 'MemIndex',
    components: {ClubSideMenu1}
  }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;
  }

  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
  }

  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: -670px;
    top: 100px;
  }

  #club-menu {
    position: fixed;
    margin-left: 80%;
    top: 100px;
  }
</style>

