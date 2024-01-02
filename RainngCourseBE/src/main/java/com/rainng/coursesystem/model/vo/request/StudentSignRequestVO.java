package com.rainng.coursesystem.model.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentSignRequestVO {
    @NotNull(message = "签到id不能为0")
    private Integer id;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @NotNull(message = "时间不能为0")
    private Date timeStamp;

    @NotNull(message = "地点不能为0")
    private String location;
}
