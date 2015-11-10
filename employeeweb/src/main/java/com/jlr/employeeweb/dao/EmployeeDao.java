package com.jlr.employeeweb.dao;

import java.util.List;

import com.jlr.employeeweb.entity.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {
	
	List<Employee> getAllEmployees();
	List<Employee> getEmployeesPaginated(int pageNumber, int pageSize);
}
