package com.codegym.studentbackend.Dao.impl;

import com.codegym.studentbackend.Dao.ClassDAO;
import com.codegym.studentbackend.models.Class;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ClassDaoImpl extends AbstractBaseDAO implements ClassDAO {
    @Override
    public void saveClass(Class clazz) {
        getSession().save(clazz);

    }

    @Override
    public void updateClass(Class clazz) {
        getSession().save(clazz);
    }

    @Override
    public ArrayList<Class> getAllClass() {
        List<Class> classList = getSession().createQuery("FROM Class").list();
        return new ArrayList<>(classList);
    }

    @Override
    public Class findClassById(Long id) {
        Class clazz = getSession().get(Class.class, id);

        return clazz;
    }

    @Override
    public void deleteClass(Class clazz) {
//        Session currentSession = getSession().;
//        Query query = currentSession.createQuery("DELETE FROM Class WHERE id =: id");
//        query.setParameter("id", id);
        getSession().delete(clazz);
    }
}