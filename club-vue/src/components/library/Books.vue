<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <!-- <view-switch class="switch"></view-switch> -->
      <el-tooltip effect="dark" placement="right"
                  v-for="item in books.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.id">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <span>{{item.author}}</span> /
          <span>{{item.date}}</span> /
          <span>{{item.press}}</span>
        </p>
        <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>
        <el-card style="width: 240px;margin-bottom: 20px;height: 380px;float: left;margin-right: 15px" class="book"
                 bodyStyle="padding:10px" shadow="hover">
          <div class="cover">
            <img :src="item.cover" alt="封面">
          </div>
          <div class="info">
            <div class="title">
              <a href="">{{item.title}}</a>
            </div>
          </div>
          <div class="author">￥{{item.press}}</div>
          <div class="addcar"> <el-button round @click="add(item.id,item.press)">加入购物车</el-button></div>
        </el-card>
      </el-tooltip>
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="books.length">
      </el-pagination>
    </el-row>


    
  </div>
</template>

<script>
  import SearchBar from './SearchBar'
  import ViewSwitch from './ViewSwitch'

  export default {
    name: 'Books',
    components: {SearchBar, ViewSwitch},
    data () {
      return {
        dialogFormVisible: false,
        books: [],
        currentPage: 1,
        pagesize: 18,
          dialogFormVisible: false,
        rules: {
          name: [{required: true, message: '角色名不能为空', trigger: 'blur'}]
        },
        checked: true,
       loginForm: {
            username: '',
            password: '',
            name: '',
            phone: '',
            email: ''
          },
        loading: false,
        num:1
      }
    },
    mounted: function () {
      this.loadBooks()
    },
    methods: {
       clear () {
        this.roleForm = {
          num: 1,
          name: '',
          nameZh: ''
        }
      },
       handleChange(value) {
        console.log(value);
      },
      loadBooks () {
        var _this = this
        this.$axios.get('/books').then(resp => {
          if (resp && resp.data.code === 200) {
            _this.books = resp.data.result
          }
        })
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
      },
      searchResult () {
        var _this = this
        this.$axios
          .get('/search?keywords=' + this.$refs.searchBar.keywords, {
          }).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.books = resp.data.result
          }
        })
      },
       add (id,press) {
        var _this = this
        console.log(id,press)
        this.$axios.post('/cjt/cars/addCar', {
            goodId: id,
            userName: localStorage.getItem("username"),
            goodCount: 1,
            cprice: press,
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
<style scoped>

  .cover {
    width: 220px;
    height: 230px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 220px;
    height: 220px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 14px;
    text-align: left;
    margin-bottom: 10px;
  }

  .author {
    color: rgb(241, 13, 13);
    width: 102px;
    font-size: 16px;
    margin-bottom: 6px;
    text-align: left;
  }
  .addcar{
    text-align: right;
  }

  .abstract {
    display: block;
    line-height: 17px;
  }

  .el-icon-delete {
    cursor: pointer;
    float: right;
  }

  .switch {
    display: flex;
    position: absolute;
    left: 780px;
    top: 25px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #5d6266;
  }

</style>
