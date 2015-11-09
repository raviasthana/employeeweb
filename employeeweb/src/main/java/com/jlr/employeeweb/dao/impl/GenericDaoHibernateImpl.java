package com.jlr.employeeweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;

import com.jlr.employeeweb.dao.GenericDao;
import com.jlr.employeeweb.util.HibernateUtil;

@SuppressWarnings("unchecked")
public abstract class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	
    protected Class<? extends T> daoType;
    
    /**
    * By defining this class as abstract, we prevent Spring from creating 
    * instance of this class If not defined as abstract, 
    * getClass().getGenericSuperClass() would return Object. There would be 
    * exception because Object class does not hava constructor with parameters.
    */
    public GenericDaoHibernateImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class<? extends T>) pt.getActualTypeArguments()[0];
    }
    
    protected Session currentSession(){
    	return HibernateUtil.getSessionFactory().openSession();
    }
	
	@Override
	public void create(T entity) {
		currentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(T entity) {
		currentSession().delete(entity);
	}

	@Override
	public T find(PK key) {
		return (T)currentSession().get(daoType, key);
	}

	@Override
	public List<T> getAll() {
		return currentSession().createCriteria(daoType).list();
	}
	
}
