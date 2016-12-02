package com.niit.thinkQuest.DAO;

import java.util.List;

import com.niit.thinkQuest.model.Friend;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;

public interface FriendDAO {
	
	public void addFriend(User Uid,Integer fndid);
	public void updateFriend(int fndid);
	public List<UserFriend> viewAllFriends(User u);
	public List <UserFriend> viewAllRequest(int fndid);
	public User retriveFriend(int fndid);






}
