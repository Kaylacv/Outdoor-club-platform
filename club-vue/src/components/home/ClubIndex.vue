<template>
  <div style="margin-top: 10px">
     <ClubSideMenu id="side-menu"></ClubSideMenu>
     <ClubManage id="club-menu"></ClubManage>
      <div class="home">
        <router-view/>
      </div>
  </div>
</template>

<script>
  import ClubSideMenu from './ClubSideMenu'
  import ClubManage from './ClubManage'
  export default {
    name: 'ClubIndex',
    components: {ClubSideMenu,ClubManage}
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

