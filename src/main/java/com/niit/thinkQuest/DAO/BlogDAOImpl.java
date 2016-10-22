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

import com.niit.thinkQuest.model.Blog;

@Repository("BlogDAO")
public class BlogDAOImpl implements BolgDAO
{
		
	@Autowired 
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addBlog(Blog blog)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("add blog");
		blog.setDate(new Date());
		s.saveOrUpdate(blog);
		t.commit();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Blog> viewBlog() 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("view my blog");
		Criteria c=sf.getCurrentSession().createCriteria(Blog.class);
		System.out.println("creating my blog");
		List<Blog> l1=(List<Blog>)c.list();
		t.commit();
		return l1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean deleteBlog(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("delete my blog here");
		Blog b1=(Blog)s.load(Blog.class, id);
		s.delete(b1);
		t.commit();
		if(b1!=null)
			return true;
		else 
			return false;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateBlog(Blog blog) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("update my blog");
		s.update(blog);
		t.commit();
	}
}