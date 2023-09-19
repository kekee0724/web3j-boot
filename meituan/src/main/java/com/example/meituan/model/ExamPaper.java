package com.example.meituan.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 试卷
 */
@Repository
public class ExamPaper {
    private Long id; //试卷ID
    private String title;//试卷标题
    private int passScore;//通过分
    private int totalScore;//总分
    private Date createTime;//创建时间
    private Long creator;//创建人

    public int getPassScore() {
        return passScore;
    }
}
