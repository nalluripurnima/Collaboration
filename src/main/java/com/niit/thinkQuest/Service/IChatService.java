package com.niit.thinkQuest.Service;

import java.util.List;

import com.niit.thinkQuest.model.Chat;

public interface IChatService {

	public void addChat(Chat chat);
	public List<Chat> viewChat(Integer fromUser,Integer toUser);
}
