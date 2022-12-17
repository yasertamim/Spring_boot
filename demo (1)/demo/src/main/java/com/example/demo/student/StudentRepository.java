package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// we have to annotate this interface with @Repository
// because this interface is responsible for data access
@Repository
// we have to extend this interface from JpaRepository which has alot of methods to interact with database.
// JpaRepository takes generics such as type of object that we want the repository to work with
// which is Student and id for the type that we want

public interface StudentRepository extends JpaRepository<Student,Long> {

    // this considered as a query that check if the email that the user insert
    // is presents in the database
    Optional<Student>findStudentByEmail(String email);
}
