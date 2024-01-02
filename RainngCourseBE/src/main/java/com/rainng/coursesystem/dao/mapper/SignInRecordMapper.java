package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import com.rainng.coursesystem.model.vo.response.table.SigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.StudentSigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherSigninItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignInRecordMapper extends BaseMapper<SigninRecordEntity> {


    List<TeacherSigninItemVO> listSignInRecordByCourseId(Integer id);
    List<SigninItemVO> list();

    TeacherSigninItemVO selectByCode(Integer code);

}
