package com.example.meituan.mapper;

import com.example.meituan.model.ApplyStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApplyStudentMapper {
    @Select("SELECT * FROM apply_student WHERE examId = #{examId} LIMIT #{pageSize} OFFSET #{offset}")
    List<ApplyStudent> findByExamId(
            @Param("examId") Long examId,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );//分页查询某个考试报名情况, pageSize 限制不超过50

    @Select("SELECT COUNT(*) FROM apply_student WHERE examId = #{examId}")
    int countByExamId(@Param("examId") Long examId);//统计某个考试报名人数

    @Select("SELECT * FROM apply_student WHERE studentId = #{studentId}")
    List<ApplyStudent> findByStudentId(@Param("studentId") Long studentId);//查询某个学生报名考试情况

    @Select("SELECT * FROM apply_student WHERE studentId IN (${studentIds})")
        // 注意这里的 IN 子句的写法
    List<ApplyStudent> batchFindByStudentIds(@Param("studentIds") List<Long> studentIds);//批量查询一批学生报名考试的情况， studentIds限制一次最多查询100个
}