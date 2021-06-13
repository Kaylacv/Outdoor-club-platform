<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>内容管理</el-breadcrumb-item>
        <el-breadcrumb-item>俱乐部活动管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline>
              <el-form-item>
                <span>开始时间：{{ props.row.startTime }}</span>
              </el-form-item>
               <el-form-item>
                <span>结束时间：{{ props.row.endTime }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          prop="activityTitle"
          label="标题"
          fit>
        </el-table-column>
        <el-table-column
          prop="clubsName"
          label="俱乐部名称"
          fit>
        </el-table-column>
        <el-table-column
          prop="upTime"
          label="发布日期"
          width="200">
        </el-table-column>
        <el-table-column
          prop="checking"
          label="状态"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="viewArticle(scope.row.activityId)"
              type="text"
              size="small">
              查看
            </el-button>
            <el-button
              @click.native.prevent="update(scope.row.activityId)"
              type="text"
              size="small">
              通过
            </el-button>
            <el-button
              @click.native.prevent="update1(scope.row.activityId)"
              type="text"
              size="small">
              未通过
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 50px 0">
        <el-pagination
          background
          style="float:right;"
          layout="total, prev, pager, next, jumper"
          @current-change="handleCurrentChange"
          :page-size="pageSize"
          :total="total">
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
        articles: [],
        total:'',
      params: {
        page: 1,
        size: 10,
      },
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
           this.$axios.get("/cjt/activities/page?pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        console.log(res);
        localStorage.setItem("clubsId", this.$route.query.clubsId);
        this.tableData = res.data.list;
        this.total = res.data.total;
      });
    },
    update:function(id){
      this.$axios.get("/cjt/activities/update?activityId="+id+"&checking="+"通过")
      .then((res) => {
        console.log(res);
        this.tableData = res.data.list;
        this.total = res.data.total;
        this.getData()
         this.$message({
            type: 'success',
            message: '已设置通过'
          })
      });
    },
     update1:function(id){
      this.$axios.get("/cjt/activities/update?activityId="+id+"&checking="+"未通过")
      .then((res) => {
        console.log(res);
        this.tableData = res.data.list;
        this.total = res.data.total;
        this.getData()
         this.$message({
            type: 'info',
            message: '已设置未通过'
          })
      });
    },
    viewArticle:function(activityId){
      console.log(activityId)
      this.$router.push(
          {
            name: 'viewAct',
            query: {
              activityId: activityId
            }
          }
        )
    }
    }
  }
</script>

<style scoped>
  .add-link {
    margin: 18px 0 15px 10px;
    float: left;
  }
</style>
