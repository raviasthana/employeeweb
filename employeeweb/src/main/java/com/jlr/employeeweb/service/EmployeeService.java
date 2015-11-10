package com.jlr.employeeweb.service;

import java.util.List;

import com.jlr.employeeweb.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	List<Employee> getEmployeesPaginated(int pageNumber, int pageSize);
}
