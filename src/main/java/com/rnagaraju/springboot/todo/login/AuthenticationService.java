package com.rnagaraju.springboot.todo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("todo");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		
		return isValidUserName && isValidPassword;
	}
	
}
