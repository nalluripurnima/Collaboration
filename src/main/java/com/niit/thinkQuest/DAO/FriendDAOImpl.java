package com.niit.thinkQuest.DAO;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
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
	public List<UserFriend> viewAllFriends(User u) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(UserFriend.class);
		c.add(Restrictions.disjunction()
				.add(Restrictions.eq("friend.userFriend.userid",u.getUserid()))
				.add(Restrictions.eq("friend.user.userid",u.getUserid())));
		c.add(Restrictions.eq("status", "Accepted"));
		List<UserFriend> f=(List<UserFriend>)c.list();
		System.out.println(u.getUserid()+" "+c.list().size());
		t.commit();
		return f;
	}
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addFriend(User user, Integer fndid) {
    	System.out.println("add friend DAO");
		Session s=sf.getCurrentSession();
    	System.out.println("Transactio started");
    	System.out.println(user.getName());
    	UserFriend userFriend=new UserFriend();
    	System.out.println("poppy");
    	userFriend.setStatus("Requested");
    	Friend friend=new Friend();
    	System.out.println("frdzzzz");
    	friend.setUser(user);
    	User frnd=retriveFriend(fndid);
    	friend.setUserFriend(frnd);
    	System.out.println("fnd");
    	userFriend.setFriend(friend);
    	Query query = s.createSQLQuery("SELECT * FROM userFRIEND where USER_UserID ="+user.getUserid()+" and USERFRIEND_UserID ="+fndid)
				.addEntity(UserFriend.class);
				List result = query.list();
				System.out.println(result.size());
    	Transaction t=s.beginTransaction();
    	if(result.size()<1){
    		s.save(userFriend);
    	}
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
	public List<UserFriend> viewAllRequest(int fndid) {
    	Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(UserFriend.class);
		c.add(Restrictions.eq("friend.userFriend.userid",fndid));
		System.out.println("sumiksha");
		c.add(Restrictions.eq("status","Requested"));
		List<UserFriend> f=(List<UserFriend>)c.list();
		System.out.println("bh");
		t.commit();
		return f;
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public User retriveFriend(int fndid) 
	{
    	Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("friend retrived");
		Criteria c=sf.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("userid", fndid));
		User u=(User)c.uniqueResult();
		t.commit();
		return u;
	
	}
}			
	
   /* 
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

}			*/

