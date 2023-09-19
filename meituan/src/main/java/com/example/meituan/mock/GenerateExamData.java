package com.example.meituan.mock;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 要模拟 1000 位考生的考试情况数据并生成 MySQL 的 INSERT 语句，
 * 你可以使用循环生成这些数据，并将生成的 INSERT 语句输出到文件或控制台。
 * 以下是一个简单的 Java 代码示例，用于生成这些 INSERT 语句：
 *
 * 上述代码会生成一个名为 `insert_data.sql` 的文件，
 * 其中包含了 1000条随机生成的 INSERT 语句，用于插入考试情况数据。
 * 你可以根据你的数据库表结构和需要进行适当的调整。
 * 然后，将生成的 SQL 文件导入到你的 MySQL 数据库中即可。
 */
public class GenerateExamData {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("insert_data.sql");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // 循环生成 1000 位考生的考试情况数据
            for (int i = 1; i <= 1000; i++) {
                long examId = getRandomLong(1, 50); // 假设有 50 场考试
                long studentId = getRandomLong(1, 100); // 假设有 100 名学生
                int score = getRandomInt(0, 100); // 随机生成分数

                // 生成 INSERT 语句并写入文件
                String insertStatement = String.format("INSERT INTO exam_result (examId, studentId, score) VALUES (%d, %d, %d);", examId, studentId, score);
                printWriter.println(insertStatement);
            }

            printWriter.close();
            fileWriter.close();
            System.out.println("INSERT 语句已生成到 insert_data.sql 文件中。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 生成指定范围内的随机整数
    private static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // 生成指定范围内的随机长整数
    private static long getRandomLong(long min, long max) {
        Random random = new Random();
        return (long) (random.nextDouble() * (max - min + 1) + min);
    }
}

