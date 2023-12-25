package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@TableName("signin_record")
@Data
public class SigninEntity {
    private static final String ID = "signin_id";
    private static final String LOCATION = "location";
    private static final String TIMESTAMP = "timestamp";
    private static final String STATUS = "status";
    private static final String STUDENT = "signin_student";
    private static final String COURSE = "signin_course";
    /**
     * 签到状态
     */
    public enum SigninStatus {
        SUCCESS,     // 签到成功
        FAILED, // 未签到
        ERROR        // 错误
    }
    @NonNull
    @TableId(value = ID, type = IdType.AUTO)
    private Long id;

    @NotNull(message = "必须选择签到时间")
    @TableField(TIMESTAMP)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Data timeStamp;

    @NotNull(message = "必须选择地点")
    @TableField(LOCATION)
    private String location;

    @NotNull
    @TableField(STATUS)
    private SigninStatus status;

    @NotNull
    @TableField(STUDENT)
    private String student_id;

    @NotNull
    @TableField(COURSE)
    private String course_id;

}
