package com.rainng.coursesystem.model.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class StudentSignRequestVO {

    @NotNull
    private Integer id;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @NotNull(message = "时间不能为0")
    private LocalDateTime curTime;

    @NotNull(message = "签到码不能为空")
    private Integer code;
}
