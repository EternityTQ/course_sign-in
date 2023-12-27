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
import java.util.Date;

@TableName("rc_signin_record")
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
    public enum  SigninStatus {
        SUCCESS,         // 签到成功
        FAILED,         // 未签到
        ERROR ,       // 错误
    }
    public static SigninStatus fromString(String status) {
        switch (status) {
            case "SUCCESS":
                return SigninStatus.SUCCESS;
            case "FAILED":
                return SigninStatus.FAILED;
            case "ERROR":
                return SigninStatus.FAILED;
            default:
                throw new IllegalArgumentException("Invalid value for SigninStatus: " + status);
        }
    }
    @NonNull
    @TableId(value = ID, type = IdType.AUTO)
    private int id;

    @NotNull(message = "必须选择签到时间")
    @TableField(TIMESTAMP)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date timeStamp;

    @NotNull(message = "必须选择地点")
    @TableField(LOCATION)
    private String location;

    @NotNull
    @TableField(STATUS)
    private SigninStatus status;

    @NotNull
    @TableField(STUDENT)
    private int student_id;

    @NotNull
    @TableField(COURSE)
    private int course_id;

}
