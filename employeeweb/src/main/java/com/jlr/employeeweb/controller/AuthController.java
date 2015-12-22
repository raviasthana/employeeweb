package com.jlr.employeeweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model){
		System.out.println("*************** Login *************");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model){
		System.out.println("*************** Logout *************");
		return "login";
	}

	@RequestMapping(value="/loginfailed", method=RequestMethod.GET)
	public String loginfailed(Model model){
		System.out.println("*************** loginfailed *************");
		return "login";
	}
	
}
