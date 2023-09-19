package com.example.meituan.mapper;

import com.example.meituan.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(@Param("id") Long id);//查询考生信息

    @Select("SELECT * FROM student WHERE id IN (${ids})")
        // 注意这里的 IN 子句的写法
    List<Student> batchFindByIds(@Param("ids") List<Long> ids);// 批量查询考生信息， ids.size() <= 50 即限制一次最大查询50个考试信息
}
