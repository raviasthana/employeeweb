package com.jlr.employeeweb.service;

import java.util.List;

import com.jlr.employeeweb.entity.Department;

public interface DepartmentService {
	
	List<Department> getAllDepartments();
	List<Object> getAverageSalary(List<Long> deptIds);
}
