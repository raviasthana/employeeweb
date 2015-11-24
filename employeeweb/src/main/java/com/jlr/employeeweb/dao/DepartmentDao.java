package com.jlr.employeeweb.dao;

import java.util.List;

import com.jlr.employeeweb.entity.Department;

public interface DepartmentDao extends GenericDao<Department, Integer> {

	List<Department> getAllDepartments();
	List<Object> getAverageSalary(List<Long> deptIds);
}
