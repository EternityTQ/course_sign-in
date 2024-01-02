package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.vo.response.table.StudentSigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherSigninItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignInMapper extends BaseMapper<SigninRecordEntity> {
    // todo 补充

    List<StudentSigninItemVO> listSignInRecordByStuId(Integer id);
    List<TeacherSigninItemVO> listSignInRecordByCourseId(Integer id);
 }
