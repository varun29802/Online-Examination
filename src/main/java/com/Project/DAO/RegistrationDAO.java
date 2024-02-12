package com.Project.DAO;

import java.io.File;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Project.ENTITY.User;

@Repository
public class RegistrationDAO
{
	@Autowired
	SessionFactory factory;
	
	public ModelAndView saveUserInfo(User user,HttpServletRequest request) throws IllegalStateException, IOException
	{
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
			
		user.setImagepath("/images/" + user.getImage().getOriginalFilename());
			
		session.save(user);
		
		tx.commit();
		
		MultipartFile image=user.getImage();
		
		String foldername=request.getServletContext().getRealPath("/images");
		
		image.transferTo(new File(foldername, image.getOriginalFilename()));
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("login");
		
		modelAndView.addObject("message","registration successful");
	
		return modelAndView;
	}
}
