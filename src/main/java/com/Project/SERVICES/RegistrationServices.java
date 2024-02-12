package com.Project.SERVICES;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.Project.DAO.RegistrationDAO;
import com.Project.ENTITY.User;

@Service
public class RegistrationServices 
{
	@Autowired
	RegistrationDAO registrationDAO;
	
	public ModelAndView registrationService(User user,HttpServletRequest request) throws IllegalStateException, IOException
	{
		ModelAndView modelAndView = registrationDAO.saveUserInfo(user,request);
		
		return modelAndView;
	}
}
