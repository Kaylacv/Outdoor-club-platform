<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">俱乐部</span>
    </div>
    <div class="block">
       <span style="font-weight: bold;font-size: 18px">我的创建</span>
   <div v-for="clubList in clubList" :key="clubList" class="clubList.id"> 
      <div class="clubPic"> 
        <img  style="width: 240px;height: 155px;margin:20px" :src="clubList.clubPic" alt="封面"> 
        <div class="role">{{clubList.roles}}</div>
        <div class="clubname"><el-link :underline="false" style="font-size:20px" @click="inclub(clubList.clubsId,clubList.enabled)">{{clubList.clubsName}}</el-link>
         <div style="margin-top:50px;font-size:14px">{{clubList.clubDecs}}</div>
         <div style="margin-top:10px;font-size:14px">{{clubList.clubTime}}</div>
         <div style="margin-top:10px;font-size:14px">{{clubList.clubAddress}}</div>
         </div>
      </div> 
     </div> 
     <div style="margin-left:350px">
      <el-pagination
        @size-change="handleSize"
        @current-change="handleCurrent"
        :current-page="this.paramss1.page"
        :page-sizes="3"
        :page-size="this.paramss1.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.totall1"
      >
      </el-pagination>
      </div>
    </div>

      <div class="block">
      <span style="font-weight: bold;font-size: 18px">我的加入</span>
     <div v-for="clubList1 in clubList1" :key="clubList1" class="clubList.id"> 
      <div class="clubPic"> 
        <img  style="width: 240px;height: 155px;margin:20px" :src="clubList1.clubPic" alt="封面"> 
        <div class="role">{{clubList1.roles}}</div>
         <div class="clubname"><el-link :underline="false" style="font-size:20px" @click="inclub1(clubList1.clubsId,clubList1.enabled)">{{clubList1.clubsName}}</el-link>
         <div style="margin-top:50px;font-size:14px">{{clubList1.clubDecs}}</div>
         <div style="margin-top:10px;font-size:14px">{{clubList1.clubTime}}</div>
         <div style="margin-top:10px;font-size:14px">{{clubList1.clubAddress}}</div>
         </div>
      </div> 
     </div> 
     <div style="margin-left:350px">
      <el-pagination
        @size-change="handleSize1"
        @current-change="handleCurrent1"
        :current-page="this.paramss.page"
        :page-sizes="3"
        :page-size="this.paramss.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.totall"
      >
      </el-pagination>
      </div>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: 'UpdateCard',
  data() {
    return {    
   username : localStorage.getItem("username"),
   clubList:[],
   clubList1:[],
       totall1:'',
        paramss1: {
        page: 1,
        size: 3,
      },
      totall:'',
        paramss: {
        page: 1,
        size: 5,
      },
       num: 1,
    };
    
  },
  mounted() {
       this.getClub();
       this.getClus1();
  },
    props:{
      model:{
          type:String,
          default:""
      },
    },
  methods: {
    handleSize(val) {
      console.log(`每页 ${val} 条`);
      this.paramss1.size = val;
      this.getClub();
    },
    handleCurrent(val) {
      console.log(`当前页: ${val}`);
      this.paramss1.page = val;
      this.getClub();
    },
    getClub:function(){
           this.$axios
      .get("/cjt/members/page?userName="+localStorage.getItem("username")+"&pageCode=" + this.paramss1.page + "&pageSize=" + this.paramss1.size)
      .then((res) => {
        console.log(res);
        this.clubList = res.data.list;
        this.totall1 = res.data.total;
      });
    }, 
    handleSize1(val) {
      console.log(`每页 ${val} 条`);
      this.paramss.size = val;
      this.getClus1();
    },
    handleCurrent1(val) {
      console.log(`当前页: ${val}`);
      this.paramss.page = val;
      this.getClus1();
    },
    getClus1:function(){
      this.$axios.get("/cjt/members/mempage?userName="+localStorage.getItem("username")+"&pageCode=" + this.paramss.page + "&pageSize=" + this.paramss.size)
      .then((res) => {
        console.log(res);
        this.clubList1 = res.data.list;
        this.totall = res.data.total;
      });
    },
    inclub:function(clubsId,enabled){
      console.log(clubsId,enabled)
      if(enabled==true){
       this.$router.push(
          {
            name: 'ClubInform',
            query: {
              clubsId: clubsId
            }
          }
        )}else if(enabled==false){
          this.$message({
            type: 'info',
            message: '已被冻结'
          })
        }
      },
      inclub1:function(clubsId,enabled){
        console.log(clubsId,enabled)
      if(enabled==true){
       this.$router.push(
          {
            name: 'ClubInform1',
            query: {
              clubsId: clubsId
            }
          }
        )}else if(enabled==false){
          this.$message({
            type: 'info',
            message: '已被冻结'
          })
        }
      }
    } 
}
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 100%;
    text-align: left;
    
  }
  .block{
   width: 800px;
  }
  .clubList{
    height:200px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    margin-bottom: 20px;
  }
  .clubPic{
  margin-top: 20px;
  width: 700;
}
.clubname{
  float: right;
  width: 300px;
  margin-top: 20px;
  margin-right: 120px;
  font-size: 18px;
}
.role{
    width:50px;
    height:20px;
    float:right;
    margin-top:20px;
    margin-right:10px;
    font-size:14px;
    color:rgb(211 210 208)
}
</style>
