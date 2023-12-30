package com.rainng.coursesystem.service.signin;

import com.rainng.coursesystem.manager.signin.SignInManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service("sign_service")
public class SignService extends BaseService {
    private final SignInManager manager;

    public SignService(SignInManager manager){
        this.manager = manager;
    }
    /*
    通过学生id查看签到记录
     */
    public ResultVO list(Integer stu_id){
//        Integer stu_id = getUserId();
        return result(manager.listSignInRecordByStuId(stu_id));
    }

}
