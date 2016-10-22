package com.niit.thinkQuest.DAO;

import com.niit.thinkQuest.model.Event;

public interface EventDAO {
	
	public void addEvent(Event event);
	public boolean deleteEvent(int id);
	


}
