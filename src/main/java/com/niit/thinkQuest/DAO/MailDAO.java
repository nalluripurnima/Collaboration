package com.niit.thinkQuest.DAO;

import javax.mail.MessagingException;

import com.niit.thinkQuest.model.User;

public interface MailDAO {
	
	public void send(User user,String subject,String body)throws MessagingException;

}
