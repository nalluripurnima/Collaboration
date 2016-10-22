package com.niit.thinkQuest.Service;

import java.util.List;

import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;

public interface IFriendService {
	
	public void addFriend(User Uid,Integer frndId);
	public void updateFriend(int reqId);
	public List<UserFriend> viewAllFriends();
    public List<UserFriend>viewAllRequest(int frndId);
	public User retriveFriend(int frdid);

}