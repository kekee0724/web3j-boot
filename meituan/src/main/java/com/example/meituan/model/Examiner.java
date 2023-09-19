package com.example.meituan.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Examiner {
    private Long id;
    private String name;
    private String qualification;
    private Date createTime;

    // 省略构造函数和其他方法

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}