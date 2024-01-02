package com.rainng.coursesystem.manager.teacher;

import com.rainng.coursesystem.dao.TeacherDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_CourseManager")
public class TCourseManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public TCourseManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TeacherCourseItemVO> listTeacherCourse(Integer teacherId) {
        return teacherDAO.listTeacherCourse(teacherId);
    }
    public TeacherItemVO get(String name){return teacherDAO.get(name);}
}
