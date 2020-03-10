package com.codegym.studentbackend.Dao.impl;

import com.codegym.studentbackend.Dao.BaseDAO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseDAO implements BaseDAO {
    @Autowired
    private EntityManager entityManager;

    /**
     * Get current session from EntityManager
     *
     * @return Session
     */
    protected Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public <T> List<T> findAll(Class<T> clazz){
        return getSession().createQuery("select t from " + clazz.getName() + " t", clazz).getResultList();
    }
    public <T> Optional<T> findById(Serializable id, Class<T> clazz){
        return Optional.ofNullable(getSession().get(clazz, id));
    }
    public <T> Serializable save(T entity){
        return getSession().save(entity);
    }
    public <T> void update(T entity){
        getSession().merge(entity);
    }
    public <T> void delete(T entity){
        getSession().delete(entity);
    }
}