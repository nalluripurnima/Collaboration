package com.niit.thinkQuest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.EventDAO;
import com.niit.thinkQuest.model.Event;

@Service
public class EventService implements IEventService
{
	@Autowired(required=true)
	private EventDAO e;
	
	public void addEvent(Event event) 
	{
		e.addEvent(event);
	}

	public boolean deleteEvent(int id) 
	{
		return e.deleteEvent(id);
	}

	
}

