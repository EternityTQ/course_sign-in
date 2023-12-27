package com.rainng.coursesystem.controller.signin;

import com.rainng.coursesystem.model.vo.request.SignRequestVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.SigninItemVO;
import com.rainng.coursesystem.service.signin.SignService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign")
public class SignController {
    // todo
    private final SignService service;

    public SignController(SignService signService) {
        this.service = signService;
    }
    // 查看签到记录
    @GetMapping("/list")
    public ResultVO list(){
        return service.list();
    }
    // 返回签到结果
//    @PostMapping("/sign")
//    public Integer sign(@RequestBody SignRequestVO value){
//        return service.sign(value.getId(),value.getLocation(),value.getTimeStamp());
//    }
}
