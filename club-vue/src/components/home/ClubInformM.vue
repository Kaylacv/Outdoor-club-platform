<template>
  <div>
   <div class="searchinform">
      <el-input
        placeholder="通过标题搜索..."
        prefix-icon="el-icon-search"
        size="medium"
        class="searchinformBox"
        v-model="announcetitle"
        @keyup.enter.native="search">
      </el-input>
   </div>
   <div class="add">
     <el-button type="success" @click="addFormVisible=true">添加公告</el-button></div> 
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
        <el-table-column
          prop="announcetitle"
          label="标题"
          fit>
        </el-table-column>
        <el-table-column
          prop="announceTime"
          label="发布日期"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="viewInform(scope.row.announceId)"
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
              @click.native.prevent="deleteInform(scope.row.announceId)"
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
          @current-change="handleCurrentChange"
          :page-size="pageSize"
          :total="total">
        </el-pagination>
      </div>
    </el-card>

     <el-dialog
      title="修改公告"
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
      title="添加公告"
      :visible.sync="addFormVisible"
      @close="clear">
      <el-form :model="addInform" style="text-align: left" ref="addInform">
        <el-form-item label="标题" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addInform.announcetitle" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="内容" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addInform.announcecontent" type="textarea" :rows="10" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addAnnounce">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: 'ArticleManagement',
    data () {
      return {
        dialogFormVisible: false,
        addFormVisible:false,
        clubsId:  localStorage.getItem("clubsId"),
        articles: [],
       total:'',
      params: {
        page: 1,
        size: 7,
      },
      addInform:{
         announcetitle: '',
         announcecontent:''
      },
      form: {
          announcetitle: '',
          announcecontent:''
        },
        formLabelWidth: '120px',
        announcetitle:''
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
    this.$axios.get("/cjt/announces/clubpage?clubsId="+localStorage.getItem("clubsId")
    +"&pageCode=" + this.params.page + "&pageSize=" + this.params.size)
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
       viewInform (announceId) {
        let informUrl = this.$router.resolve(
          {
            path: './ClubInformD',
            query: {
              announceId: announceId
            }
          }
        )
        window.open(informUrl.href, '_blank')
      },
      deleteInform (id) {
        this.$confirm('确定删除该公告?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .delete('/cjt/announces/delete?announceId=' + id).then(resp => {
             console.log(resp)
              if (resp && resp.status === 200) {
                this.getData()
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
      },
      update(announce) {
				console.log(announce)
				this.form = announce
				this.dialogFormVisible = true
			},
      updateAnnounce(){
          this.$confirm('确定修改该公告?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios.delete('/cjt/announces/update?announceId=' + this.form.announceId
              +'&announcetitle='+this.form.announcetitle
              +"&announcecontent="+this.form.announcecontent).then(resp => {
              console.log(resp)
              if (resp && resp.status === 200) {
                this.getData()
                 this.$message({
                 type: 'success',
                  message: '修改成功'
               })
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消修改'
          })
        })
      },
      addAnnounce(){
      this.$confirm('确定添加公告?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios.delete('/cjt/announces/clubInsert?announcetitle='+this.addInform.announcetitle
              +"&announcecontent="+this.addInform.announcecontent+
              "&clubId="+localStorage.getItem("clubsId")).then(resp => {
              console.log(resp)
             	this.addFormVisible = false
              if (resp && resp.status === 200) {
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
            this.searchtitle()
         }
      },
      searchtitle(){
          this.$axios.get('/cjt/announces/queryTitle?announcetitle=' + this.announcetitle+'&clubsId='+localStorage.getItem("clubsId"))
            .then(resp => {
               console.log(resp)
              if (resp && resp.status === 200) {
                 this.tableData = resp.data;
                 this.announcetitle=""
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
  .searchinform{
    width: 0px;
  }
  .searchinformBox{
    width: 300px;
    position:absolute;
    margin-top:45px
  }
</style>
