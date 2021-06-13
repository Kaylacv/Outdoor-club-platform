<template>
  <div class="card-carousel">
    <!-- <div class="show" v-for="(data) in datas" :key="data">
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
    </div> -->
  </div>
</template>

<style>

  .card-carousel {
    /*margin: 0 auto;*/
    margin-left: 50px;
    width: 300px;
    height: 320px;
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

<script>
  export default {
    name: 'Carousel',
    data: function () {
      return {
         includedComponents: "test-keep-alive",
        datas: [{
          id:'',
          pic:'',
          username:'',
          name:''
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
