package com.jlr.employeeweb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.jlr.employeeweb.dao.EmployeeDao;
import com.jlr.employeeweb.entity.Employee;
import com.jlr.employeeweb.entity.EmployeeId;

@Repository("employeeDao")
public class EmployeeDaoHibernateImpl 
	extends GenericDaoHibernateImpl<Employee, EmployeeId> 
		implements EmployeeDao {

	@Override
	public Employee getEmployee(long employeeId) {
		return super.find(new EmployeeId(employeeId));
	}
	
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
		criteria.setCacheable(true);
		
		return criteria.list();
	}

}
