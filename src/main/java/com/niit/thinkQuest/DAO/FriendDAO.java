package com.niit.thinkQuest.DAO;

import java.util.List;

import com.niit.thinkQuest.model.Friend;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;

public interface FriendDAO {
	
	public void addFriend(User Uid,Integer frndId);
	public void updateFriend(int reqId);
	public List<UserFriend> viewAllFriends();
	   public List<UserFriend>viewAllRequest(int frndId);
	   public User retriveFriend(int frdid);



}
