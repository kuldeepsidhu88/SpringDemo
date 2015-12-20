package com.demo.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {

	@Size(min=3,max=50,message="Fullname must be between 3 and 50 characters long.")
	private String fullName;
	
	@Size(min=3,max=20,message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alpha numeric without spaces")
	private String username;
	
	@Size(min=3,max=20,message="Password must be between 3 and 20 characters long.")
	private String password;
	
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",message="Invalid email address.")
	private String email;
	
	private String profileImageUrl;
	
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	private boolean updateByEmail;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getUpdateByEmail() {
		return updateByEmail;
	}
	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}
	
	
}
