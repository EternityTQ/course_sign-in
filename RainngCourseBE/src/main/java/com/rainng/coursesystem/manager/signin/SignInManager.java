package com.rainng.coursesystem.manager.signin;

import com.rainng.coursesystem.dao.SigninRecordDAO;
import com.rainng.coursesystem.dao.SigninStatusDAO;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import com.rainng.coursesystem.model.vo.response.table.SigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.StudentSigninItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherSigninItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("signin_manager")
public class SignInManager {
    private final SigninRecordDAO signinRecordDAO;
    private final SigninStatusDAO signinStatusDAO;

    public SignInManager(SigninRecordDAO signinRecordDAO,SigninStatusDAO signinStatusDAO) {
        this.signinRecordDAO = signinRecordDAO;
        this.signinStatusDAO = signinStatusDAO;
    }

    public List<StudentSigninItemVO> listSignInRecordByStuId(Integer id){
        return signinStatusDAO.listSignInRecordByStuId(id);
    }
    public List<TeacherSigninItemVO> listSignInRecordByCourseId(Integer id){
        return signinRecordDAO.listSignInRecordByCourseId(id);
    }
    public Integer create(SigninRecordEntity entity){
        return signinRecordDAO.insert(entity);
    }
    public int create(SigninStatusEntity entity) {
        return signinStatusDAO.insert(entity);
    }
    public List<SigninItemVO> list(){return signinRecordDAO.list();}

    public TeacherSigninItemVO selectByCode(Integer code){return signinRecordDAO.selectByCode(code);}


}
