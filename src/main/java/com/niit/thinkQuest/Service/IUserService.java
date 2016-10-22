package com.niit.thinkQuest.Service;

import java.util.List;

import com.niit.thinkQuest.model.User;

public interface IUserService {
	
	public void signUp(User user);
	public User verifyMail(User u);
	public List<User> viewUsers();
	public void deactivateUser(int id);
	public void activateUser(int id);
	public void makeAdmin(int id);
    public User get();



}
