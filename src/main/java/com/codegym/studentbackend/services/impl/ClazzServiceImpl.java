package com.codegym.studentbackend.services.impl;

import com.codegym.studentbackend.Dao.ClassDAO;
import com.codegym.studentbackend.models.Class;
import com.codegym.studentbackend.services.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClassDAO classDAO;
    @Override
    public void saveClass(Class clazz) {
        classDAO.saveClass(clazz);

    }

    @Override
    public void updateClass(Class clazz) {
        classDAO.saveClass(clazz);
    }

    @Override
    public List<Class> getAllClass() {
        return classDAO.getAllClass();
    }

    @Override
    public Class findClassById(Long id) {
        return classDAO.findClassById(id);
    }

    @Override
    public void deleteClass(Long id) {
        Class clazz = classDAO.findClassById(id);
        classDAO.deleteClass(clazz);
    }
}