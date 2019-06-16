package com.otirdamas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Id
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String emailId;
	
	public User() {
		this(null, null, null, null, null);
	}
	
	public User(String username, String password) {
		this(null, null, username, password, null);
	}

	public User(String firstName, String lastName, String username, 
			String password, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
