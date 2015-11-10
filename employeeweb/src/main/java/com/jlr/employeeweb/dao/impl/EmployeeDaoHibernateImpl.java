package com.jlr.employeeweb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.jlr.employeeweb.dao.EmployeeDao;
import com.jlr.employeeweb.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoHibernateImpl 
	extends GenericDaoHibernateImpl<Employee, Integer> 
		implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		return getAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesPaginated(int pageNumber, int pageSize) {
		
		Criteria criteria = currentSession().createCriteria(Employee.class);
		criteria.setFirstResult(pageNumber * (pageSize-1));
		criteria.setMaxResults(pageSize);
		
		return criteria.list();
	}
}
