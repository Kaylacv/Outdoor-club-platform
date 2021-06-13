<template>
  <div class="login-container" style="background:#95a5b4 url('https://www.youxiake.com/old_yxkweb/Public/assets/img/reglogin/index_bg.png') center top no-repeat;">
   <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left" label-width="0px"
      class="card-box login-form">
      <h3 class="title">用户账号登录</h3>
      <el-form-item prop="username">
          <span class="svg-container el-icon-user">
          <svg-icon icon-class="user" />
        </span>
        <el-input name="username" type="text" v-model="loginForm.username" autoComplete="on" placeholder="username" />
      </el-form-item>
      <el-form-item prop="password">
         <span class="svg-container el-icon-s-grid">
          <svg-icon icon-class="password"></svg-icon>
        </span>
        <el-input name="password" :type="pwdType" @keyup.enter.native="handleLogin" v-model="loginForm.password" autoComplete="on"
          placeholder="password"></el-input>
          <span class="show-pwd" @click="showPwd"><svg-icon icon-class="eye" /></span>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" :loading="loading" @click="handleLogin">
          登录
        </el-button>
      </el-form-item>
   <div>
   还没有账号？
  <el-link icon="el-icon-mobile-phone"><router-link to="/loginSMg">去注册</router-link></el-link>
</div>
      <div>
  <el-link icon="el-icon-mobile-phone"><router-link to="/loginSMg2">用户短信登录</router-link></el-link>

    <el-link icon="el-icon-s-grid" style="float:right"><router-link to="/">管理员账号登录</router-link></el-link>
</div>

    </el-form>

    
  <section class="main" role="main">
    <div class="footer_container">
        <div class="footer_list footer_list_1">
            <div>户外俱乐部</div>
            <div>户外爱好者平台</div>
        </div>
        <div class="footer_list footer_list_2">
            <div class="footer_list_img"></div>
            <div class="footer_list_box">
                <div>为挖掘<b>小众美景</b></div>
                <div><b>探索</b>新奇玩法</div>
                <div>呕心沥血<b>10余年</b></div>
                <div>今天，很高兴认识你</div>
            </div>
        </div>
        <div class="footer_list footer_list_3">
            <div class="footer_list_img"></div>
            <div class="footer_list_box">
                <div>想获得难忘的俱乐部体验</div>
                <div><b>快加入我们吧!</b></div>
                <div>你会获得</div>
                <div><b>志同道合</b>的朋友</div>
            </div>
        </div>
        <div class="footer_list footer_list_4">
            <div class="footer_list_img"></div>
            <div class="footer_list_box">
                <div>更有N重<b>惊喜福利</b></div>
                <div>新用户专享<b>388元代金券</b></div>
                <div>不定期<b>免费</b>获奖礼品</div>
            </div>
        </div>
    </div>
</section>
<footer class="footer">
    <div class="container">
        <div class="sitemap clearfix">
        </div>
        <div class="copyright">
            <span>&nbsp;&nbsp;</span>
            <p class="text"><span>© 2021 户外俱乐部综合平台&nbsp;&nbsp;用户账号登录界面</span></p>
        </div>
    </div>
</footer>
  </div>
</template>

<script>
export default {
  name: 'login2',
  data() {
    return {
      loginForm: {
        username: '李四',
        password: '123'
      },
      loading: false,
      pwdType: 'password'
    }
  },
  methods: {
    showPwd() {
      if (this.pwdType === 'password') {
        this.pwdType = ''
      } else {
        this.pwdType = 'password'
      }
    },
    handleLogin() {
      console.log(this.loginForm.username)
      console.log(this.loginForm.password)
       this.$axios
        .post(
          '/cjt/users/queryId?userName=' +
        this.loginForm.username 
        )
        .then((re) => {
            console.log(re.data)
            localStorage.setItem("userId", re.data);
      this.$axios
        .post(
          '/cjt/users/login?userName=' +
        this.loginForm.username +
        '&userPassword=' +
        this.loginForm.password
        )
        .then((res) => {
          // eslint-disable-next-line eqeqeq
          if (res.data.msg == '登录成功') {
            console.log(res)
             localStorage.setItem("username", this.loginForm.username);
            //  this.$router.push("/course");
            this.$router.push({
              name: 'Library'
              // params:{
              //   username: this.loginForm.username
              // }
            })
          } else {
            this.$message({
              showClose: true,
              message: res.data.msg,
              // eslint-disable-next-line no-undef
              type: error
            })
          }
        })
        })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#eee;

  .login-container {
    position: fixed;
    height: 100%;
    width:100%;
    background-color: $bg;
    input:-webkit-autofill {
      -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
      -webkit-text-fill-color: #fff !important;
    }
    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: #000000;
      height: 47px;
    }
    .el-input {
      display: inline-block;
      height: 47px;
      width: 60%;
    }
    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: #000000;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
      &_login {
        font-size: 20px;
      }
    }
    .title {
      font-size: 26px;
      font-weight: 400;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
    .login-form {
      width: 400px;
      padding: 35px 35px 15px 35px;
      float:right;
      margin-right: 120px;
      margin-top: 120px;
      background:rgba(0, 0, 0, 0.4);
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(253, 253, 253, 0.3);
      border-radius: 5px;
      color: #454545;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
      user-select:none;
    }
    .thirdparty-button{
      position: absolute;
      right: 35px;
      bottom: 28px;
    }
      a {
    color: #898989;
    font-size: 12px;
    text-decoration: none;
}
.main {
  margin-top:600px;
    height: 150px;
    background-color: #f9f9fa;
}
.footer_container {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    margin: 0 auto;
    width: 1000px;
}
.footer_list {
    margin-top: 20px;
    display: flex;
    align-items: flex-start;
}
.footer_list_1 {
    flex-direction: column;
}
.footer_list_1 div:first-child {
    font-size: 20px;
}
.footer_list_1 div {
    line-height: 40px;
    color: #333;
    font-size: 16px;
    font-weight: bold;
    font-family: "MicrosoftYaqiHei-Bold";
}
.footer_list_1 div:last-child {
    font-size: 20px;
}
.footer_list .footer_list_box {
    line-height: 28px;
    color: #666;
    font-family: "MicrosoftYaHei";
    font-size: 12px;
}
.footer_list .footer_list_box b {
    color: #333;
    font-size: 14px;
}
.footer {
    background:  #ededed;
    height: 70px;
    text-align: center;
}
.footer .container {
    height: 100%;
    background: 850px 20px no-repeat;
}
.copyright {
    line-height: 10px;
    font-size: 14px;
    color: #b0b0b0;
}
  }
</style>