<template>
   <div style="margin-top:50px">
    <el-card style="margin: 18px 2%;width: 95%">
    <h3 style="float:left;color:#919191">活动预约</h3>
      <el-table
        :data="activityData"
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
                <span>预约时间：{{ props.row.reserveTime }}</span>
              </el-form-item>
              <el-form-item>
                <span>支付时间：{{ props.row.payTime }}</span>
              </el-form-item>
               <el-form-item>
                <span>价格：{{ props.row.actPrice }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
         <el-table-column
          prop="activityTitle"
          label="活动标题"
           width="180">
        </el-table-column>
        <el-table-column
          prop="userName"
          label="用户名"
           width="150">
        </el-table-column>
        <el-table-column
          prop="userPay"
          label="支付状态"
          width="120">
        </el-table-column>
        <el-table-column
          prop="usestatus"
          label="使用状态"
          width="120">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="editArticle(scope.row)"
              type="text"
              size="small">
              使用
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

    <el-card style="margin: 18px 2%;width: 95%">
    <h3 style="float:left;color:#919191">场地预约</h3>
      <el-table
        :data="placeData"
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
                <span>预约时间：{{ props.row.reserveTime }}</span>
              </el-form-item>
              <el-form-item>
                <span>支付时间：{{ props.row.payTime }}</span>
              </el-form-item>
               <el-form-item>
                <span>价格：{{ props.row.placePrice }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          prop="placeName"
          label="场地名称"
          width="180">
        </el-table-column>
        <el-table-column
          prop="placePrice"
          label="价格"
          width="150">
        </el-table-column>
         <el-table-column
          prop="userPay"
          label="支付状态"
          width="120">
        </el-table-column>
        <el-table-column
          prop="usestatus"
          label="使用状态"
          width="120">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="editArticle(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
            <el-button
              @click.native.prevent="deleteReserve(scope.row.reserveId)"
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
          layout="total, prev, pager, next, jumper"
          @current-change="handleCurrentChange1"
          :page-size="pageSize"
          :total="total1">
        </el-pagination>
      </div>
    </el-card>
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
       total1:'',
      params1: {
        page: 1,
        size: 7,
      },
      }
    },
    mounted () {
      this.getActivity()
      this.getPlace()
    },
    methods: {
       handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.params.size = val;
      this.getActivity();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.params.page = val;
      this.getActivity();
    },
    getActivity:function(){
           this.$axios.get("/cjt/reserves/managerGet?clubId="+localStorage.getItem("clubsId")+"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        console.log(res);
        this.activityData = res.data.list
        this.total = res.data.total;
      });
    },
     handleSizeChange1(val) {
      console.log(`每页 ${val} 条`);
      this.params1.size = val;
      this.getPlace();
    },
    handleCurrentChange1(val) {
      console.log(`当前页: ${val}`);
      this.params1.page = val;
      this.getPlace();
    },
    getPlace:function(){
           this.$axios.get("/cjt/reserves/managerPlace?clubId="+localStorage.getItem("clubsId")+"&pageCode=" + this.params1.page + "&pageSize=" + this.params1.size)
      .then((res) => {
        console.log(res);
        this.placeData = res.data.list
        this.total1 = res.data.total;
      });
    },
      deleteReserve (id) {
        this.$confirm('确定删除该预约?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios.delete('/cjt/reserves/delete?reserveId=' + id).then(resp => {
                  console.log(resp)
              if (resp) {
                  this.getActivity()
                 this.getPlace()
                 this.$message({
                 type: 'success',
                  message: '删除成功'
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
      }
    }
  }
</script>

<style scoped>
.add{
      float:right;
      margin-right:30px;
      margin-top:20px;
      margin-bottom:20px
  }
</style>
