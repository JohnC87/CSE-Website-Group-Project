package com.ait.cse;

public class Users {
	private String password, username, type;

	public Users(String password, String username, String type) {
		this.password = password;
		this.username = username;
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

}
