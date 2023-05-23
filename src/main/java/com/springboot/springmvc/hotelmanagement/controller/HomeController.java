package com.springboot.springmvc.hotelmanagement.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.springmvc.hotelmanagement.entity.User;

@Controller
public class HomeController {
	 public HomeController() {
	
	
}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("login");
		User user=new User();
		user.setUsername("someone@someonehost.com");
		mv.addObject("user",user);
		return mv;
	}
	@PostMapping("/login")
	public String authenticate(@Valid User user, BindingResult result, HttpSession session ) {
		 if(result.hasErrors()) {
			 return "login";
		 }
		 else if(user.getUsername().equals("surajpatil0333@gmail.com")&& user.getPassword().equals("mikado")) {
			 session.setAttribute("user", user);
			 return "userhome";
		 }
		 else
		 {
			 if(!user.getUsername().equals("surajpatil0333@gmail.com")){
				 result.addError(new FieldError("user","username","Username  is incorrect"));
			 }
			 if(!user.getPassword().equals("mikado")){
				 result.addError(new FieldError("user","password","Password is incorrect"));
			 }
			 return "login";
		 }
}
	@GetMapping("/secure/home")
	public String home()
	{
		return "userhome";
		
	}
	@GetMapping("/back")
	public String back(HttpSession session)
	
	{
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			return "welcome";
		}
		else
		{
			return "userhome";
		}
		
	}
	@GetMapping("/secure/logout")
	public String logout(HttpSession session) {
		 session.removeAttribute("user");
		 return "welcome";
	}
}
