package com.example.meituan;

import com.example.meituan.model.Student;
import com.example.meituan.service.ExamService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.example.meituan.mapper")
public class MeituanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MeituanApplication.class, args);
        // 创建 ExamService 对象（假设你已经初始化了所有相关的 Mapper 和依赖）
        ExamService examService = applicationContext.getBean(ExamService.class);

        // 准备一批学生的 ID 列表
        List<Long> studentIds = Arrays.asList(1L, 2L, 3L); // 这里使用示例学生 ID，你可以根据实际需求替换成真实的学生 ID

        // 调用 calculateStudentsPassRate 方法来计算考生的考试通过率
        Map<Student, Float> passRates = examService.calculateStudentsPassRate(studentIds);

        // 输出考生的考试通过率
        for (Map.Entry<Student, Float> entry : passRates.entrySet()) {
            Student student = entry.getKey();
            Float passRate = entry.getValue();
            System.out.println("学生姓名：" + student.getName() + ", 考试通过率：" + passRate);
        }
    }

}
