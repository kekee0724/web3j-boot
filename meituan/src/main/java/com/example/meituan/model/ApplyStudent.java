package com.example.meituan.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 报名考生
 */
@Repository
public class ApplyStudent {
    private Long id; //报名ID
    private Long examId;//考试ID
    private Long studentId;//考生ID
    private Long creator;//创建人
    private Date createTime;//创建时间

    public Long getStudentId() {
        return this.studentId;
    }

    public Long getExamId() {
        return this.examId;
    }
}
