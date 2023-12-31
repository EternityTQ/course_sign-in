package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NonNull;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@TableName("rc_signin_status")
@Data
public class SigninStatusEntity {
    private static final String ID = "id";
    private static final String LATITUDE = "Latitude";
    private static final String LONGITUDE = "Longitude";;
    private static final String STUDENT = "signin_student_id";
    private static final String CODE = "signin_code";
    private static final String STATUS = "status";
    private static final String TIMESTAMP = "timestamp";
    /**
     * 签到状态
     */
    public enum  SigninStatus {
        SUCCESS,         // 签到成功
        FAILED,         // 未签到
        ERROR ,       // 错误
    }
    @NonNull
    @TableId(value = ID, type = IdType.AUTO)
    private int id;

    @NotNull
    @TableField(STUDENT)
    private int student_id;

    @NotNull
    @TableField(CODE)
    private int signin_code;

    @NotNull(message = "签到状态不能为空")
    @TableField(STATUS)
    private SigninStatus status;

    @NotNull
    @TableField(TIMESTAMP)
    private LocalDateTime timestamp;
    public SigninStatusEntity (){}
}
