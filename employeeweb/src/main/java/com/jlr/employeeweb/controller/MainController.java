package com.jlr.employeeweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jlr.employeeweb.service.DepartmentService;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class MainController {

	@Autowired
	private DepartmentService departmentService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		logger.info("Welcome home!");
		
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
		
		/*
		List<Department> deptList = departmentService.getAllDepartments();
		
		
		for(Department dept : deptList){
			System.out.println("Department Name:[] " + dept.getDepartmentName());
			System.out.println("Manager First Name:[] " + (dept.getManager() != null ? dept.getManager().getFirstName() : "No_Manager" ));			
		}*/
		
		return "welcome";
	}

}
