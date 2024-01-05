package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rainng.coursesystem.model.entity.SigninStatusEntity;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Data
public class StudentStatusItemVO {
    private Integer studentId;
    private String studentNum;
    private String studentName;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime signinTime;

    private SigninStatusEntity.SigninStatus Status;

}
