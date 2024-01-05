package com.rainng.coursesystem.dao;

import com.rainng.coursesystem.dao.mapper.SignInRecordMapper;
import com.rainng.coursesystem.dao.mapper.SignInStatusMapper;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import com.rainng.coursesystem.model.vo.response.table.StudentSigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.StudentStatusItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SigninStatusDAO {
    private final SignInStatusMapper mapper;

    public SigninStatusDAO(SignInStatusMapper mapper){
        this.mapper = mapper;
    }
    public List<StudentSigninItemVO> listSignInRecordByStuId(Integer id){
        return mapper.listSignInRecordByStuId(id);
    }

    public int insert(SigninStatusEntity entity) {
        return mapper.insert(entity);
    }

    public List<StudentStatusItemVO> selectByStuId(Integer studentId){return mapper.selectByStuId(studentId);}
}
