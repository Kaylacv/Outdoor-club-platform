<template>
  <div style="margin-top: 40px">
    <!--<el-button @click="addArticle()">添加文章</el-button>-->
    <div class="articles-area">
      <el-card style="text-align: left">
        <div v-for="tableData in tableData" :key="tableData.carId">
          <div style="float:right;width:85%;height: 150px;">
            <!-- <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"> -->
            <span style="font-size: 20px"><strong>{{tableData.title}}</strong></span>
            <!-- </router-link> -->
            <el-divider content-position="left">{{tableData.goodCount}}</el-divider>
            <!-- <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"> -->
            <p>{{tableData.cprice}}</p>
            <!-- </router-link> -->
          </div>
          <el-image
            style="margin:18px 0 0 30px;width:100px;height: 100px"
            :src="tableData.cover"
            fit="cover"></el-image>
          <el-divider></el-divider>
        </div>
      </el-card>
    </div>
    <el-pagination
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
</template>

<script>

  export default {
    name: 'Car',
    data () {
      return {
       articles: [],
       total:'',
      params: {
        page: 1,
        size: 8,
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
           this.$axios
      .get("/cjt/cars/page?userName="+localStorage.getItem("username")+"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        console.log(res);
        this.tableData = res.data.list;
        this.total = res.data.total;
      });
    },
    }
  }
</script>

<style scoped>
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

  .article-link:hover {
    color: #409EFF;
  }
</style>
