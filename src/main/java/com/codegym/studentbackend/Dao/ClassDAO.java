package com.codegym.studentbackend.Dao;

import com.codegym.studentbackend.models.Class;

import java.util.List;

public interface ClassDAO {
    void saveClass(Class clazz);
    void updateClass(Class clazz);
    List<Class> getAllClass();
    Class findClassById(Long id);
    void deleteClass(Class clazz);
}
