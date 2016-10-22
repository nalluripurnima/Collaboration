package com.niit.thinkQuest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Forum 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer forumid;
		
	@NotNull
	@Size(min = 2, max = 50, message="fname")
	private String fname;
		
	@NotNull
	@Size(min = 2, max = 50, message="fdesc")
	private String fdesc;

	@NotNull
	@Size(min = 2, max = 50, message="fauthor")
	private String fauthor;
	
	@NotNull
	private Date date;
	
	@ManyToOne
	private User user;

	public Integer getForumid() {
		return forumid;
	}

	public void setForumid(Integer forumid) {
		this.forumid = forumid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

	public String getFauthor() {
		return fauthor;
	}

	public void setFauthor(String fauthor) {
		this.fauthor = fauthor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
	
	
}
