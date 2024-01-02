package com.rainng.coursesystem.dao;

import com.rainng.coursesystem.dao.mapper.SignInRecordMapper;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.vo.response.table.SigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherSigninItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SigninRecordDAO {
    private final SignInRecordMapper mapper;


    public SigninRecordDAO(SignInRecordMapper signInRecordMapper) {
        this.mapper = signInRecordMapper;
    }

    public int insert(SigninRecordEntity entity){return mapper.insert(entity);};

    public int delete(Integer id){return mapper.deleteById(id);};

    public int update(SigninRecordEntity entity){return mapper.updateById(entity);};


    public List<TeacherSigninItemVO> listSignInRecordByCourseId(Integer id){return mapper.listSignInRecordByCourseId(id);}

    public TeacherSigninItemVO selectByCode(Integer code){return mapper.selectByCode(code);}

    public List<SigninItemVO> list(){return  mapper.list();}


}
