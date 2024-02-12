package com.Project.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Project.DAO.QuestionDAO;
import com.Project.ENTITY.Answer;
import com.Project.ENTITY.Question;
import com.Project.ENTITY.User;

@Controller
public class LoginController 
{
	
	
	@Autowired
	QuestionDAO dao;
	
	@Autowired
	SessionFactory factory;
	
	
	@RequestMapping("/")
	public String showLogin()
	{
		return "login";
	}
	
	@RequestMapping("validate")
	public ModelAndView validate(String username,String password,String subject,HttpServletRequest request)
	{
		
		ModelAndView modelAndView = new ModelAndView();
					
		System.out.println(request.getMethod());
		
		System.out.println(username + " " + password);// nikita abc
					
		Session session=factory.openSession();
		
		User userFromDB=session.get(User.class,username);
		
		//userFromDB==> [ username='nikita' password='xyz' emailid='d@jk.com' imagepath=1.jpg ] User class's object having data from database
		
		if(userFromDB==null)
		{
			modelAndView.setViewName("login");
			
			modelAndView.addObject("message","username wrong");
			
		}
		
		else if(password.equals(userFromDB.getPassword()))
		{
			modelAndView.setViewName("question");
			modelAndView.addObject("imagepath",userFromDB.getImagepath());
			
			List<Question> list=dao.getAllQuestions(subject);
			
			Question question=list.get(0);
					

			HttpSession httpsession=request.getSession();

			httpsession.setAttribute("question", question);
			
			httpsession.setAttribute("imagepath", userFromDB.getImagepath());
			
			httpsession.setAttribute("selectedsubject", subject);
			
			httpsession.setAttribute("questions",list);

			httpsession.setAttribute("qno",0);
			
			httpsession.setAttribute("score",0);
			
			
			HashMap<Integer,Answer>  hashmap=new HashMap<Integer, Answer>();
			
			httpsession.setAttribute("submittedDetails",hashmap);
			
			
		}
		
		else
		{
			
			modelAndView.setViewName("login");
			
			modelAndView.addObject("message","password wrong");
		
		}
		
		
		return modelAndView;
		
	}
}
