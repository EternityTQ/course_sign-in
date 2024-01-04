<template>
  <div class="container">
    <div class="time">当前时间：{{ currentTime }}</div>
    <input class="sign-code-input" v-model="signCode" placeholder="请输入签到码" />
    <button class="sign-in" @click="signIn">签到</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'SignInPage',
  data() {
    return {
      currentTime: new Date().toLocaleTimeString(), // 当前时间
      signCode: '' // 签到码
    };
  },
  computed: {
    studentId() {
      return this.$store.state.status.userId; // 从 Vuex store 获取学生ID
    }
  },
  methods: {
    formatCurrentTime() {
      let now = new Date();
      let year = now.getFullYear();
      let month = now.getMonth() + 1;
      let day = now.getDate();
      let hour = now.getHours();
      let minute = now.getMinutes();

      // 格式化为两位数
      month = month < 10 ? '0' + month : month;
      day = day < 10 ? '0' + day : day;
      hour = hour < 10 ? '0' + hour : hour;
      minute = minute < 10 ? '0' + minute : minute;

      return `${year}/${month}/${day} ${hour}:${minute}`;
    },
    updateTime() {
      this.currentTime = new Date().toLocaleTimeString(); // 更新当前时间
    },
    async signIn() {
      if (!this.studentId) {
        alert('用户未登录');
        return;
      }
      if (!this.signCode) {
        alert('请输入签到码');
        return;
      }
      try {
	const formattedTime = this.formatCurrentTime(new Date());
        const response = await axios.post('http://124.221.54.208:8085/studentSign', {
          id: this.studentId, // 使用从 Vuex 获取的学生ID
          curTime: formattedTime,
          code: this.signCode
        });
        alert(response.data.message); // 显示返回消息
      } catch (error) {
        console.error('签到失败', error);
        alert('签到失败');
      }
    }
  },
  mounted() {
    this.updateTime();
    setInterval(this.updateTime, 1000); // 每秒更新时间
  },
};
</script>


<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  font-family: 'Arial', sans-serif; /* 设置字体 */
}

.time, .course {
  font-size: 2rem; /* 设置较大的字体大小 */
  margin: 1em 0; /* 设置适当的间距 */
}

.sign-in {
  padding: 2em 2em; /* 增大按钮的内边距 */
  font-size: 2rem; /* 增大按钮文字的大小 */
  border: none;
  border-radius: 50%; /* 设为圆形按钮 */
  background-color: #007bff; /* 使用更亮的蓝色 */
  color: white;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.3s; /* 添加颜色和变换的过渡效果 */
  outline: none;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
  width: 150px; /* 设置固定宽度 */
  height: 150px; /* 设置固定高度 */
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.sign-in:hover {
  background-color: #0056b3; /* 鼠标悬停时改变按钮颜色 */
  transform: scale(1.05); /* 鼠标悬停时使按钮略微放大 */
}

.sign-in:active {
  background-color: #004085; /* 鼠标点击时改变按钮颜色 */
  transform: scale(0.95); /* 鼠标点击时使按钮略微缩小 */
}

.sign-code-input {
  width: 300px; /* 调整宽度 */
  height: 40px; /* 调整高度 */
  padding: 5px; /* 内边距 */
  font-size: 18px; /* 字体大小 */
  border: 1px solid #ccc; /* 边框样式 */
  border-radius: 5px; /* 边框圆角 */
  margin-bottom: 20px; /* 增加下边距 */
}
</style>


