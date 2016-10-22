package com.niit.thinkQuest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.UserDAO;
import com.niit.thinkQuest.model.User;

@Service
public class UserService implements IUserService 
{
	@Autowired(required=true)
	private UserDAO ud; 
	
	public void signUp(User user) 
	{
		ud.signUp(user);		
	}

	public User verifyMail(User u) 
	{
		return ud.verifyMail(u);
	}

	public List<User> viewUsers() 
	{
		return ud.viewUsers();
	}

	public void deactivateUser(int id)
	{
		ud.deactivateUser(id);
	}

	public void activateUser(int id)
	{
		ud.activateUser(id);
	}

	public void makeAdmin(int id) 
	{
		ud.makeAdmin(id);
	}
    public User get() {
		
		return ud.get();
	}


}

