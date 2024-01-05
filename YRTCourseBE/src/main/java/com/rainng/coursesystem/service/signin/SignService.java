package com.rainng.coursesystem.service.signin;

import com.rainng.coursesystem.manager.admin.ATeacherManager;
import com.rainng.coursesystem.manager.signin.SignInManager;
import com.rainng.coursesystem.manager.student.SCourseManager;
import com.rainng.coursesystem.manager.teacher.TCourseManager;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import com.rainng.coursesystem.model.entity.TeacherEntity;
import com.rainng.coursesystem.model.vo.request.ClassSigninDetailReqVO;
import com.rainng.coursesystem.model.vo.request.StudentSignRequestVO;
import com.rainng.coursesystem.model.vo.request.TeacherSigninPostVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.StudentStatusItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherSigninItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.GernerateSigninCode;
import com.rainng.coursesystem.util.TimeDifference;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("sign_service")
public class SignService extends BaseService {
    private final SignInManager signInManager;
    private final TCourseManager tCourseManager;
    private final ATeacherManager aTeacherManager;
    private final SCourseManager  sCourseManager;
    public SignService(SignInManager signInManager,
                       TCourseManager tCourseManager,
                       ATeacherManager aTeacherManager,
                       SCourseManager sCourseManager)
    {
        this.signInManager = signInManager;
        this.tCourseManager = tCourseManager;
        this.aTeacherManager = aTeacherManager;
        this.sCourseManager = sCourseManager;
    }
    public ResultVO list(){return result(signInManager.list());}

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
     * @param value
     * @return
     */
    public ResultVO signReqByStudent(StudentSignRequestVO value){
        // 进行判断，签到请求是否合理
        // 根据签到码查找表
        TeacherSigninItemVO signinItem =  signInManager.selectByCode(value.getCode());
        if (signinItem == null){
            createEntity(value,SigninStatusEntity.SigninStatus.ERROR);
            return  failedResult("签到码错误");
        }
        if(!( value.getCurTime().isAfter(signinItem.getReleaseTime()) && value.getCurTime().isBefore(signinItem.getDeadline()))){
            createEntity(value,SigninStatusEntity.SigninStatus.FAILED);
            return failedResult("不在签到氛围内");
        }
        // 签到成功
        createEntity(value,SigninStatusEntity.SigninStatus.SUCCESS);
        return result("签到成功");
    }

    /**
     * 这里是为了代码看起来好看一点
     */
    public void createEntity(StudentSignRequestVO value, SigninStatusEntity.SigninStatus status){
        SigninStatusEntity entity = new SigninStatusEntity();
        entity.setStudent_id(value.getId());
        entity.setTimestamp(value.getCurTime());
        entity.setStatus(status);
        entity.setSignin_code(value.getCode());
        signInManager.create(entity);
    }
    /**
     * 教师发布签到请求
     * @param value
     * @return
     */
    public ResultVO signPostByTeacher(TeacherSigninPostVO value){

        // 根据id找到对应的teacher
        TeacherEntity teacher = aTeacherManager.get(value.getTeacherId());
        if(teacher == null){
            return failedResult("请输入正确的教师id");
        }
        Integer teacher_id = value.getTeacherId();
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
        if(!TimeDifference.isDirect(value.getStartTime())){
            return failedResult("请输入合法的时间");
        }
        if(value.getStartTime().compareTo(value.getEndTime()) >= 0){
            return failedResult("请输入正确的时间");
        }
        if (Duration.between(value.getStartTime(),value.getEndTime()).toMinutes() >= 35){
            return failedResult("时间间隔不超过35min");
        }
        // 生成签到码
        Integer code = GernerateSigninCode.getCode();

        // todo 遍历签到表检查有是否重复的签到码--异步?
//        List<SigninItemVO> signinItemVOList = signInManager.list();
//
//        for(SigninItemVO it:signinItemVOList){
//            if(it.getCode() == code){
//                code = GernerateSigninCode.getCode();
//            }
//        }


        // 插入签到记录表
        SigninRecordEntity entity = new SigninRecordEntity();
        if(course_id != -1)entity.setCourse_id(course_id);
        entity.setEnd(value.getEndTime());
        entity.setStart(value.getStartTime());
        entity.setSignin_code(code);
        signInManager.create(entity);
        return result("发送签到成功，签到码是"+code);
    }

    /**
     * 查看签到记录详情
     * @param courseId 课程id
     * @return
     */
    public ResultVO listDetail(Integer courseId) {
        // 通过课程id在班级找到相应的学生列表
        List<Integer> StuIdList = sCourseManager.listCourseStudent(courseId);
//        return result(StuIdList);
        List<StudentStatusItemVO> res = new ArrayList<>();
        for(Integer stuId:StuIdList){
            List<StudentStatusItemVO> tmp = signInManager.selectByStuId(stuId);
            for(StudentStatusItemVO it:tmp){
                res.add(it);
            }
        }
        return result(res);

    }
}
