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

import com.niit.thinkQuest.model.Chat;

@Repository("ChattDAO")
public class ChatDAOImpl implements ChatDAO {
	
	@Autowired(required=true)
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addChat(Chat chat)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		chat.setDate(new Date());
		System.out.println("store");
		s.saveOrUpdate(chat);
		t.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Chat> viewChat(String fromUser,String toUser){
		
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Chat.class);
		List<Chat> msgs=(List<Chat>)c.list();
		c.add(Restrictions.eq("fromUser", fromUser));
		c.add(Restrictions.eq("toUser", toUser));
		t.commit();
		return msgs;
		
	}
	
	

}
