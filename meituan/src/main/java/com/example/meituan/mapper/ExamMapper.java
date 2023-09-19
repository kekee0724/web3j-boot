package com.example.meituan.mapper;

import com.example.meituan.model.Exam;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface ExamMapper {
    @Select("SELECT * FROM exam WHERE id = #{id}")
    Exam findById(@Param("id") Long id);//查询考试信息

    @Select("SELECT * FROM exam WHERE id IN (#{ids})")
    List<Exam> batchFindByIds(@Param("ids") List<Long> ids);// 批量查询考试信息， ids.size() <= 50 即限制一次最大查询50个考试信息

    @Select("SELECT * FROM exam WHERE beginTime <= #{endTime} AND endTime >= #{beginTime} " +
            "LIMIT #{pageSize} OFFSET #{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            // 添加其他属性的映射
    })
    List<Exam> findPeriod(
            @Param("beginTime") Date beginTime,
            @Param("endTime") Date endTime,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );//查询beginTime~endTime时间范围内的生效的考试信息，pageSize一次最多50个
}