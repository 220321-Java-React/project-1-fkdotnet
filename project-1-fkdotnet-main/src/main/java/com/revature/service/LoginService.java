/*package com.revature.service;

import com.revature.repository.LoginRepository;

public class LoginService {
	// I will be hard coding in the Username and Password
	// You will need to implement the DB aspect using your JDBC and Repo
	
	// We use the Service to implement business logic
	// This includes any processing, validation, reformatting
	
	private LoginRepository loginRepository;
	
	public LoginService() {
		this.loginRepository = new LoginRepository();
	}
	
	public boolean loginValidation(String username, String password) {
		if(loginRepository.getLogin(username).getPass().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
}
*/