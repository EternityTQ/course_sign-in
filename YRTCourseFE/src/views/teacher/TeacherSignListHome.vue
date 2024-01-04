<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-edit"></i> 签到记录
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
	  <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button type="success" @click="gotoSignList(scope.row.id)">查看记录</el-button>
                        </template>
          </el-table-column>
        </el-table>
      </div>
	  
    </div>
  </div>
  
</template>

<script>
import * as api from "../../api/teacher/course";

export default {
  name: "TeacherCourse",
  data() {
    return {
      tableData: [],
	   showDialog: false,
      currentStartTime: '',
      duration: 5,
      currentCourse: { name: '' },
      teacherName: this.$store.state.status.username
    };
  },
  methods: {
    gotoSignList(courseId) {
      this.$router.push(`/teacher/signlist/${courseId}`);
    },
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    },
  },
  created() {
    this.getList();
  }
};
</script>

<style scoped></style>



