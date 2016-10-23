package com.niit.thinkQuest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.thinkQuest.model.Friend;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;

@Repository("FriendDAO")
public class FriendDAOImpl implements FriendDAO {
	
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<UserFriend> viewAllFriends() {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(UserFriend.class);
		List<UserFriend> f=(List<UserFriend>)c.list();
		t.commit();
		return f;
	}
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addFriend(User user, Integer frndId) {
		Session s=sf.getCurrentSession();
    	Transaction t=s.beginTransaction();
    	System.out.println(user.getName());
    	UserFriend userFriends=new UserFriend();
    	userFriends.setStatus("Requested");
    	Friend friend=new Friend();
    	friend.setUser(user);
    	friend.setFrndId(frndId);
    	userFriends.setFriend(friend);
		s.save(userFriends);
		t.commit();
		
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public void updateFriend(int reqId) {
    	Session s=sf.openSession();
    	Transaction t=s.beginTransaction();
    	Criteria c=sf.getCurrentSession().createCriteria(UserFriend.class);
    	c.add(Restrictions.eq("reqId", reqId));
    	UserFriend f=(UserFriend)c.uniqueResult();
    	f.setStatus("Accepted");
    	s.update(f);
    	t.commit();

    }
    
    @Transactional(propagation=Propagation.SUPPORTS)
	public List<UserFriend> viewAllRequest(int frndId) {
    	Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(UserFriend.class);
		c.add(Restrictions.eq("status","Requested"));
		List<UserFriend> f=(List<UserFriend>)c.list();
		t.commit();
		return f;
	}
    
    //chat purpose
  	@Transactional(propagation=Propagation.SUPPORTS)
  	public User retriveFriend(int frndId) {
  		Session s=sf.getCurrentSession();
  		Transaction t=s.beginTransaction();
  		Criteria c=sf.getCurrentSession().createCriteria(User.class);
  		c.add(Restrictions.eq("userid", frndId));
  		User u=(User)c.uniqueResult();
  		t.commit();
  		return u;
  	}

}			

