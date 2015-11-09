package com.jlr.employeeweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlr.employeeweb.dao.DepartmentDao;
import com.jlr.employeeweb.entity.Department;

@Repository("departmentDao")
public class DepartmentDaoHibernateImpl
	extends GenericDaoHibernateImpl<Department, Integer>
		implements DepartmentDao {

	@Override
	public List<Department> getAllDepartments() {
		return getAll();
	}

}
