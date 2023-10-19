CREATE TABLE Homework (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT
);
CREATE TABLE Lesson (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    updatedAt DATETIME,
    homework_id INT,
    FOREIGN KEY (homework_id) REFERENCES Homework(id)
);
CREATE TABLE Schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    updatedAt DATETIME
);

CREATE TABLE Schedule_Lesson (
    schedule_id INT,
    lesson_id INT,
    PRIMARY KEY (schedule_id, lesson_id),
    FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
    FOREIGN KEY (lesson_id) REFERENCES Lesson(id)
);