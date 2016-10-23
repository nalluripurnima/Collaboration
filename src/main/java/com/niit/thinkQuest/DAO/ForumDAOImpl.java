package com.niit.thinkQuest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.thinkQuest.model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO
{
	private Forum f;
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addQuestion(Forum question) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(question);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Forum> viewForum()
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Forum.class);
		List<Forum> l1=(List<Forum>)c.list();
		t.commit();
		return l1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean deleteQuestion(int id)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Forum f1=(Forum)s.load(Forum.class, id);
		s.delete(f1);
		t.commit();
		if(f1!=null)
			return true;
		else
			return false;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Forum getQuestion(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Object o=s.get(Forum.class,new Integer(id));
		Forum q=(Forum)o;
		return q;
	}
}