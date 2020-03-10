package com.codegym.studentbackend.services;

import com.codegym.studentbackend.models.Class;

import java.util.List;

public interface ClazzService {
    void saveClass(Class clazz);
    void updateClass(Class clazz);
    List<Class> getAllClass();
    Class findClassById(Long id);
    void deleteClass(Long id);
}
