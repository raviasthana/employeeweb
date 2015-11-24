package com.jlr.employeeweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlr.employeeweb.dao.DepartmentDao;
import com.jlr.employeeweb.entity.Department;
import com.jlr.employeeweb.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

	@Override
	public List<Object> getAverageSalary(List<Long> deptIds) {
		return departmentDao.getAverageSalary(deptIds);
	}

}
