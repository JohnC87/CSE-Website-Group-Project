package com.ait.cse;

public class Manager {
	private String username;
	private int hashedPassword;

	public Manager(String username, String password) {
		this.username = username;
		this.hashedPassword = password.hashCode();
	}

	public String getUsername() {
		return username;
	}

	public int getPassword() {
		return hashedPassword;
	}

	public boolean changePassword(String oldPassword, String newPassword) {
		if (hashedPassword == oldPassword.hashCode()) {
			hashedPassword = newPassword.hashCode();
			return true;
		} else {
			return false;
		}
	}
	
}