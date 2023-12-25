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
    public ResultVO list(){
        Integer id = getUserId();
        return result(manager.listSignInRecordByStuId(id));
    }

}
