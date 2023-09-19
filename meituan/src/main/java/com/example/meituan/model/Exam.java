package com.example.meituan.model;

import lombok.Data;

import java.util.Date;

/**
 * 考试
 */
//@Repository
@Data
public class Exam {
    private Long id; //考试ID
    private String title;//考试标题
    private Date beginTime;//考试开始时间
    private Date endTime;//考试结束时间
    private Long paperId;//试卷ID
    private Long examinerId;//考官ID
    private Long creator;//创建人
    private Date createTime;//创建时间


    public Long getId() {
        return this.id;
    }

    public int getPassScore() {
        return 0;
    }
}
