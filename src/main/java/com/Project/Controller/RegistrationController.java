package com.Project.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Project.ENTITY.User;
import com.Project.SERVICES.RegistrationServices;

@Controller
public class RegistrationController 
{	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	RegistrationServices registrationServices;
	
	@RequestMapping("showRegister")
	public String showRegister() 
	{
		return "register";
	}
		
	@RequestMapping("saveToDB")
	public ModelAndView saveToDB(User user,HttpServletRequest request) throws IllegalStateException, IOException
	{

		ModelAndView modelAndView = registrationServices.registrationService(user,request);
		
		return modelAndView;	
		
	}
}
