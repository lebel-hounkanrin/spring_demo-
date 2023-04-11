package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final StudentRepository studentRepository;
  @Autowired
  public StudentService(StudentRepository studentRepository){
    this.studentRepository = studentRepository;
  }
    public List<Student> getStudents(){
		  return studentRepository.findAll();
	}
  // List.of(
  //           new Student(),
  //           new Student("kane", "kane@gmail.com", LocalDate.of(2000, Month.AUGUST, 14), 21),
  //           new Student(3L, "Neil", "neiphillip@gmail.com", LocalDate.of(2002, Month.JANUARY, 14), 20)
  //           );
}
