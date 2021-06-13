<template>
  <div class="articles-area">
    <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
      <div v-for="activity in activity" :key="activity">
         <div> <span style="font-size: 20px"><strong>{{activity.activityTitle}} </strong></span> </div>
         <el-divider content-position="left">开始时间：{{activity.startTime}} &emsp;结束时间：{{activity.endTime}}</el-divider>
         <div class="markdown-body">
          <div v-html="activity.activityCon"></div>
         </div>
          <el-divider content-position="right">活动价：{{activity.actPrice}} 元 &emsp; 发布时间：{{activity.upTime}}</el-divider>
         <div class="markdown-body">
          <div style="color: rgb(255 141 0);font-size:14px">温馨提示：{{activity.activityDecs}}</div></div>
        </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'ActivityDetails',
    data () {
      return {
        activity: []
      }
    },
    mounted () {
      this.loadArticle()
    },
    methods: {
      loadArticle () {
        this.$axios.get('/cjt/activities/query?activityId=' + this.$route.query.activityId).then(resp => {
         console.log(resp)
         if (resp && resp.status === 200) {
            this.activity = resp.data
          }
        })
      }
    }
  }
</script>

<style scoped>
  @import "../../styles/markdown.css";
</style>
