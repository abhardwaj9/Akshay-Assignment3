package com.coderscampus.Assignment3;

public class User {

	private String username;
	private String password;
	private String name;

	// Getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	// Setters
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String username, String password, String name) {

		this.username = username;
		this.password = password;
		this.name = name;

	}

}
