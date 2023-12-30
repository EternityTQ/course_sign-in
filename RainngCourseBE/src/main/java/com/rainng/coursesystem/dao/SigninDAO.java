package com.rainng.coursesystem.dao;

import com.rainng.coursesystem.dao.mapper.SignInMapper;
import com.rainng.coursesystem.model.entity.SigninEntity;
import com.rainng.coursesystem.model.vo.response.table.SigninItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SigninDAO {
    private final SignInMapper mapper;


    public SigninDAO(SignInMapper signInMapper) {
        this.mapper = signInMapper;
    }

    public int insert(SigninEntity entity){return mapper.insert(entity);};

    public int delete(Integer id){return mapper.deleteById(id);};

    public int update(SigninEntity entity){return mapper.updateById(entity);};

    public List<SigninItemVO> listSignInRecordByStuId(Integer id){
        return mapper.listSignInRecordByStuId(id);
    }


}
