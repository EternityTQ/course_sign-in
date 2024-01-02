package com.rainng.coursesystem.model.vo.response.table;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SigninItemVO {
    private Integer Id;
    private Integer Code;
    private Integer CourseId;
    private LocalDateTime releaseTime;
    private LocalDateTime deadline;
}
