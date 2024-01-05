package com.rainng.coursesystem.controller.signin;

import com.rainng.coursesystem.model.vo.request.ClassSigninDetailReqVO;
import com.rainng.coursesystem.model.vo.request.TeacherSigninPostVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.signin.SignService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacherSign")
public class TeacherSignController {
    private final SignService service;

    public TeacherSignController(SignService service){
        this.service = service;
    }

    /**
     * 通过课程id查看签到发布记录
     * @param id 教师id
     * @return
     */
    @GetMapping("/list/{id}")
    public ResultVO list(@PathVariable Integer id){
        return service.listByCourseId(id);
    }

    /**
     * 教师发布签到
     * @param value 请求包，详情见TeacherSigninPostVO
     * @return
     */
    @PostMapping
    public ResultVO sign(@RequestBody TeacherSigninPostVO value){
        return service.signPostByTeacher(value);
    }

    /**
     * 列出所有的记录表
     * @return
     */
    @GetMapping("/list")
    public ResultVO listAll(){
        return service.list();
    }

    /**
     * 根据签到记录列出签到详情
     * @param id 课程id
     * @return
     */
    @PostMapping("/detail/{id}")
    public ResultVO listDetail(@PathVariable Integer id){
        return service.listDetail(id);
    }
}
