package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherSigninItemVO {
    private int id;
    private String courseName;
    private String location;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date releaseTime;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date deadline;
    private int code;

}
