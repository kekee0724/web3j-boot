package com.example.meituan.service;

import com.example.meituan.model.ApplyStudent;
import com.example.meituan.model.Exam;
import com.example.meituan.model.ExamResult;
import com.example.meituan.model.Student;
import com.example.meituan.mapper.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 有一个考试系统，在考试系统中可以创建在线考试Exam,每场考试需要设置一张试卷ExamPaper,
 * 每场考试的需要学生Student报名参加ApplyStudent，
 * 每个考生可以报考多场考试，考试结束后会有相应的考试成绩 ExamResult
 * ***请利用已有的方法，批量统计一批考生考试通过率（实现ExamService.calculateStudentsPassRate方法）,
 * 通过率小数点保留2位，考生可能很多不少于1千，注意性能***
 */
@Service
public class ExamService {
    @Resource
    private ExamMapper examMapper;
    @Resource
    private ExamPaperMapper examPaperMapper;
    @Resource
    private ApplyStudentMapper applyStudentMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ExamResultMapper examResultMapper;


    //请统计考生考试通过率, 通过率小数点保留2位，提示每个考生可以报考多场考试，考生可能很多不少于1千，注意性能
    public Map<Student, Float> calculateStudentsPassRate(List<Long> studentIds) {
        Map<Student, Float> passRates = new HashMap<>();

        for (Long studentId : studentIds) {
            // 查询该学生的考试成绩和报名情况
            List<ApplyStudent> applyStudents = applyStudentMapper.findByStudentId(studentId);
            List<Long> examIds = new ArrayList<>();
            for (ApplyStudent applyStudent : applyStudents) {
                examIds.add(applyStudent.getExamId());
            }
            if (!examIds.isEmpty()) {
                List<ExamResult> examResults = examResultMapper.batchFindByIds(examIds);

                // 计算通过率
                int totalExams = examIds.size();
                int passedExams = 0;
                for (ExamResult examResult : examResults) {
                    if (examResult.getScore() >= examPaperMapper.findById(examResult.getExamId()).getPassScore()) {
                        passedExams++;
                    }
                }

                // 计算通过率并存储在 Map 中
                float passRate = (totalExams > 0) ? (float) passedExams / totalExams : 0;
                Student student = studentMapper.findById(studentId);
                passRates.put(student, passRate);
            }
        }

        return passRates;
    }

    public Exam getExamById(Long id) {
        return examMapper.findById(id);
    }
}