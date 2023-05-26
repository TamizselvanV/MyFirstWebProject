package com.in28minutes.springbootproject.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticateUser(String userName, String password) {
		
		boolean isValidUserName = userName.equalsIgnoreCase("Tamiz");
		boolean isValidPassword = password.equalsIgnoreCase("123");
		
		return isValidPassword && isValidUserName;		
	}
}
