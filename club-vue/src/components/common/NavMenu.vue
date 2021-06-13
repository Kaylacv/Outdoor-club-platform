<template>
  <div>
    <el-menu
      :default-active="currentPath"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 1300px">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <span style="position: absolute;padding-top: 5px;right: 43%;font-size: 28px;font-weight: bold">户&nbsp;&nbsp; 外&nbsp;&nbsp;运 &nbsp;&nbsp;动&nbsp;&nbsp; 联 &nbsp;&nbsp;盟</span>
      <el-input
        placeholder="快速搜索..."
        prefix-icon="el-icon-search"
        size="medium"
        style="width: 300px;position:absolute;margin-top: 12px;right: 18%"
        v-model="keywords">
      </el-input>
      <el-link icon="el-icon-s-grid" style="float:right"><router-link to="/login2">用户登录</router-link></el-link>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/library', navItem: '首页'}, 
          {name: '/orders', navItem: '俱乐部'},  
          {name: '/car', navItem: '购物车'},  
          {name: '/jotter', navItem: '公告'},    
          {name: '/index', navItem: '个人中心'},  
          {name: '/login', navItem: '管理中心'}
        ],
        keywords: ''
      }
    },
    computed: {
      hoverBackground () {
        return '#ffd04b'
      },
      currentPath () {
        var x = this.$route.path.indexOf('/', 1)
        if (x !== -1) {
          return this.$route.path.substring(0, x)
        } else {
          return this.$route.path
        }
      }
    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }

</style>
