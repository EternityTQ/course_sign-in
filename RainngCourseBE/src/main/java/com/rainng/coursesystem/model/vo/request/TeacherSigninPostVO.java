package com.rainng.coursesystem.model.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TeacherSigninPostVO {
    @NotNull(message = "教师id不能为空")
    private Integer teacherId;

    @NotNull(message = "课程名字不能为空")
    private String courseName;

    @NotNull(message = "签到开始时间不能为空")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime startTime;

    @NotNull(message = "签到结束时间不能为空")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime endTime;


}
