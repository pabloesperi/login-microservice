package com.login.microservice.models;

import java.io.Serializable;

public class Usr implements Serializable{
	
	private static final long serialVersionUID = 6982694306984828349L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
