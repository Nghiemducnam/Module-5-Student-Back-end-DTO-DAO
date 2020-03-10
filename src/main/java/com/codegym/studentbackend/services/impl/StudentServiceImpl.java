package com.codegym.studentbackend.services.impl;

import com.codegym.studentbackend.Dao.StudentDAO;
import com.codegym.studentbackend.Dto.StudentResponse;
import com.codegym.studentbackend.models.Student;
import com.codegym.studentbackend.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentDAO studentDAO;
    @Override
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
//        List<Student> studentList = studentDAO.getAllStudent();
//        List<StudentResponse> responseList = modelMapper.map(studentList, StudentResponse.class)
//        return ;
        List<Student> students = studentDAO.getAllStudent();
        return students.stream()
                .map(location->modelMapper.map(location, StudentResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public StudentResponse findStudentById(Long id) {
//        ModelMapper modelMapper = new ModelMapper();
        Student student = studentDAO.findStudentById(id);
        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);
        return studentResponse;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentDAO.findStudentById(id);
        studentDAO.deleteStudent(student);
    }

    @Override
    public List<Student> findStudentByClassId(Long class_id) {
        List<Student> studentList = studentDAO.findStudentByClassId(class_id);
        if(studentList.isEmpty()){
            return null;
        }
        return studentList;
    }
}