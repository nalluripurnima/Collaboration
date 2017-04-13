package com.niit.thinkQuest.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserRole;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sf;
	
	 User user;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void signUp(User user)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		user.setRegistrationdate(new Date());
		s.saveOrUpdate(user);
		UserRole r=new UserRole();
		r.setUser_role_id(user.getUserid());
		r.setAuthority("ROLE_USER");
		s.saveOrUpdate(r);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public User verifyMail(User u)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(User.class);
		c.add(Restrictions.eq("mail",u.getMail()));
		c.add(Restrictions.eq("pwd",u.getPwd()));
		user=(User) c.uniqueResult();
		System.out.println(user.getName());
		t.commit();
		return user;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> viewUsers() 
	{
		
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(User.class);
		List<User> l1=(List<User>)c.list();
		t.commit();
		return l1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void deactivateUser(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Object o=s.load(User.class, new Integer(id));
		User user=(User)o;
		user.setEnabled(false);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void activateUser(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Object o=s.load(User.class, new Integer(id));
		User user=(User)o;
		user.setEnabled(true);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void makeAdmin(int id)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Object o=s.load(User.class, new Integer(id));
		UserRole user=(UserRole)o;
		user.setAuthority("ROLE_ADMIN");
		t.commit();
	}
	
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public User get() {
		return user;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void save(User user) {
		
		
	}
	 

}