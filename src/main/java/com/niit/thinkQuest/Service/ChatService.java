package com.niit.thinkQuest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.ChatDAO;
import com.niit.thinkQuest.model.Chat;

@Service
public class ChatService implements IChatService{
	
	@Autowired(required=true)
	private ChatDAO c;
	
	public void addChat(Chat chat)
	{
		 c.addChat(chat);
	}

	public List<Chat> viewChat(Integer fromUser,Integer toUser) {
		System.out.println("qwerty"+c.viewChat(fromUser, toUser));
		return c.viewChat(fromUser, toUser);
	}

}
