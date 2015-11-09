package com.jlr.employeeweb.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	public void create(T entity);

	public void saveOrUpdate(T entity);

	public void update(T entity);

	public void remove(T entity);

	public T find(PK key);

	public List<T> getAll();
}
