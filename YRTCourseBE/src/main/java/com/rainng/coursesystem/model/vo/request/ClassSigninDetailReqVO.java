package com.rainng.coursesystem.model.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClassSigninDetailReqVO {
    private Integer CourseId;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime start;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime end;

}
