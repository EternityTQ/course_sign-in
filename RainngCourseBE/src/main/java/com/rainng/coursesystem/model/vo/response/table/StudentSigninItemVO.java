package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rainng.coursesystem.model.entity.SigninRecordEntity;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import lombok.Data;

import java.util.Date;

@Data
public class StudentSigninItemVO {
    private Integer id;
    private String courseName;
    private String teacherName;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date timeStamp;
    private SigninStatusEntity.SigninStatus status;
}
