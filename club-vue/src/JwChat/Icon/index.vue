<template>
  <i :class="_class"></i>
</template>

<script>
export default {
  name: 'JwChat-icon',
  props: {
    type: {
      type: String,
      required: true
    }
  },
  computed: {
    _class () {
      return {
        [this.$style.iconfont]: true,
        [this.$style[this.type]]: true
      }
    }
  }
}
</script>

<style module>

.iconfont {
  font-family: "iconfont" !important;
  font-size: 16px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.icon-jiantou:before {
  content: "\e656";
}

.icon-jiantou_xiangzuoliangci:before {
  content: "\eb0a";
}

.icon-jiantou_xiangyouliangci:before {
  content: "\e6e7";
}

.icon-jiantou-xiangzuo:before {
  content: "\e672";
}

.icon-jiantou-xiangyou:before {
  content: "\e673";
}

.icon-look:before {
  content: "\e603";
}

.icon-zyj_unlooked:before {
  content: "\e6e9";
}

.icon-empty:before {
  content: "\e699";
}

.icon-empty1:before {
  content: "\e604";
}

.icon-gengduo:before {
  content: "\e60a";
}

.icon-all:before {
  content: "\e6ef";
}

.icon-QRcode1:before {
  content: "\e75e";
}

.icon-comments:before {
  content: "\e7b2";
}

.icon-comment-single:before {
  content: "\e601";
}

.icon-email:before {
  content: "\e602";
}

.icon-ditu:before {
  content: "\e635";
}

.icon-lishi:before {
  content: "\e64e";
}

.icon-zhangdan:before {
  content: "\e65a";
}

.icon-xiangce:before {
  content: "\e65b";
}

.icon-hongbao:before {
  content: "\e623";
}

.icon-shipin:before {
  content: "\e64f";
}

.icon-dizhi:before {
  content: "\e658";
}

.icon-wenjian:before {
  content: "\e73e";
}

.icon-xiaolian:before {
  content: "\edb8";
}
</style>