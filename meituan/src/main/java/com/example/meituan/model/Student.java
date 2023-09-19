package com.example.meituan.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 考生
 */
@Repository
public class Student {
    private Long id; //学生ID
    private String name;//学生姓名
    private String cardNo;//考生身份证号
    private Long creator;//创建人
    private Date createTime;//创建时间

    public String getName() {
        return this.name;
    }
}
