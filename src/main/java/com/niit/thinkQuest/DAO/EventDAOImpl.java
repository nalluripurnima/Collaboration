package com.niit.thinkQuest.DAO;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.thinkQuest.model.Event;

@Repository("EventDAO")
public class EventDAOImpl implements EventDAO
{
	private Event e;
	
	@Autowired(required=true)
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addEvent(Event event) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("add event");
		event.setDate(new Date());
		event.setCreationdate(new Date());
		s.saveOrUpdate(event);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean deleteEvent(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("delete event");
		Event e1=(Event)s.load(Event.class, id);
		s.delete(e1);
		t.commit();
		if(e1!=null)
			return true;
		else
			return false;
	}

	
}
