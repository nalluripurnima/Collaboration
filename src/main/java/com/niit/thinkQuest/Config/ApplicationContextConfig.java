package com.niit.thinkQuest.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.thinkQuest.model.Blog;
import com.niit.thinkQuest.model.Chat;
import com.niit.thinkQuest.model.Comment;
import com.niit.thinkQuest.model.Event;
import com.niit.thinkQuest.model.Forum;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;
import com.niit.thinkQuest.model.UserRole;

@Configuration
@ComponentScan("com.niit.thinkQuest")
@EnableTransactionManagement
public class ApplicationContextConfig 
{
	@Bean(name = "dataSource")
	public DataSource getdataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/thinkQuest");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
    
    private Properties getHibernateProperties()
    {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	//properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)
    {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Blog.class);
    	sessionBuilder.addAnnotatedClasses(Chat.class);
    	sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(Event.class);
    	sessionBuilder.addAnnotatedClasses(Comment.class);
    	sessionBuilder.addAnnotatedClasses(Forum.class);
    	//sessionBuilder.addAnnotatedClasses(Friend.class);
    	sessionBuilder.addAnnotatedClasses(UserFriend.class);
    	sessionBuilder.addAnnotatedClasses(UserRole.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="javaMailSender")
	public JavaMailSender javaMailService() {
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
			
		Properties mailProperties = new Properties();
        
        mailProperties.put("mail.smtp.host", "smtp.gmail.com");
        mailProperties.put("mail.smtp.auth","true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        mailProperties.put("mail.smtp.port", "587");
        mailProperties.setProperty("mail.debug", "true");
        
	        javaMailSender.setJavaMailProperties(mailProperties);
	        javaMailSender.setHost("smtp.gmail.com");
	        javaMailSender.setPort(587);
	        javaMailSender.setProtocol("smtp");
	        javaMailSender.setUsername("nalluri.purnima@gmail.com");
	        javaMailSender.setPassword("p******d");
	        
	        return javaMailSender;
	    }

}