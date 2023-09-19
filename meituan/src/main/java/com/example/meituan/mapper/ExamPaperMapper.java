package com.example.meituan.mapper;

import com.example.meituan.model.ExamPaper;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperMapper {
    @Select("SELECT * FROM exam_paper WHERE id = #{id}")
    ExamPaper findById(@Param("id") Long id);//查询试卷信息

    @Select("SELECT * FROM exam_paper WHERE id IN (${ids})")
        // 注意这里的 IN 子句的写法
    List<ExamPaper> batchFindByIds(@Param("ids") List<Long> ids);// 批量查询试卷信息， ids.size() <= 50 即限制一次最大查询50个考试信息

    @Select("SELECT * FROM exam_paper WHERE createTime BETWEEN #{beginTime} AND #{endTime} LIMIT #{pageSize} OFFSET #{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            // 添加其他属性的映射
    })
    List<ExamPaper> findPeriod(
            @Param("beginTime") Date beginTime,
            @Param("endTime") Date endTime,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );//查询beginTime~endTime时间范围内的创建的时间试卷信息，pageSize一次最多50个
}

