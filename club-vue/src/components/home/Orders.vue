<template>
<div class="index">
   <div class="pagecenter" >
  <div><el-button type="text">
       <router-link class="article-link" style="font-size:16px" :to="{path:'./addClub'}">
       <i class="el-icon-circle-plus-outline">新建俱乐部</i>
       </router-link>
      </el-button>
      </div>
    
    <div v-for="tableData in tableData" :key="tableData" class="listborder">
   <div class="shoplist">
    <div class="shoppic">
            <img :src="tableData.clubPic" alt="封面">
          </div>
   <div class="shopdetail"> 
   <div class="title"><span>{{tableData.clubsName}}</span></div> 
   <div class="address"><span>地址：{{tableData.clubAddress}}</span></div> 
   <div class="time"><span>建立时间：{{tableData.clubTime}}</span></div>
  <el-button round @click="join(tableData.clubsName)">申请加入</el-button>
     </div>
   </div>
    </div>

    <div style="margin-top:850px;margin-bottom:20px">
  <el-pagination
        @size-change="handleSize"
        @current-change="handleCurrent"
        :current-page="this.paramss.page"
        :page-sizes="5"
        :page-size="this.paramss.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.totall"
      >
      </el-pagination>
</div>


  </div>
      </div>
</template>


<script>

export default {
  
  data() {
      
    return {    
   username : localStorage.getItem("username"),
   shopName : localStorage.getItem("shopName"),
            tableData: [
              {shopName:''
              }
            ],  
       totall:'',
        paramss: {
        page: 1,
        size: 9,
      },
       num: 1
    };
    
  },
  mounted() {
       this.getData();
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
      this.paramss.size = val;
      this.getData();
    },
    handleCurrent(val) {
      console.log(`当前页: ${val}`);
      this.paramss.page = val;
      this.getData();
    },
    getData:function(){
      this.$axios.get("/cjt/clubs/page?pageCode=" + this.paramss.page + "&pageSize=" + this.paramss.size)
      .then((res) => {
        console.log(res);
        this.tableData = res.data.list;
        this.totall = res.data.total;
      });
    }, 

    join(clubName){
       this.$confirm('确定申请加入该俱乐部?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
      this.$axios.get("/cjt/members/join?clubsName="+clubName+"&userName="+localStorage.getItem("username"))
      .then((res) => {
        console.log(res);
         this.$message({
            type: 'success',
            message: res.data.msg
          })
      });
      })
    } 
  },
};
</script>


<style>
.index{
  margin-top: 10px;
}
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .index {
    width: 1690px;
  
  }
    .pagecenter {
    width: 1650px;
    height: 800px;
    position: absolute;
    margin-left: 50px;
    margin-right: 100px;
}
.img {
    width: 500px;
    height: 300px;
}
.pagecenter img {
    width: 240px;
    height: 155px;
    float: left;
    margin-top: 20px;
}
.shopdetail {
    width: 180px;
    height: 140px;
    float: right;
    margin: 30px;
}
.title {
    font-size: 20px;
}
.address {
    margin-top: 30px;
    font-size: 14px;
}

.shoplist {
    width: 500px;
    height: 180px;
    margin: 15px;
}

.address {
    margin-top: 40px;
}
.listborder {
    border: 1px solid #E5E5E5;
    margin-bottom: 20px;
    border-radius: 10px;
    width: 500px;
    float: left;
    margin-right: 40px;
    height: 240px;
}

.time {
    margin-top: 10px;
    margin-bottom: 15px;
    font-size: 14px;
}

.reservetitle{
  font-size: 25px;
  margin-left: 300px;
}
 .article-link {
    text-decoration: none;
    color: #606266;
  }

</style>