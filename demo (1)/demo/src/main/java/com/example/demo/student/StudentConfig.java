package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
          Student yaser = new Student(
                  "yaser",
                  "yaser@gmail.com",
                  LocalDate.of(1984, Month.MAY, 19)

          );

            Student aouss = new Student(
                    "aouss",
                    "aouss@gmail.com",
                    LocalDate.of(2000, Month.MAY, 29)

            );

            repository.saveAll(List.of(yaser,aouss));
        };

    }
}
