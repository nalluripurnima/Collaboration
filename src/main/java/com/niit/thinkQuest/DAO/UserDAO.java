package com.niit.thinkQuest.DAO;

import java.util.List;

import com.niit.thinkQuest.model.User;

public interface UserDAO {
	
	public void signUp(User user);
	public User verifyMail(User u);
	public List<User> viewUsers();
	public void deactivateUser(int id);
	public void activateUser(int id);
	public void makeAdmin(int id);
	public User get();
	public void save(User user);


}
