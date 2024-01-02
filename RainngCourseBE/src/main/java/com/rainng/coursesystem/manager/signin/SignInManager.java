package com.rainng.coursesystem.manager.signin;

import com.rainng.coursesystem.dao.SigninDAO;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.vo.response.table.StudentSigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherSigninItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("signin_manager")
public class SignInManager {
    private final SigninDAO signinDAO;

    public SignInManager(SigninDAO signinDAO) {
        this.signinDAO = signinDAO;
    }

    public List<StudentSigninItemVO> listSignInRecordByStuId(Integer id){
        return signinDAO.listSignInRecordByStuId(id);
    }
    public List<TeacherSigninItemVO> listSignInRecordByCourseId(Integer id){
        return signinDAO.listSignInRecordByCourseId(id);
    }
    public Integer create(SigninRecordEntity entity){
        return signinDAO.insert(entity);
    }

}
