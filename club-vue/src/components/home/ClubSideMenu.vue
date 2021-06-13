<template>
  <div class="home">
    <div class="homeNavigation">
      <el-row class="tac">
        <el-col>
          <el-menu
            class="sidebar-el-menu"
            :default-active="$route.path"
            @open="handleOpen"
            @close="handleClose"
            router
          >
            <el-menu-item index="/Clubforum">
              <i class="el-icon-menu"></i>
              <span slot="title">论坛</span>
           </el-menu-item>
           <el-menu-item index="/ClubInform">
              <i class="el-icon-menu"></i>
              <span slot="title">公告</span>
           </el-menu-item>
            <el-menu-item index="/Clubplace">
              <i class="el-icon-menu"></i>
              <span slot="title">场地</span>
           </el-menu-item>
            <el-menu-item index="/ClubActivity">
              <i class="el-icon-menu"></i>
              <span slot="title">活动</span>
           </el-menu-item>
            <el-menu-item index="/ClubMember">
              <i class="el-icon-menu"></i>
              <span slot="title">成员</span>
           </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
  	  
  	<script>
export default {
  methods: {},
};
</script>

 <style lang="scss" scoped>
.home {
  height: 100%;
  .homeNavigation {
     width: 170px;
    height: 100%;
  }
}
</style>