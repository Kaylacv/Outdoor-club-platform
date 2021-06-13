<template>
  <div class="quick-nav">
    <img src="../../assets/img/icon/icon2.png" alt="" class="logo">
    <div class="show" v-for="(data) in datas" :key="data">
    <img style="width:80px;height:80px" :src="data.pic">
    </div>
    <div class="show-l">用户名</div> 
    <div class="show-r" v-for="data in datas" :key="data">
    {{data.username}}
    </div>
    <div class="show-l">真实姓名</div>
    <div class="show-r" v-for="data in datas" :key="data">
    {{data.name}}
    </div>
      <div class="show-l">手机号码</div>
    <div class="show-r" v-for="data in datas" :key="data">
    {{data.phone}}
    </div>
    <div class="show-l">电子邮箱</div>
    <div class="show-r" v-for="data in datas" :key="data">
    {{data.email}}
    </div>
  </div>
</template>

<script>
  export default {
    name: 'QuickNav',
   data: function () {
      return {
         includedComponents: "test-keep-alive",
        datas: [{
          id:'',
          pic:'',
          username:'',
          name:'',
          phone:'',
          email:''
          }]
      }
    },
    mounted () {
      this.getData()
    },
    methods: {
    getData:function(){
           this.$axios.get("/userMessage?username="+localStorage.getItem("username"))
      .then((res) => {
        console.log(res);
         this.datas = res.data;
         this.options = res.data;
      });
    },
    }
  }
</script>

<style scoped>
  .quick-nav {
    width: 303px;
    height: 318px;
    background-color: transparent;
  }


  .logo {
    width: 280px;
    position: absolute;
    margin-left: 45%;
    top: 50px;
    left: 210px;
  }

  .show-l {
    margin-bottom: 20px;
    margin-right: 30px;
    margin-left: 30px;
    width: 80px;
     position: relative;
}
.show-r{
    margin-left: 150px;
    margin-bottom: 20px;
     position: relative;
}
.showpic{
  float: right;
  
}

</style>
