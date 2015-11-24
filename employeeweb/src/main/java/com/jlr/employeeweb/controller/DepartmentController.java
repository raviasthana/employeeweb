package com.jlr.employeeweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlr.employeeweb.entity.Department;
import com.jlr.employeeweb.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(method=RequestMethod.GET)
	public String getDepartmentList(Model model){
		
		model.addAttribute("departmentList", 
				departmentService.getAllDepartments());
		
		return "salaryComparison";
	}

	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getDepartmentList(){
		return departmentService.getAllDepartments();
	}
	
	@RequestMapping(value="/{deptIds}/avgsalary", method=RequestMethod.GET)
	@ResponseBody
	public List<Object> averageSalary(@PathVariable List<Long> deptIds){		
		return departmentService.getAverageSalary(deptIds);
	}
}
