package com.codegym.studentbackend.controllers;

import com.codegym.studentbackend.Dto.StudentResponse;
import com.codegym.studentbackend.models.Student;
import com.codegym.studentbackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/class/{id}")
    public ResponseEntity<List<Student>> getStudentByClassId(@PathVariable("id") Long id){
        List<Student> studentList = studentService.findStudentByClassId(id);

        if(studentList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable("id") Long id){
        StudentResponse student = studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentResponse>> getAllStudent(){
        List<StudentResponse> studentList = studentService.getAllStudent();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}