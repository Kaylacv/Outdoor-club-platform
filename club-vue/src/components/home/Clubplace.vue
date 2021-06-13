<template>
<div class="index">
   <div class="placepage" >    
    <div v-for="tableData in tableData" :key="tableData" class="listborder">
   <div class="placelist">
    <div class="shoppic">
    <img :src="tableData.placePic" alt="暂无图片">
    </div>
   <div class="shopdetail"> 
   <div class="title"><span>{{tableData.placeName}}</span></div> 
   <div class="placedesc"><span>简介：{{tableData.placeDecs}}</span></div> 
   <div class="price"><span>价格：￥{{tableData.placePrice}}元/小时</span></div>
  <el-button round @click="reserve(tableData.placeId)">预约</el-button>
     </div>
   </div>
    </div>
    <div style="margin-top:650px;margin-bottom:20px">
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

        <!-- <el-dialog title="预约场地" :visible.sync="dialogFormVisible"  @close="clear">
      <el-form :model="form" style="text-align: left" ref="form">
        <el-form-item label="日期" :label-width="formLabelWidth" prop="reserveDate">
           <el-date-picker v-model="reserveDate" type="date" placeholder="选择日期"> </el-date-picker>
        </el-form-item>
       <el-form-item label="时间" :label-width="formLabelWidth" prop="reserveTime">
          <el-checkbox-group  v-model="reserveTime" size="small">
            <el-checkbox label="1" border>9:00</el-checkbox>
            <el-checkbox label="2" border>11:00</el-checkbox>
            <el-checkbox label="3" border>12:00</el-checkbox>
            <el-checkbox label="4" border>14:00</el-checkbox>
            <el-checkbox label="5" border>16:00</el-checkbox>
            <el-checkbox label="6" border>18:00</el-checkbox>
               <div style="color: rgb(255 141 0);font-size:13px;margin-top:15px">温馨提示：每2小时预约1次，限5人</div>
          </el-checkbox-group>
       </el-form-item>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="add">确 定</el-button>
      </el-form>
    </el-dialog> -->

      <el-dialog
      title="添加场地"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form :model="form" style="text-align: left" ref="form">
        <el-form-item label="日期" :label-width="formLabelWidth" prop="reserveDate">
           <el-date-picker v-model="form.reserveDate" align="right"
      type="date"
       format="yyyy 年 MM 月 dd 日"
       value-format="yyyy-MM-dd"
      placeholder="选择日期" 
      :picker-options="startDate"> </el-date-picker>
        </el-form-item>
        
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="add">确 定</el-button>
      </div>
    </el-dialog>


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
        dialogFormVisible:false,
        articles: [],
        total:'',
        params: {
        page: 1,
        size: 7,
      },
       value1: '',
      tableData: [], 
       form: {
         id:'',
         reserveDate:'',
         reserveTime:''
        },
         radio3: []
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
           this.$axios.get("/cjt/places/clubpage?clubsId="+localStorage.getItem("clubsId")+"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        console.log(res);
        this.tableData = res.data.list
        this.total = res.data.total;
      });
    },
     reserve(id){
       console.log(id)
       this.form.id=id
       this.dialogFormVisible = true
     },
       add () {
         console.log(this.form.id,this.form.reserveDate)
        var _this = this
        this.$axios.post('/cjt/reserves/addReserve', {
            userName: localStorage.getItem("username"),
            reserveDate:this.form.reserveDate,
            reserveTime:this.form.reserveTime,
            activityId:'',
            placeId:this.form.id,
            goodCount: 1,
            clubId: localStorage.getItem("clubsId"),
          }).then(resp => {
            console.log(resp)
            if (resp.status === 200) {
              this.$message({
						type: 'success',
						message: '已加入购物车'
				    	})
              // 修改角色后重新请求用户信息，实现视图更新
              this.loadBooks()
            } 
          })
      },
    }
  }
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
    .placepage {
    width: 350px;
    height: 500px;
    position: absolute;
    margin-left: 50px;
    margin-right: 100px;
    margin-top: 20px;
}
.img {
    width: 340px;
    height: 500px;
}
.placepage img {
    width: 320px;
    height: 185px;
    float: left;
    margin-top: 20px;
}
.shopdetail {
    width: 290px;
    height: 140px;
    float: left;
    margin: 30px;
}
.title {
    font-size: 20px;
    float: left;
}
.placedesc {
    margin-top: 40px;
    margin-bottom: 10px;
    font-size: 14px;
    float: left;
}
.placelist {
    width: 800px;
    height: 180px;
    margin: 15px;
    float: left;
}

.listborder {
    border: 1px solid #E5E5E5;
    margin-bottom: 20px;
    border-radius: 10px;
    width: 800px;
    float: left;
    margin-right: 40px;
    height: 240px;
}

.price {
    margin-top: 80px;
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