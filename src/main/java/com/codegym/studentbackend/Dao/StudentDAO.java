package com.codegym.studentbackend.Dao;

import com.codegym.studentbackend.models.Class;
import com.codegym.studentbackend.models.Student;

import java.util.List;

public interface StudentDAO {
    void saveStudent(Student student);
    void updateStudent(Student student);
    List<Student> getAllStudent();
    Student findStudentById(Long id);
    void deleteStudent(Student student);
    List<Student> findStudentByClassId(Long class_id);

}
