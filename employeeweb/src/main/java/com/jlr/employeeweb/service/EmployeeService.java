package com.jlr.employeeweb.service;

import java.util.List;

import com.jlr.employeeweb.entity.Employee;

public interface EmployeeService {
	
	Employee getEmployee(long employeeId);
	List<Employee> getAllEmployees();
	List<Employee> getEmployeesPaginated(int pageNumber, int pageSize);
}
