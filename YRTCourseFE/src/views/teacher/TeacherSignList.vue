<template>
  <div class="sign-list">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-table"></i> 签到记录
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
   <div class="container">
     <div class="table"> 
   <el-table :data="signList" stripe>
      <el-table-column prop="id" label="记录ID"></el-table-column>
      <el-table-column prop="courseName" label="课程名称"></el-table-column>
      <el-table-column prop="location" label="地点"></el-table-column>
      <el-table-column prop="releaseTime" label="发布时间"></el-table-column>
      <el-table-column prop="code" label="签到码"></el-table-column> 
   </el-table>
     </div>
  </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'TeacherSignList',
  data() {
    return {
      signList: [] // 签到记录列表
    };
  },
  mounted() {
    this.fetchSignList();
  },
  methods: {
    async fetchSignList(){
  try {
    const courseID = this.$route.params.CourseID;
    const response = await axios.get(`http://124.221.54.208:8085/teacherSign/list/${courseID}`);
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
</style>

