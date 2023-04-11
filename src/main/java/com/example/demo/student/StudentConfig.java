package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
        @Bean
        CommandLineRunner commandLineRunner(StudentRepository repository){
            return args -> {
                Student kane = new Student("kane", "kane@gmail.com", LocalDate.of(2000, Month.AUGUST, 14), 21);
                Student neil = new Student("neil", "neil@gmail.com", LocalDate.of(2010, Month.AUGUST, 24), 21);
                repository.saveAll(List.of(kane, neil));

            };
        }
}
