package com.rainng.coursesystem.manager.signin;

import com.rainng.coursesystem.dao.SigninDAO;
import com.rainng.coursesystem.dao.mapper.SignInMapper;
import com.rainng.coursesystem.model.vo.response.table.SigninItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("signin_manager")
public class SignInManager {
    private final SigninDAO signinDAO;

    public SignInManager(SigninDAO signinDAO) {
        this.signinDAO = signinDAO;
    }

    public List<SigninItemVO> listSignInRecordByStuId(){
        return signinDAO.listSignInRecordByStuId();
    }

}
