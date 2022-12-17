package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// this annotation allow us to use restful in the application
// it makes the DemoApplication class serves Rest endpoints
// it must be RestController not Controller
@RestController
@RequestMapping("/api")
public class StudentController {

    // create aan insance of StudentService

    private final StudentService studentService;

    // we create a constructor to inject the studentService
    // in order to inject studentService to the constructor so we use this annotation   @Autowired
    // this annotation instantiates studentService and injects it in the constructor
    // but we have to make the class StudentService Spring Bean (go to StudentService class and adjust it)
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // this annotation for Get request
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    // we use @RequestBody in order to take the input from user
    // in other words we take the request body and pass it to the student object
    public void addNewStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    // this annotation allows us to get the value from path
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStud(id);
    }



    @PutMapping(path= "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        studentService.updateStudent(studentId,name,email);
    }


}