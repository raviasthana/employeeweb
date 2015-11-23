package com.jlr.employeeweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlr.employeeweb.dao.EmployeeDao;
import com.jlr.employeeweb.entity.Employee;
import com.jlr.employeeweb.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployee(long employeeId) {
		return employeeDao.getEmployee(employeeId);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	@Override
	public List<Employee> getEmployeesPaginated(int pageNumber, int pageSize) {
		return employeeDao.getEmployeesPaginated(pageNumber, pageSize);
	}
}
