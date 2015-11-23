package com.jlr.employeeweb.dao;

import java.util.List;

import com.jlr.employeeweb.entity.Employee;
import com.jlr.employeeweb.entity.EmployeeId;

public interface EmployeeDao extends GenericDao<Employee, EmployeeId> {
	
	Employee getEmployee(long employeeId);
	List<Employee> getAllEmployees();
	List<Employee> getEmployeesPaginated(int pageNumber, int pageSize);
}
