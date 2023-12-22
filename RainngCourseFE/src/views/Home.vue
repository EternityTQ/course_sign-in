<template>
  <div>
    <h2>欢迎使用课程管理系统</h2>
    主页可自行改改，懒得弄加个图片就行


  </div>
</template>

<script>
// import * as api from "../api/news";

export default {
  name: "Home",
  data() {
    return {
      tableData: []
    };
  },
  // methods: {
  //   query() {
  //     api.get().then(res => {
  //       this.tableData = res;
  //     });
  //   },
  //   openNews(url) {
  //     window.open(url, "_blank");
  //   }
  // },
  created() {
    this.query();
  }
};
</script>

<style scoped>
.home-wrap {
  height: 100%;
  width: 100%;
}

.main-wrap {
  margin-top: 10px;
  height: 100%;
  width: 100%;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.home-container {
  height: 100%;
  width: 90%;
  margin: auto;
}

.home-aside {
  height: 100%;
}

.aside-container {
  width: 90%;
  margin-left: auto;
  margin-right: auto;
  height: 200px;
  margin-top: 20px;
}

.aside-img {
  width: 100%;
}

.aside-title {
  color: #333;
  font-size: 18px;
}

.aside-content {
  font-size: 12px;
  color: #999;
}
</style>
