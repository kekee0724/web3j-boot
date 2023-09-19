package com.example.meituan.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 考试结果
 */
@Repository
public class ExamResult {
    private Long id; //考试结果ID

    private Long examId;//考试ID
    private Long studentId; //学生ID
    private int score; //考试得分
    private Long creator;//创建人
    private Date createTime;//创建时间

    public Long getStudentId() {
        return this.studentId;
    }

    public int getScore() {
        return this.score;
    }

    public Long getExamId() {
        return this.examId;
    }
}
