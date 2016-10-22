package com.niit.thinkQuest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Blog
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer blogid;
	
	@Size(min = 2, max = 50, message="title")
	private String bname;
		
	@Size(min = 2, max = 50, message="title")
	private String title;
		
	@Size(min = 2, max = 50, message="content")
	private String content;
	
	@Size(min = 2, max = 50, message="status")
	private String status;
	
	@Size(min = 2, max = 50, message="reason")
	private String reason;
	
	@ManyToOne
	private User user;
	
	
	private Date date;
	
	@Transient
	private MultipartFile image;

	public Integer getBlogid() {
		return blogid;
	}

	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	
}