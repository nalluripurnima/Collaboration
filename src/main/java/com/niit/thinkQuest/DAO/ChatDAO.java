package com.niit.thinkQuest.DAO;

import java.util.List;

import com.niit.thinkQuest.model.Chat;

public interface ChatDAO {
	
	public void addChat(Chat chat);
	public List<Chat> viewChat(String fromUser,String toUser);
 
	
	}
