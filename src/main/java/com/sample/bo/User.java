package com.sample.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private Long autoId;
	private String userName;
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
}
