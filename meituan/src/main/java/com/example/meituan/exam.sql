drop table if exists user;
CREATE TABLE user
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    email       VARCHAR(255),
    create_time DATETIME     NOT NULL
);

drop table if exists student;
CREATE TABLE student
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    cardNo     VARCHAR(20)  NOT NULL,
    creator    BIGINT       NOT NULL,
    createTime DATETIME     NOT NULL,
    FOREIGN KEY (creator) REFERENCES user (id)
);

drop table if exists examiner;
CREATE TABLE examiner
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    qualification VARCHAR(255),
    create_time   DATETIME     NOT NULL
);

drop table if exists exam_paper;
CREATE TABLE exam_paper
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    passScore  INT          NOT NULL,
    totalScore INT          NOT NULL,
    createTime DATETIME     NOT NULL,
    creator    BIGINT       NOT NULL
);

drop table if exists exam;
CREATE TABLE exam
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    beginTime  DATETIME     NOT NULL,
    endTime    DATETIME     NOT NULL,
    paperId    BIGINT       NOT NULL,
    examinerId BIGINT       NOT NULL,
    creator    BIGINT       NOT NULL,
    createTime DATETIME     NOT NULL,
    FOREIGN KEY (paperId) REFERENCES exam_paper (id),
    FOREIGN KEY (examinerId) REFERENCES examiner (id),
    FOREIGN KEY (creator) REFERENCES user (id)
);

drop table if exists apply_student;
CREATE TABLE apply_student
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    examId     BIGINT   NOT NULL,
    studentId  BIGINT   NOT NULL,
    creator    BIGINT   NOT NULL,
    createTime DATETIME NOT NULL,
    FOREIGN KEY (examId) REFERENCES exam (id),
    FOREIGN KEY (studentId) REFERENCES student (id),
    FOREIGN KEY (creator) REFERENCES user (id)
);



drop table if exists exam_result;
CREATE TABLE exam_result
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    examId     BIGINT   NOT NULL,
    studentId  BIGINT   NOT NULL,
    score      INT      NOT NULL,
    creator    BIGINT   NOT NULL,
    createTime DATETIME NOT NULL,
    FOREIGN KEY (examId) REFERENCES exam (id),
    FOREIGN KEY (studentId) REFERENCES student (id),
    FOREIGN KEY (creator) REFERENCES user (id)
);
