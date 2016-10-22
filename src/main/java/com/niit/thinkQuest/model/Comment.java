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
public class Comment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	
	@NotNull
	@Size(min = 2, max = 50, message="comment name")
	private String cname;
	
	@NotNull
	@Size(min = 2, max = 50, message="comment description")
	private String cdesc;
	
	@ManyToOne
	private User user;
	
	
	private Date date;


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCdesc() {
		return cdesc;
	}


	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	
	}
