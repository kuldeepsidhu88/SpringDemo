package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/welcome"})
	public String showHomePage(ModelMap model){
		model.addAttribute("message","Hello from Spring");
		return "home";
	}
	@RequestMapping(value={"/","/welcome"},params="login_error")
	public String showLoginError(ModelMap model){
		model.addAttribute("login_error","Bad username or password. Please try again");
		return "home";
	}
	
	@RequestMapping(value="/admin")
	public String showAdminPage(ModelMap model){
		model.addAttribute("message","Hello from Admin Page!");
		return "adminHome";
	}
	
	/*@RequestMapping(value="/login")
	public String redirectToLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String redirectToLogoutPage(ModelMap model){
		return "logout";
	}*/
}
