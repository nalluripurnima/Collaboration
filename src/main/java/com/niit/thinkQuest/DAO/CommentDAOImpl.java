package com.niit.thinkQuest.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.thinkQuest.model.Comment;

@Repository("CommentDAO")
public class CommentDAOImpl implements CommentDAO
{
	private Comment c;
	
	@Autowired(required=true)
	private SessionFactory sf;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addComment(Comment comment)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		comment.setDate(new Date());
		s.saveOrUpdate(comment);
		t.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Comment> viewComment() 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Comment.class);
		List<Comment> l1=(List<Comment>)c.list();
		t.commit();
		return l1;
	}


	
}

