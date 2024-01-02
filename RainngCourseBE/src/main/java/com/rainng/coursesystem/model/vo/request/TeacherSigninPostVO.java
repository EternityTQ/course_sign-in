package com.rainng.coursesystem.model.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TeacherSigninPostVO {
    @NotNull(message = "教师名字不能为空")
    private String teacherName;

    @NotNull(message = "课程名字不能为空")
    private String courseName;

    @NotNull(message = "签到开始时间不能为空")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date startTime;

    @NotNull(message = "签到结束时间不能为空")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date endTime;

}
