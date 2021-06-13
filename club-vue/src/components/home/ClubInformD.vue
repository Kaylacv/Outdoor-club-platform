<template>
  <div class="articles-area">
    <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
      <div>
        <span style="font-size: 20px"><strong>{{article.announcetitle}}</strong></span>
        <el-divider content-position="left">{{article.announceTime}}</el-divider>
        <div class="markdown-body">
          <div v-html="article.announcecontent"></div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'ArticleDetails',
    data () {
      return {
        article: []
      }
    },
    mounted () {
      this.loadArticle()
    },
    methods: {
      loadArticle () {
        var _this = this
        this.$axios.get('/cjt/announces/query?announceId=' + this.$route.query.announceId).then(resp => {
         console.log(resp)
         if (resp && resp.status === 200) {
            _this.article = resp.data
          }
        })
      }
    }
  }
</script>

<style scoped>
  @import "../../styles/markdown.css";
</style>
