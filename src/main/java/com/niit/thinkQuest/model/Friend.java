package com.niit.thinkQuest.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Friend  implements Serializable{
    
	
	private Integer frndId;
	
	@ManyToOne
	private User user;

	public Integer getFrndId() {
		return frndId;
	}

	public void setFrndId(Integer frndId) {
		this.frndId = frndId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
