<template>
   <div>
      <div class="searchplace">
      <el-input
        placeholder="通过标题搜索..."
        prefix-icon="el-icon-search"
        size="medium"
        class="searchplaceBox"
        v-model="placename"
        @keyup.enter.native="search">
      </el-input>
   </div>
   <div class="add"><el-button type="success" @click="addFormVisible=true">添加场地</el-button></div> 
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
         <el-form-item style="width:100%">
            <img style="width:300px;height:180px;border:none;" :src="props.row.placePic">
         </el-form-item>
        <div><span>{{ props.row.placeDecs }}</span></div> 
         <el-form-item>    
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          prop="placeName"
          label="场地名称"
          fit>
        </el-table-column>
        <el-table-column
          prop="placePrice"
          label="价格"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="180">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="update(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
            <el-button
              @click.native.prevent="deletePlace(scope.row.placeId)"
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
      title="修改场地"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form :model="form" style="text-align: left" ref="form">
        <el-form-item label="场地名称" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.placeName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图片" :label-width="formLabelWidth" prop="placePic">
          <el-input v-model="form.placePic" autocomplete="off" placeholder="图片 URL"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>
        <el-form-item label="场地简介" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.placeDecs" type="textarea" :rows="2" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.placePrice" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="updateplace">确 定</el-button>
      </div>
    </el-dialog>

       <el-dialog
      title="添加场地"
      :visible.sync="addFormVisible"
      @close="clear">
      <el-form :model="addInform" style="text-align: left" ref="addInform">
        <el-form-item label="标题" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addInform.placeName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图片" :label-width="formLabelWidth" prop="placePic">
          <el-input v-model="addInform.placePic" autocomplete="off" placeholder="图片 URL"></el-input>
          <img-upload @onUpload="uploadImg1" ref="imgUpload1"></img-upload>
        </el-form-item>
        <el-form-item label="内容" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addInform.placeDecs" type="textarea" :rows="2" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth" prop="title">
          <el-input v-model="addInform.placePrice" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addPlace">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
import ImgUpload from './ImgUpload'
  export default {
    name: 'Articles',
    components: {ImgUpload},
    data () {
      return {
        clubsId:  localStorage.getItem("clubsId"),
        dialogFormVisible:false,
        addFormVisible:false,
        articles: [],
        total:'',
        params: {
        page: 1,
        size: 7,
      },
      addInform:{
          placeName: '',
          placeDecs:'',
          placePic:''
      },
       form: {
          placeName: '',
          placeDecs:''
        },
        formLabelWidth: '120px',
        placename:''
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
     deletePlace (id) {
        this.$confirm('确定删除该场地?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .delete('/cjt/places/delete?placeId=' + id).then(resp => {
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
       update(place) {
				console.log(place)
				this.form = place
				this.dialogFormVisible = true
			},
        updateplace(){
          this.$confirm('确定修改该场地?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .delete('/cjt/places/update?placeId='+this.form.placeId
              +'&placeName=' + this.form.placeName
              +'&placePic='+this.form.placePic
              +"&placeDecs="+this.form.placeDecs
              +'&placePrice='+this.form.placePrice).then(resp => {
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
      addPlace(){
         this.$confirm('确定添加该场地?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .delete('/cjt/places/insert?placeName=' + this.addInform.placeName
              +'&placePic='+this.addInform.placePic
              +"&placeDecs="+this.addInform.placeDecs
              +'&placePrice='+this.addInform.placePrice
              +'&clubId='+localStorage.getItem("clubsId")).then(resp => {
             console.log(resp)
              if (resp && resp.status === 200) {
                this.getData()
                 this.$message({
                 type: 'success',
                  message: '添加成功'
               })
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消添加'
          })
        })
      },
       uploadImg () {
        this.form.placePic = this.$refs.imgUpload.url
      },
       uploadImg1 () {
        this.addInform.placePic = this.$refs.imgUpload1.url
      },
       search(keywords){
         if (keywords.keyCode==13) {
            this.searchname()
         }
      },
       searchname(){
          this.$axios.get('/cjt/places/seach?placeName=' + this.placename+'&clubsId='+localStorage.getItem("clubsId"))
            .then(resp => {
               console.log(resp)
              if (resp && resp.status === 200) {
                 this.tableData = resp.data;
                 this.placename=""
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
 .add{
      float:right;
      width: 100px;
      height: 20px;
      margin-right:30px;
      margin-top:40px;
      margin-bottom:50px
  }
.searchplace{
 width: 0px;
  }
.searchplaceBox{
    width: 300px;
    position:absolute;
    margin-top:45px
}
</style>
