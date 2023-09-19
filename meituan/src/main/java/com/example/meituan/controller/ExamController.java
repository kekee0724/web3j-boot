package com.example.meituan.controller;

import com.example.meituan.model.Exam;
import com.example.meituan.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/calculateStudentsPassRate")
    public void createExam(@RequestBody List<Long> studentIds) {
        examService.calculateStudentsPassRate(studentIds);
    }


    @GetMapping("/{id}")
    public Exam getExam(@PathVariable Long id) {
        return examService.getExamById(id);
    }
//
//    @PostMapping("/create")
//    public void createExam(@RequestBody TExam exam) {
//        examService.createExam(exam);
//    }
//
//    @GetMapping("/all")
//    public List<TExam> getAllExams() {
//        return examService.getAllExams();
//    }
}