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
          label="冻结/解冻"
          width="100">
          <template slot-scope="scope">
            <el-switch
              v-model="scope.row.enabled"
              active-color="#13ce66"
              inactive-color="#ff4949"
              @change="(value) => commitStatusChange(value, scope.row)">
            </el-switch>
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
  import BulkRegistration from './BulkRegistration'
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
          this.$axios.get('/cjt/clubs/getAllList').then(resp => {
            if (resp.status === 200) {
              _this.users = resp.data
            }
            console.log(resp)
          })
        },
        commitStatusChange (value, club) {
            this.$axios.post('/cjt/clubs/status?clubsId='+club.clubsId+'&enabled='+value).then(resp => {
              if (resp && resp.status === 200) {
                if (value) {
                  this.$message('俱乐部 [' + club.clubsName + '] 已启用')
                } else {
                  this.$message('俱乐部 [' + club.clubsName + '] 已禁用')
                }
              }
            })
        },
      }
    }
</script>

<style scoped>

</style>
