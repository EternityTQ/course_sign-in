package com.rainng.coursesystem.controller.signin;

import com.rainng.coursesystem.model.vo.request.StudentSignRequestVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.signin.SignService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentSign")
public class StudentSignController {
    private final SignService service;

    public StudentSignController(SignService signService) {
        this.service = signService;
    }

    /**
     * 通过学生id查看签到记录
     * @param id 学生id
     * @return
     */
    @GetMapping("/list/{id}")
    public ResultVO list(@PathVariable Integer id){
        return service.listByStuId(id);
    }

    /**
     * 学生发送签到请求
     * @param value
     * @return
     */
    @PostMapping("/sign")
    public ResultVO sign(@RequestBody StudentSignRequestVO value){
        return service.signReqByStudent(value.getId(),value.getLocation(),value.getTimeStamp());
    }
}
