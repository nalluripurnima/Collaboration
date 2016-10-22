package com.niit.thinkQuest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.FriendDAO;
import com.niit.thinkQuest.model.Friend;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;


@Service
public class FriendService implements IFriendService {

	@Autowired(required=true)
	private FriendDAO fn;
	
	public void addFriend(User Uid, Integer frndId) {
		
		fn.addFriend(Uid,frndId);
		}

	public void updateFriend(int reqId) {
		fn.updateFriend(reqId);
		
	}

	public List<UserFriend> viewAllFriends() {
		
		return fn.viewAllFriends();
	}

	public List<UserFriend> viewAllRequest(int frndId) {
		return fn.viewAllRequest(frndId);
	}
	public User retriveFriend(int frdid) {
		return fn.retriveFriend(frdid);		
	}

	
	

}

