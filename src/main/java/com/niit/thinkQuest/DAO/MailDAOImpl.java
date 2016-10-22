package com.niit.thinkQuest.DAO;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.niit.thinkQuest.model.User;

@Repository("MailDAO")
public class MailDAOImpl implements MailDAO
{

	public static final String REPLY_TO_ADDRESS="support@thinkQuest.com";
	public static final String FROM_ADDRESS="wecare@thinkQuest.com";
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(User user,String subject,String body) throws MessagingException 
	{
		//javaMailSender =new JavaMailSenderImpl();
		System.out.println("Inside mail");
		MimeMessage mail=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mail,true);
		System.out.println("sending");
		helper.setTo(user.getMail());
		helper.setReplyTo(REPLY_TO_ADDRESS);
		helper.setFrom(FROM_ADDRESS);
		helper.setSubject(subject);
		helper.setText(body);
		helper.setText(body);
		helper.addBcc("nalluri.purnima@gmail.com");
		javaMailSender.send(mail);
	}

}

