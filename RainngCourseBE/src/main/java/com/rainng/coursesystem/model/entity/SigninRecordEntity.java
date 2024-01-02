package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName("rc_signin_record")
@Data
public class SigninRecordEntity {
    private static final String ID = "id";
    private static final String LATITUDE = "Latitude";
    private static final String LONGITUDE = "Longitude";
    private static final String START = "Start";
    private static final String END = "End";
    private static final String COURSE = "signin_course_id";
    private static final String CODE = "signin_code";

    @NonNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择签到开始时间")
    @TableField(START)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date start;

    @NotNull(message = "必须选择签到结束时间")
    @TableField(END)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date end;

    @NotNull
    @TableField(CODE)
    private int signin_code;
    @NotNull
    @TableField(COURSE)
    private int course_id;

    public SigninRecordEntity() {}

}
