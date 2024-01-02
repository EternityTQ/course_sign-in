package com.rainng.coursesystem.service.signin;

import com.rainng.coursesystem.manager.admin.TeacherManager;
import com.rainng.coursesystem.manager.signin.SignInManager;
import com.rainng.coursesystem.manager.teacher.CourseManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("sign_service")
public class SignService extends BaseService {
    private final SignInManager signInManager;
    private final CourseManager teacherManager;
    private final TeacherManager manager;
    public SignService(SignInManager signInManager,
                       TeacherManager manager,
                       CourseManager teacherManager)
    {
        this.signInManager = signInManager;
        this.teacherManager = teacherManager;
        this.manager = manager;
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
     * @param teacherName 教师名字
     * @param courseName 课程名字
     * @param start 签到开始时间
     * @param end  签到结束时间
     * @param code 签到码
     * @return
     */
    public ResultVO signPostByTeacher(String teacherName, String courseName, Date start, Date end, Integer code){
        // 进行判断，签到请求是否合理
        Integer teacher_id = getUserId();
        // 根据id找到对应的教师名字，进行比较
        if(teacherName !=  manager.get(teacher_id).getName()){
            return failedResult("请输入正确的教师名字");
        }
        // 根据教师id找到课程列表
        Integer flag = 0; // 表示成功找到相应教师下的课程
        for (TeacherCourseItemVO itemVO:teacherManager.listTeacherCourse(teacher_id)){
            if(itemVO.getName() == courseName){
                flag = 1;
                break;
            }
        }
        if(flag != 1){return failedResult("请输入正确的课程名");}
        // 插入签到记录表
        return failedResult("还没写好");
    }
}
