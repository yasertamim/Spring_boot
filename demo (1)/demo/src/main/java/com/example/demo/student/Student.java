package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

// we have to add these annotations in order to make a table of student class in te database
// @Entity is used for hibernate
@Entity
// this for table in our database
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    // class attributes
    private String name;
    private String email;
    // this annotation means that there is no need to this attribute
    // to be a column in the database
    // because we will make it calculated
    @Transient
    private Integer age;
    private LocalDate dob;


    // we should create an empty constructor in order to database
    // create table of students
    public Student() {

    }

    // right click to generate a constructor
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // right click to generate getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return
                // this way is to calculate the age
                Period.between(this.getDob(),LocalDate.now()).getYears();
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // generate toString() method

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Age=" + age +
                ", Dob=" + dob +
                '}';
    }
}
