package com.codegym.studentbackend.services;

import com.codegym.studentbackend.Dto.StudentResponse;
import com.codegym.studentbackend.models.Class;
import com.codegym.studentbackend.models.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    void updateStudent(Student student);
    List<StudentResponse> getAllStudent();
    StudentResponse findStudentById(Long id);
    void deleteStudent(Long id);
    List<Student> findStudentByClassId(Long class_id);
}
