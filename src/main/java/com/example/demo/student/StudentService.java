package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents(){
		return List.of(
            new Student(),
            new Student("kane", "kane@gmail.com", LocalDate.of(2000, Month.AUGUST, 14), 21),
            new Student(3L, "Neil", "neiphillip@gmail.com", LocalDate.of(2002, Month.JANUARY, 14), 20)
            );
	}
}
