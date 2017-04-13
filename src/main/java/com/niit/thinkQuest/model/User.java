package com.niit.thinkQuest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Table(name="UserDetails")
@Component
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userid;
	
	@NotNull
	@Size(min = 2, max = 50, message="name must have atleat 6 letter")
	private String name;
	
	@NotNull
	@Size(min = 6, max = 14, message="pwd must have atleat 6 letter")
	private String pwd;
	
	@NotNull
	@Size(min = 2, max = 50, message="Mail Id can not be Empty")
	@Email
	private String mail;
	
	@NotNull
	@Size(min = 2, max = 50, message="Address")
	private String address;
	
	@Column
	private String ph;
	
	@Column
	private Integer role;
	
	@Column
	private Date registrationdate;
	
	@Column
	private boolean enabled;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
}
