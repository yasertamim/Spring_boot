package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// we have to add this annotation in order to make the class as a Bean
@Service
public class StudentService {
    // we have to use StudentRepository interface here using dependency injection
    // we initiate an instance of StudentRepository
    // and add it to the constructor
    // annotate the constructor with Autowired
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudents(){
        return studentRepository.findAll();
    }




    public  Student addStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email take");
        }
        studentRepository.save(student);
        return student;
    }

    public void deleteStud(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("student id "+ id+ " does not exists");
        }
        studentRepository.deleteById(id);

    }
//    by using this annotation it means that you dont have to implement any JPA query
//    so you can use the setters from your entity that you get back to check whether you can or cant update
//    and then you can use the setters to automatically update the entity in your database
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        // we check if the student presents in database by checking the id
        Student student = studentRepository.findById(studentId)
                // if not so we throw an exeption
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "+ studentId+ " does not exists"
                ));
        // otherwise
        // check if the name != null
        // length >0
        // compare if the old name is not the same as the new name
        if (name != null && name.length() >0 &&
        !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (email != null && email.length() >0 &&
                !Objects.equals(student.getEmail(),email)){
            // check if the email is exists
            Optional<Student> exists = studentRepository.findStudentByEmail(email);
            if (!exists.isPresent()){
                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);
        }


    }
}
