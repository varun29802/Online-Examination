package com.Project.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Project.ENTITY.Question;

@Repository
public class QuestionDAO 
{
	@Autowired
	SessionFactory factory;
	
	public List<Question> getAllQuestions(String subject)
	{
	
		Session session=factory.openSession();

		
//		 CriteriaBuilder builder = session.getCriteriaBuilder();
		
//		 CriteriaQuery<Question> criteria = builder.createQuery(Question.class);
		 
//		 criteria.from(Question.class);
		 
//		 List<Question> categories = session.createQuery(criteria).getResultList();
		 
		Criteria criteria=session.createCriteria(Question.class);
		
		criteria.add(Restrictions.eq("subject",subject));
	
		return criteria.list();
	}

}
