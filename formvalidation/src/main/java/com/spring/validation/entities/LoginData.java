package com.spring.validation.entities;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message="User Name can not be empty")
	@Size(min = 3, max = 12, message = "User Name must be between 3 to 12 character")
	private String userName;
	
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message="email format is not currect")
	private String email;
	
	@AssertTrue(message="must agree terms and conditons")
	private boolean agreed;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
	

}
