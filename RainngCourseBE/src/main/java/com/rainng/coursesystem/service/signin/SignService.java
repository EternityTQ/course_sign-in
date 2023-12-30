package com.rainng.coursesystem.service.signin;

import com.rainng.coursesystem.manager.signin.SignInManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("sign_service")
public class SignService extends BaseService {
    private final SignInManager manager;

    public SignService(SignInManager manager){
        this.manager = manager;
    }

    /**
     * 通过学生id查看签到记录
     * @param id 学生id
     * @return ResultVO
     */
    public ResultVO listByStuId(Integer id){
        return result(manager.listSignInRecordByStuId(id));
    }

    /**
     * 通过教师id查看签到请求记录
     * @param id 教师id
     * @return
     */
    public ResultVO listByTeacherId(Integer id){
        return failedResult("还没写完");
    }
    /**
     * 学生签到请求
     * @param signin_id 签到id
     * @param Location 位置信息
     * @param timeStamp 时间戳
     * @return
     */
    public ResultVO sign(Integer signin_id, String Location, Date timeStamp){
        return failedResult("还没写");
    }

}
