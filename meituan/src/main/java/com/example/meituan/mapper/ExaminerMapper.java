package com.example.meituan.mapper;

import com.example.meituan.model.Examiner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ExaminerMapper {
    @Select("SELECT * FROM Examiner WHERE id = #{id}")
    Examiner findById(@Param("id") Long id);

    // 根据姓名查询考官
    @Select("SELECT * FROM Examiner WHERE name = #{name}")
    Examiner findByName(@Param("name") String name);
}