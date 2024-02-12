package com.Project.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Project.ENTITY.Answer;
import com.Project.ENTITY.Question;
import com.Project.ENTITY.User;

@Controller
public class QuestionController
{
	@RequestMapping("next")
	public ModelAndView next(HttpServletRequest request,Answer answer,User user)
	{
		

		HttpSession httpsession=request.getSession();

		
		if(request.getParameter("submittedAnswer")!=null)
		{
			HashMap<Integer, Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			
			hashmap.put(answer.getQno(), answer);
			
			System.out.println(hashmap);
		}
		
		Question question=null;
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<Question>  listofquestions=(List<Question>) httpsession.getAttribute("questions");
	
		if((Integer)httpsession.getAttribute("qno")<=listofquestions.size()-2)
		{
			httpsession.setAttribute("qno",(Integer)httpsession.getAttribute("qno") + 1);
		
		// 0 1 2   index
		// 1 2 3
		
			question=listofquestions.get((Integer)httpsession.getAttribute("qno"));
				
		}
		
		
		else
		{
			question=listofquestions.get(listofquestions.size()-1);
		

			modelAndView.addObject("message","This Is Last Question");
			
		}
		
		// get previous answer of current question and display it on browser
		
		int qno=question.getQno();
				
		HashMap<Integer,Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
				
		answer=hashmap.get(qno);
				
				
		String previousAnswer="";
				
				
		if(answer!=null)
		{
			previousAnswer=answer.getSubmittedAnswer();
					
		}
		
		
		modelAndView.addObject("question",question);
		
		modelAndView.addObject("previousAnswer",previousAnswer);
		
		
		
		modelAndView.addObject("imagepath",httpsession.getAttribute("imagepath"));
		
		modelAndView.setViewName("question");
		
	
		return modelAndView;
		
	}
	
	@RequestMapping("previous")
	public ModelAndView previous(HttpServletRequest request,Answer answer)
	{
		
		HttpSession httpsession=request.getSession();
		
		if(request.getParameter("submittedAnswer")!=null)
		{
			HashMap<Integer, Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			
			hashmap.put(answer.getQno(), answer);
			
			System.out.println(hashmap);
		}
		
		
		Question question=null;
		
		ModelAndView modelAndView = new ModelAndView();
		
	
		List<Question>  listofquestions=(List<Question>) httpsession.getAttribute("questions");
		
	
		if((Integer)httpsession.getAttribute("qno")>0)
		{
			httpsession.setAttribute("qno",(Integer)httpsession.getAttribute("qno") - 1);//qno=0
		
		// 0 1 2   index
		// 1 2 3
		
			question=listofquestions.get((Integer)httpsession.getAttribute("qno"));
				
		}
		
		
		else
		{
			question=listofquestions.get(0);
			modelAndView.addObject("message","questions over.click on next button");
			
		}

		
		// get previous answer of current question and display it on browser
		
		int qno=question.getQno();
		
		HashMap<Integer,Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		 answer=hashmap.get(qno);
		
		
		String previousAnswer="";
		
		
		if(answer!=null)
		{
			previousAnswer=answer.getSubmittedAnswer();
			
		}
		
		
		modelAndView.addObject("question",question);
		modelAndView.addObject("previousAnswer",previousAnswer);
		
		
		modelAndView.setViewName("question");
		
	
		return modelAndView;
		
	}
	
	@RequestMapping("endexam")
	public ModelAndView endexam(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession httpSession = request.getSession();
		
		
		//data loss chances parent to child conversion
		HashMap<Integer, Answer> hashMap = (HashMap<Integer, Answer>) httpSession.getAttribute("submittedDetails");
		
		if(hashMap==null)
		{
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		Collection<Answer> collection = hashMap.values();
		
		
		for (Answer answer : collection)
		{
			if(answer.getAnswer().equals(answer.getSubmittedAnswer()))
			{
				httpSession.setAttribute("score",(Integer)httpSession.getAttribute("score")+1);
			}
		}
		
		modelAndView.addObject("allanswers",collection);
		modelAndView.addObject("score",httpSession.getAttribute("score"));
		modelAndView.setViewName("score");
		
		httpSession.invalidate();
		
		return modelAndView;
	}
}
