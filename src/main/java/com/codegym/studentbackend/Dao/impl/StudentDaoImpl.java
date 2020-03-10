package com.codegym.studentbackend.Dao.impl;

import com.codegym.studentbackend.Dao.StudentDAO;
import com.codegym.studentbackend.models.Class;
import com.codegym.studentbackend.models.Student;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class StudentDaoImpl extends AbstractBaseDAO implements StudentDAO {


    @Override
    public void saveStudent(Student student) {
        getSession().save(student);

    }

    @Override
    public void updateStudent(Student student) {
        getSession().save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = getSession().createQuery("From Student ", Student.class).list();
        return studentList;
    }

    @Override
    public Student findStudentById(Long id) {
        Student student = getSession().get(Student.class, id);

        return student;
    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public List<Student> findStudentByClassId(Long class_id) {
        Query query = getSession().createQuery(
                "select s.studentName, c.className from Student s" +
                        " join Class c on c.id = s.classId where c.id =:id");
        query.setParameter("id", class_id);
        return query.getResultList();
    }
}