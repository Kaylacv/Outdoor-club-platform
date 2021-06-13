<template>
     <div>  
        <div class="searchactivity">
      <el-input
        placeholder="通过标题搜索..."
        prefix-icon="el-icon-search"
        size="medium"
        class="searchactivityBox"
        v-model="activitytitle"
        @keyup.enter.native="search">
      </el-input>
   </div>
   <div class="add"><el-button type="success" @click="addActivityVisible=true">发布活动</el-button></div> 
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
          prop="upTime"
          label="发布日期"
          width="200">
        </el-table-column>
         <el-table-column
          prop="actPrice"
          label="价格"
          width="100">
        </el-table-column>
        <el-table-column
          prop="checking"
          label="状态"
          width="120">
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
              @click.native.prevent="update(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
            <el-button
              @click.native.prevent="deleteActivity(scope.row.activityId)"
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

     <el-dialog
      title="修改活动"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form :model="form" style="text-align: left" ref="form">
        <el-form-item label="标题" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.announcetitle" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="内容" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.announcecontent" type="textarea" :rows="10" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="updateAnnounce">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog
      title="发布活动"
      :visible.sync="addActivityVisible"
      @close="clear">
      <el-form :model="addform" style="text-align: left" ref="form">
        <el-form-item label="标题" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addform.activityTitle" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="内容" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addform.activityCon" type="textarea" :rows="10" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="温馨提示" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addform.activityDecs" type="textarea" :rows="3" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="开始时间" :label-width="formLabelWidth" prop="title">
            <el-date-picker v-model="addform.startTime" align="right" type="date" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd"
         placeholder="选择日期" :picker-options="startTime"></el-date-picker>
        </el-form-item>
          <el-form-item label="结束时间" :label-width="formLabelWidth" prop="title">
         <el-date-picker v-model="addform.endTime" align="right" type="date" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd"
         placeholder="选择日期" :picker-options="endTime"></el-date-picker>
          </el-form-item>
           <el-form-item label="活动价" :label-width="formLabelWidth" prop="title">
               <el-input v-model="addform.actPrice"  autocomplete="off" style="width:100px;margin-right:10px"></el-input>元
          </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addActivity">确 定</el-button>
      </div>
    </el-dialog>
     </div>
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
      form: {
          announcetitle: '',
          announcecontent:''
        },
      addform:[],
        formLabelWidth: '120px',
        activitytitle:''
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
    this.$axios.get("/cjt/activities/managerGet?clubId="+localStorage.getItem("clubsId")+"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
      .then((res) => {
        console.log(res)
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
      deleteActivity (id) {
        this.$confirm('此操作将永久删除该活动, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .delete("/cjt/activities/delete?activityId=" + id).then(resp => {
              if (resp && resp.status=== 200) {
                this.getData()
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
       update(activity) {
				console.log(activity)
				this.form = activity
				this.dialogFormVisible = true
			},
      viewActivity (activityId) {
        let activityUrl = this.$router.resolve(
          {
            path: './ClubActivityD',
            query: {
              activityId: activityId
            }
          }
        )
        window.open(activityUrl.href, '_blank')
      },
       addActivity () {
        this.$confirm('确定发布新活动?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .post("/cjt/activities/insertAct?clubId="+localStorage.getItem("clubsId")
              +"&activityTitle="+this.addform.activityTitle+"&activityCon="+this.addform.activityCon
              +"&activityDecs="+this.addform.activityDecs+"&startTime="+this.addform.startTime
              +"&endTime="+this.addform.endTime+"&actPrice="+this.addform.actPrice).then(resp => {
              if (resp && resp.status === 200) {
                this.addActivityVisible = false
                this.getData()
                 this.$message({
                     type: 'success',
                   message: '发布成功'
                 })
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消发布'
          })
        })
      },
      search(keywords){
         if (keywords.keyCode==13) {
            this.searchname()
         }
      },
       searchname(){
          this.$axios.get('/cjt/activities/search?activityTitle=' + this.activitytitle
          +'&clubsId='+localStorage.getItem("clubsId"))
            .then(resp => {
               console.log(resp)
              if (resp && resp.status === 200) {
                 this.tableData = resp.data;
                 this.activitytitle=""
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
  .add-link {
    margin: 18px 0 15px 10px;
    float: left;
  }
  .add{
      float:right;
      width: 100px;
      height: 20px;
      margin-right:30px;
      margin-top:40px;
      margin-bottom:50px
  }
.searchactivity{
 width: 0px;
  }
.searchactivityBox{
    width: 300px;
    position:absolute;
    margin-top:45px
}
</style>
