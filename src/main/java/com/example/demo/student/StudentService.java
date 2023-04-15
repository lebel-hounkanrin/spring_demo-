package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  public void addNewStudent(Student student){
    Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
    if(studentByEmail.isPresent()){
      throw new IllegalStateException("Email already taken");
    }
    this.studentRepository.save(student);
  }

  public void deleteStudent(Long studentId ){
    boolean exists = this.studentRepository.existsById(studentId);
    if(!exists){
      throw new IllegalStateException("Student with id " + studentId + " does not exist");
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional
  public void updateStudent(Long id, String name, String email){
      Student student = studentRepository.findById(id).orElseThrow(
        () -> new IllegalStateException("Student with id " + id + " does not exist")
      );

      if(name !=null && name.length() > 0 && student.getName() != name){
        student.setName(name);
      }

      if(email !=null && email.length() > 0 && student.getEmail() != email){
        Optional<Student> studentOptinal  = studentRepository.findStudentByEmail(email);
        if(studentOptinal.isPresent()){
          throw new IllegalStateException("Email already taken");
        }
        student.setEmail(email);
      }

  }
}
