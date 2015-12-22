package com.jlr.employeeweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlr.employeeweb.entity.Employee;
import com.jlr.employeeweb.service.EmployeeService;
import static com.jlr.employeeweb.util.HRConstants.PAGINATAION_SIZE;
import static com.jlr.employeeweb.util.HRConstants.PAGE_SHOW_SIZE;;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method=RequestMethod.GET)
	public String employeesPaginated(Model model,
			@RequestParam(value = "page", required = false) Integer page){
		
		if(page == null || page < 0) page = 0;
		
		List<Employee> employeeList = employeeService.getEmployeesPaginated(page, 
													PAGINATAION_SIZE);
		
		if(employeeList.size() > PAGE_SHOW_SIZE){
			model.addAttribute("next", true);
			//remove the last element as the retrieved list
			//size is "one" more than show size 
			employeeList.remove(employeeList.size()-1);
		}else{
			model.addAttribute("next", false);
		}
		
		if(page > 0){
			model.addAttribute("prev", true);
		}else{
			model.addAttribute("prev", false);
		}
		
		model.addAttribute("page", new Integer(page));
		model.addAttribute("employeeList", employeeList);
		
		return "employeeList";
	}
	
	/*
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	public String all(Model model){
		
		List<Employee> employeeList = employeeService.getAllEmployees();
		
		model.addAttribute("employeeList", employeeList);
		
		return "employeeList";
	}*/
	
	@RequestMapping(value="/{employeeId}/jobhistory", method=RequestMethod.GET)
	public @ResponseBody Employee jobHistory(@PathVariable long employeeId){

		Employee emp = employeeService.getEmployee(employeeId);
		return emp;
	}
}
