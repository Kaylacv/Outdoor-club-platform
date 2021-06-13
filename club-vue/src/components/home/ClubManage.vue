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
        <el-menu-item index="/ClubInformM">
          <i class="el-icon-menu"></i>
          <span slot="title">公告管理</span>
        </el-menu-item>
        <el-menu-item index="/ClubPlaceM">
          <i class="el-icon-menu"></i>
          <span slot="title">场地管理</span>
        </el-menu-item>
        <!-- <el-menu-item index="/ClubReserveM">
          <i class="el-icon-menu"></i>
          <span slot="title">预约管理</span>
        </el-menu-item> -->
        <el-menu-item index="/ClubActivityM">
          <i class="el-icon-menu"></i>
          <span slot="title">活动管理</span>
        </el-menu-item>
        <!-- <el-menu-item index="/ClubIncomeM">
          <i class="el-icon-menu"></i>
          <span slot="title">收入管理</span>
        </el-menu-item> -->
        <el-menu-item index="/ClubMemberM">
          <i class="el-icon-menu"></i>
          <span slot="title">成员管理</span>
        </el-menu-item>
       </el-menu>
      </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  export default {

  }
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
