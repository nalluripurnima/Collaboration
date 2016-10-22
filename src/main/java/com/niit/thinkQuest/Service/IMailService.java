package com.niit.thinkQuest.Service;

import javax.mail.MessagingException;

import com.niit.thinkQuest.model.User;

public interface IMailService {
	
	public void send(User user,String subject,String body)throws  MessagingException;


}
