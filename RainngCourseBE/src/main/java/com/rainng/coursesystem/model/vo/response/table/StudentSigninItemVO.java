package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rainng.coursesystem.model.entity.SigninEntity;
import lombok.Data;

import java.util.Date;

@Data
public class StudentSigninItemVO {
    private Integer id;
    private String courseName;
    private String teacherName;
    private String location;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date timeStamp;
    private SigninEntity.SigninStatus status;
}
