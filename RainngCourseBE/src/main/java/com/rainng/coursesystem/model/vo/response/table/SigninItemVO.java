package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rainng.coursesystem.model.entity.SigninEntity;
import lombok.Data;

@Data
public class SigninItemVO {
    private Long id;
    private String student_id;
    private String course_id;
    private String location;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Data timeStamp;
    private SigninEntity.SigninStatus status;
    public SigninItemVO(Long id, String student_id, String course_id, String location, Data timeStamp, SigninEntity.SigninStatus status){
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.location = location;
        this.timeStamp = timeStamp;
        this.status = status;
    }
}
