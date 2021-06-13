<template>
     <div>  
        <div class="searchactivity">
      <el-input
        placeholder="通过用户名搜索..."
        prefix-icon="el-icon-search"
        size="medium"
        class="searchactivityBox"
        v-model="userName"
        @keyup.enter.native="search">
      </el-input>
   </div>
    <el-card style="margin-top:60px;width: 95%">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          prop="userName"
          label="用户名"
          fit>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="viewActivity(scope.row.activityId)"
              type="text"
              size="small">
              查看
            </el-button>
            <el-button
              @click.native.prevent="deleteMember(scope.row.memberId)"
              type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 50px 0">
        <el-pagination
          background
          style="float:right;"
           @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="this.params.page"
        :page-sizes="5"
        :page-size="this.params.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.total">
        </el-pagination>
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    name: 'ArticleManagement',
    data () {
      return {
        dialogFormVisible: false,
        addActivityVisible:false,
        clubsId:  localStorage.getItem("clubsId"),
        articles: [],
       total:'',
      params: {
        page: 1,
        size: 5,
      },
        formLabelWidth: '120px',
        userName:''
      }
    },
    mounted () {
      this.getData()
    },
    computed: {
      tableHeight () {
        return window.innerHeight - 320
      }
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
    this.$axios.get("/cjt/members/clubpage?clubsId="+localStorage.getItem("clubsId")+"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        this.tableData = res.data.list;
        this.total = res.data.total;
      });
    },
      editArticle (article) {
        this.$router.push(
          {
            name: 'Editor',
            params: {
              article: article
            }
          }
        )
      },
      deleteMember (memberId) {
        this.$confirm('确定踢出该用户?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios.delete("/cjt/members/deleteMem?memberId=" + memberId).then(resp => {
              if (resp && resp.status=== 200) {
                this.getData()
                this.$message({
                 type: 'success',
                  message: '已踢出'
               })
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      },
      search(keywords){
         if (keywords.keyCode==13) {
            this.searchname()
         }
      },
       searchname(){
          this.$axios.get('/cjt/members/search?userName=' + this.userName
          +'&clubsId='+localStorage.getItem("clubsId"))
            .then(resp => {
               console.log(resp)
              if (resp && resp.status === 200) {
                 this.tableData = resp.data;
                 this.userName=""
                 this.$message({
                 type: 'success',
                  message: '搜索成功'
               })
              }
            })
      }
    }
  }
</script>

<style scoped>
.searchactivity{
 width: 100%;
 padding: 10px;
 margin-top: 40px;
  }
.searchactivityBox{
    width: 300px;
    position:absolute;
}
</style>
