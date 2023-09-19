package com.example.meituan.mapper;

import com.example.meituan.model.ExamResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamResultMapper {
    @Select("SELECT * FROM exam_result WHERE id = #{id}")
    ExamResult findById(@Param("id") Long id);//查询考试结果信息

    @Select("SELECT * FROM exam_result WHERE examId = #{examId} AND studentId = #{studentId}")
    ExamResult findStudentResultByExamId(@Param("examId") Long examId, @Param("studentId") Long studentId);//查询某个学生的某场考试结果信息

    @Select("SELECT * FROM exam_result WHERE id IN (${ids})")
        // 注意这里的 IN 子句的写法
    List<ExamResult> batchFindByIds(@Param("ids") List<Long> ids);// 批量查询考试结果信息，ids是考试结果集合， ids.size() <= 50 即限制一次最大查询50个考试信息

    @Select("SELECT * FROM exam_result WHERE examId = #{examId} LIMIT #{pageSize} OFFSET #{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "score", column = "score"),
            // 添加其他属性的映射
    })
    List<ExamResult> findByExamId(
            @Param("examId") Long examId,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );// 分页查询某场考试结果信息， pageSize一次最多50个

    @Select("SELECT COUNT(*) FROM exam_result WHERE examId = #{examId}")
    int countByExamId(@Param("examId") Long examId);// 统计某场考试结果条数
}
