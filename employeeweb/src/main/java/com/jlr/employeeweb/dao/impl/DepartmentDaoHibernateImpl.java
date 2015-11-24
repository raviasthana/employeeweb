package com.jlr.employeeweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAverageSalary(List<Long> deptIds) {
		
		Query query = currentSession().createQuery("select d.departmentName, avg(e.salary) " +
											"from Employee e INNER JOIN e.department d " +
											"where d.departmentId in (:departmentIds) " +
											"group by d.departmentName");
		
		query.setParameterList("departmentIds", deptIds);
		
		return query.list();
	}
	
}
