package com.rainng.coursesystem.model.vo.response.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rainng.coursesystem.config.handler.SigninStatusTypeHandler;
import com.rainng.coursesystem.model.entity.SigninEntity;
import lombok.Data;

import java.util.Date;

@Data
public class SigninItemVO {
    private int id;
    private int student_id;
    private int course_id;
    private String location;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date timeStamp;
    private SigninEntity.SigninStatus status;
}
