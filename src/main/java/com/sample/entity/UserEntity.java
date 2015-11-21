package com.sample.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_user")
public class UserEntity implements java.io.Serializable {

	private static final long serialVersionUID = -6255997732752939054L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "autoid")
	private Long autoId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	public UserEntity() {
	}

	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
