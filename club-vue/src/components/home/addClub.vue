<template>
<div class="pagecenter">
 <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="俱乐部名称" prop="clubsName" required>
    <el-input v-model="ruleForm.clubsName" placeholder="例如：跳伞俱乐部"></el-input>
  </el-form-item>
  <el-form-item label="俱乐部类型" prop="clubsKind" required>
   <el-input v-model="ruleForm.clubsKind" placeholder="例如：跳伞"></el-input>
  </el-form-item>
  <el-form-item label="俱乐部简介" prop="clubDecs" required>
    <el-input type="textarea" v-model="ruleForm.clubDecs" placeholder="例如：大家一起体验高空跳伞" ></el-input>
  </el-form-item>
  <el-form-item label="地址" prop="clubAddress" required>
    <el-input v-model="ruleForm.clubAddress"  placeholder="例如：广东省广州市天河区xx街道xx号"></el-input>
  </el-form-item>
  <el-form-item label="门面图片" prop="clubPic" required>
     <el-input v-model="ruleForm.clubPic" autocomplete="off" placeholder="图片 URL"></el-input>
     <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
      <span>只能上传jpg/png文件，且不超过500kb</span>
  </el-form-item>
  <el-form-item label="证明材料" prop="clublicense" required>
     <el-input v-model="ruleForm.clublicense" autocomplete="off" placeholder="图片 URL"></el-input>
      <span>文档中要求含有营业执照</span>
     <img-upload @onUpload="uploadImg1" ref="imgUpload1"></img-upload>
       <span>只能上传doc文件，且不超过5MB</span>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
</el-form>
</div>
</template>
<script>
 import ImgUpload from './ImgUpload'
  export default {
    name: 'addClub',
    components: {ImgUpload},
    data () {
      return {
        username : localStorage.getItem("username"),
        ruleForm: {
          clubsName:'',
          clubsKind:'',
          clubDecs:'',
          clubAddress:'',
          clubPic: '',
          clublicense:''
        },
        rules: {
          clubsName: [
            { required: true, message: '请输入俱乐部' },
            { min: 5, max: 10, message: '长度至少4个字符'}
          ],
          clubsKind: [
            { required: true, message: '请输入俱乐部类型'}
          ],
          clubDecs: [
            { type: 'date', required: true, message: '请输入简介'}
          ],
          clubAddress: [
            { type: 'date', required: true, message: '请输入俱乐部所在地'}
          ],
          clubPic: [
            { type: 'array', required: true, message: '请上传门面图片'}
          ],
          clublicense: [
            { type: 'array', required: true, message: '请上传文件' }
          ],
        },
           url: ''
      }
    },
    mounted () {
      this.getData()
    },
    methods: {
    submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      uploadImg () {
        this.ruleForm.clubPic = this.$refs.imgUpload.url
      },
      uploadImg1 () {
        this.ruleForm.clublicense = this.$refs.imgUpload1.url
      },
        handleRemove (file, fileList) {
        console.log(file, fileList)
      },
      handlePreview (file) {
        console.log(file)
      },
      handleExceed (files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
      },
      beforeRemove (file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`)
      },
      handleSuccess (response) {
        this.url = response
        // console.log(this.url)
        this.$emit('onUpload')
        this.$message.warning('上传成功')
      },
      clear () {
        this.$refs.upload.clearFiles()
      },
       onSubmit () {
        this.$axios
          .post('/cjt/clubs/addClub?clubsName='+this.ruleForm.clubsName+'&clubsKind='+this.ruleForm.clubsKind
          +'&clubDecs='+this.ruleForm.clubDecs+'&clubAddress='+this.ruleForm.clubAddress
          +'&clubPic='+this.ruleForm.clubPic+'&userName='+localStorage.getItem("username")
          +'&license='+this.ruleForm.clublicense)
          .then(resp => {
            console.log(resp)
            if (resp && resp.status === 200) {
            this.$confirm('创建俱乐部成功', '提示', {
				   	confirmButtonText: '确定',
				  	cancelButtonText: '取消',
		  			type: 'warning'
        		})
            }
        })
      },
    }
  }
</script>

<style scoped>

   .pagecenter {
    width: 500px;
    height: 800px;
    position: absolute;
    margin-left: 35%;
    margin-top: 40px;
}
 .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
