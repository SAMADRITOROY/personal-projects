package com.otirdamas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="USER")
@SequenceGenerator(name="seqGen", initialValue=2, allocationSize=100)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqGen")
	@Column(name="ID")
	private long id;
	
	@NotBlank
	@Column(name="FIRSTNAME")
	private String firstName;

	@NotBlank
	@Column(name="LASTNAME")
	private String lastName;
	
	@NotBlank
	@Column(name="USERNAME")
	private String username;
	
	@NotBlank
	@Column(name="PASSWORD")
	private String password;
	
	@NotBlank
	@Column(name="EMAILID")
	private String emailId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
