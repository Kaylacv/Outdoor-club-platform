<template>
<div class="index">
     <div class="placepage" >  
  <div style="margin-top: 40px">
    <!--<el-button @click="addArticle()">添加文章</el-button>-->
    <div class="articles-area">
      <div class="block">
        <div v-for="tableData in tableData" :key="tableData">
          <!-- <span>{{tableData.announcetitle}}</span> -->
       <el-card class="box-card">
         <div class="text item"><router-link :to="{path:'ClubActivityD1',query:{activityId: tableData.activityId}}">{{tableData.activityTitle}}</router-link></div>
       </el-card>
        </div>
      </div>
    </div>
   <el-pagination style="margin-bottom:50px"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="this.params.page"
        :page-sizes="5"
        :page-size="this.params.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.total"
      >
      </el-pagination>
       </div>
     </div>
  </div>
</template>

<script>

  export default {
    name: 'Articles',
    data () {
      return {
        clubsId:  localStorage.getItem("clubsId"),
        articles: [],
        total:'',
      params: {
        page: 1,
        size: 7,
      },
      }
    },
    mounted () {
      this.getData()
    },
    methods: {
       handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.params.size = val;
      this.getData();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.params.page = val;
      this.getData();
    },
    getData:function(){
           this.$axios.get("/cjt/activities/clubGet?clubId="+localStorage.getItem("clubsId")+"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        console.log(res);
        this.tableData = res.data.list
        this.total = res.data.total;
      });
    },
     
    }
  }
</script>

<style scoped>
.index{
  margin-top: 10px;
}
.placepage {
    width: 350px;
    height: 500px;
    position: absolute;
    margin-top: 20px;
}
  .articles-area {
    width: 990px;
    height: 750px;
    margin-left: auto;
    margin-right: auto;
  }

  .article-link {
    text-decoration: none;
    color: #606266;
  }
  .block{
   width: 800px;
  }

  .article-link:hover {
    color: #409EFF;
  }

  .text {
    font-size: 14px;
    float: left;
    margin-bottom: 20px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 960px;
    margin-bottom: 20px;
  }
</style>
