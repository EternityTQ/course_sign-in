package com.rainng.coursesystem.service.signin;

import com.rainng.coursesystem.manager.admin.ACourseManager;
import com.rainng.coursesystem.manager.admin.ATeacherManager;
import com.rainng.coursesystem.manager.signin.SignInManager;
import com.rainng.coursesystem.manager.teacher.TCourseManager;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.vo.request.TeacherSigninPostVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.GernerateSigninCode;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service("sign_service")
public class SignService extends BaseService {
    private final SignInManager signInManager;
    private final TCourseManager tCourseManager;
    private final ATeacherManager aTeacherManager;
    private final ACourseManager aCourseManager;
    public SignService(SignInManager signInManager,
                       ATeacherManager aTeacherManager,
                       TCourseManager tCourseManager,
                       ACourseManager aCourseManager)
    {
        this.signInManager = signInManager;
        this.tCourseManager = tCourseManager;
        this.aTeacherManager = aTeacherManager;
        this.aCourseManager = aCourseManager;
    }

    /**
     * 通过学生id查看签到记录
     * @param id 学生id
     * @return ResultVO
     */
    public ResultVO listByStuId(Integer id){
        return result(signInManager.listSignInRecordByStuId(id));
    }

    /**
     * 通过课程id查看签到请求记录
     * @param id 教师id
     * @return
     */
    public ResultVO listByCourseId(Integer id){
        return result(signInManager.listSignInRecordByCourseId(id));
    }
    /**
     * 学生签到请求
     * @param signin_id 签到id
     * @param Location 位置信息
     * @param timeStamp 时间戳
     * @return
     */
    public ResultVO signReqByStudent(Integer signin_id, String Location, Date timeStamp){
        // 进行判断，签到请求是否合理
        return failedResult("还没写");
    }

    /**
     * 教师发布签到请求
     * @param value
     * @return
     */
    public ResultVO signPostByTeacher(TeacherSigninPostVO value){

        // 根据id找到对应的教师名字
        TeacherItemVO teacher = tCourseManager.get(value.getTeacherName());
        if(teacher == null){
            return failedResult("请输入正确的教师名字");
        }
        Integer teacher_id = teacher.getId();
        Integer course_id = -1;

        // 根据教师id找到课程列表
        Integer flag = 0; // 表示成功找到相应教师下的课程
        for (TeacherCourseItemVO itemVO: tCourseManager.listTeacherCourse(teacher_id)){
            if(Objects.equals(itemVO.getName(), value.getCourseName())){
                flag = 1;
                // 课程id
                course_id = itemVO.getId();
                break;
            }
        }
        if(flag != 1){return failedResult("请输入正确的课程名");}
        // 生成签到码
        // todo 遍历签到表检查有是否重复的签到码--异步

        Integer code = GernerateSigninCode.getCode();
        // 插入签到记录表
        SigninRecordEntity entity = new SigninRecordEntity();
        if(course_id != -1)entity.setCourse_id(course_id);
        entity.setEnd(value.getEndTime());
        entity.setStart(value.getStartTime());
        entity.setSignin_code(code);
        signInManager.create(entity);
        return result("发送签到成功，签到码是"+code);
    }
}
