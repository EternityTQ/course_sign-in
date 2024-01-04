<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-edit"></i> 签到管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column label="课程Id" prop="id" />
          <el-table-column label="课程名" prop="name" />
          <el-table-column label="年级" prop="grade" />
          <el-table-column label="上课时间" prop="time" />
          <el-table-column label="上课地点" prop="location" />
          <!--<el-table-column label="考试时间" prop="examDate" />-->
	  <el-table-column label="签到情况">
                    <template slot-scope="{row}">
                        <el-button type="success" @click="openSigninDialog(row)">开始签到</el-button>
                        </template>
          </el-table-column>
        </el-table>
      </div>
	  
    </div>
	<el-dialog :visible.sync="showDialog">
      <div>教师姓名：{{ teacherName }}</div>
      <div>课程名：{{ currentCourse.name }}</div>
      <div>签到开始时间：{{ currentStartTime }}</div>
      <el-select v-model="duration" placeholder="请选择签到持续时间">
        <el-option label="5分钟" :value="5"></el-option>
        <el-option label="10分钟" :value="10"></el-option>
        <el-option label="15分钟" :value="15"></el-option>
      </el-select>
      <el-button @click="confirmSignin">确认</el-button>
    </el-dialog>
  </div>
  
</template>

<script>
import * as api from "../../api/teacher/course";
import axios from 'axios';

export default {
  name: "TeacherCourse",
  data() {
    return {
      tableData: [],
	   showDialog: false,
      currentStartTime: '',
      duration: 5,
      currentCourse: { name: '' },
      teacherId : this.$store.state.status.userId,
      teacherName: this.$store.state.status.username
    };
  },
  methods: {
    formatTime(date) {
    return date.getFullYear() 
           + '/' + ('0' + (date.getMonth() + 1)).slice(-2) 
           + '/' + ('0' + date.getDate()).slice(-2) 
           + ' ' + ('0' + date.getHours()).slice(-2) 
           + ':' + ('0' + date.getMinutes()).slice(-2);
  },
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    },
      openSigninDialog(row) {
      this.currentCourse = row;
      this.currentStartTime = this.formatTime(new Date());
      this.showDialog = true;
    },
    async confirmSignin() {
      const endTime = this.formatTime(new Date(new Date().getTime() + this.duration * 60000));
      try {
        const response = await axios.post('http://124.221.54.208:8085/teacherSign', {
          teacherId: this.teacherId,
          courseName: this.currentCourse.name,
          startTime: this.currentStartTime,
          endTime: endTime
        });
        this.showDialog = false;
        alert(`签到码是: ${response.data.data}`);
      } catch (error) {
        console.error('签到请求失败', error);
        alert('签到请求失败');
      }
    }
  },
  created() {
    this.getList();
  }
};
</script>

<style scoped></style>


