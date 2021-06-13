<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>俱乐部管理</el-breadcrumb-item>
        <el-breadcrumb-item>俱乐部信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>

    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="users"
        stripe
        :default-sort = "{prop: 'id', order: 'ascending'}"
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
           <span>{{ props.row.clubDecs }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
        <el-table-column
          prop="clubsId"
          label="ID"
          sortable
          width="100">
        </el-table-column>
        <el-table-column
          prop="clubsName"
          label="俱乐部类型"
          fit>
        </el-table-column>
          <el-table-column label="照片" width="150" prop="clubPic" >
         <template v-slot={row}>
            <img style="width:80px;height:80px;border:none;" :src="row.clubPic">
         </template>
    </el-table-column>
        <el-table-column
          prop="clubsKind"
          label="类型"
          fit>
        </el-table-column>
        <el-table-column
          prop="clubTime"
          label="开创时间"
          fit>
        </el-table-column>
        <el-table-column
          prop="clubAddress"
          label="地址"
          show-overflow-tooltip
          fit>
        </el-table-column>
         <el-table-column
          prop="clubpass"
          label="审核结果"
          show-overflow-tooltip
          fit>
        </el-table-column>
        <el-table-column
          label="操作"
          fit>
              <template slot-scope="scope">
            <el-button
              @click="view(scope.row.license)"
              type="text"
              size="small">
              下载
            </el-button>
            <el-button
              @click.native.prevent="update(scope.row.clubsId)"
              type="text"
              size="small">
              通过
            </el-button>
            <el-button
              @click.native.prevent="update1(scope.row.clubsId)"
              type="text"
              size="small">
              未通过
            </el-button>
           </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 20px 0;float: left">
        <el-button>取消选择</el-button>
        <el-button>批量删除</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
  import BulkRegistration from '../user/BulkRegistration'
    export default {
      name: 'club',
      components: {BulkRegistration},
      data () {
          return {
            users: [],
            roles: [],
            dialogFormVisible: false,
            selectedUser: [],
            selectedRolesIds: []
          }
      },
      mounted () {
        this.listUsers()
        this.listRoles()
      },
      computed: {
        tableHeight () {
          return window.innerHeight - 320
        }
      },
      methods: {
        listUsers () {
          var _this = this
          this.$axios.get('/cjt/clubs/alllist').then(resp => {
            if (resp.status === 200) {
              _this.users = resp.data
            }
            console.log(resp)
          })
        },
      update:function(id){
      this.$axios.get("/cjt/clubs/update?clubsId="+id+"&clubpass="+"通过")
      .then((res) => {
        console.log(res);
        this.tableData = res.data;
        this.total = res.data.total;
        this.listUsers()
         this.$message({
            type: 'success',
            message: '已设置通过'
          })
      });
    },
     update1:function(id){
      this.$axios.get("/cjt/clubs/update?clubsId="+id+"&clubpass="+"未通过")
      .then((res) => {
        console.log(res);
        this.tableData = res.data;
        this.total = res.data.total;
        this.listUsers()
         this.$message({
            type: 'info',
            message: '已设置未通过'
          })
      });
    },
    view:function(license){
          window.location.href = license
    }
      }
    }
</script>

<style scoped>

</style>
