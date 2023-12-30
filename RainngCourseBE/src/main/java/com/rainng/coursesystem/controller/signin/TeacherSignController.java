package com.rainng.coursesystem.controller.signin;

import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.signin.SignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacherSign")
public class TeacherSignController {
    private final SignService service;

    public TeacherSignController(SignService service){
        this.service = service;
    }

    /**
     * 通过教师id查看签到发布记录
     * @param id 教师id
     * @return
     */
    @GetMapping("/list/{id}")
    public ResultVO list(@PathVariable Integer id){
        return service.listByStuId(id);
    }
}
