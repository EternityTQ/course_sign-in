<template>
  <div class="sign-list">
    <el-table :data="signList" style="width: 100%">
      <el-table-column prop="id" label="记录ID" sortable></el-table-column>
      <el-table-column prop="courseName" label="课程名称"></el-table-column>
      <el-table-column prop="teacherName" label="教师名称"></el-table-column>
      <el-table-column prop="timeStamp" label="签到时间"></el-table-column>
      <el-table-column prop="status" label="签到状态"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'StudentSignList',
  data() {
    return {
      signList: [] // 签到记录列表
    };
  },
  mounted() {
    this.fetchSignList();
  },
  methods: {
    async fetchSignList() {
      try {
        // 假设学生ID存储在 Vuex store 中
        const studentId = this.$store.state.status.userId;
        // 替换'IP:port'与后端服务地址和端口
        const response = await axios.get(`http://124.221.54.208:8085/studentSign/list/${studentId}`);
        if (response.data.code === 0) {
          this.signList = response.data.data;
        } else {
          // 处理错误情况
          console.error('Error fetching sign list:', response.data.message);
        }
      } catch (error) {
        console.error('Error fetching sign list:', error);
      }
    }
  }
};
</script>

<style>
/* 添加所需的样式 */
.sign-list {
  padding: 20px;
}
</style>

