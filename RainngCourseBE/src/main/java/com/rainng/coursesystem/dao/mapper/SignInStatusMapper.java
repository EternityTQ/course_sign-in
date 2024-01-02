package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import com.rainng.coursesystem.model.vo.response.table.StudentSigninItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignInStatusMapper extends BaseMapper<SigninStatusEntity> {
    List<StudentSigninItemVO> listSignInRecordByStuId(Integer id);
}
