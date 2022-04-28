package com.revature.service;

import com.revature.repository.LoginRepository;
import com.revature.repository.entities.LoginEntity;

import java.util.ArrayList;

import com.revature.DAO.*;
public class LoginService {
	PGDaoClass LDao = new PGDaoClass();
	
	LoginEntity ReturnedUser = new LoginEntity();
	public LoginEntity Login(String username,String password) {
		ReturnedUser = LDao.PostEmpLogin(username, password);
		if(ReturnedUser.getUsername().equals(username)) {
			
			return ReturnedUser;
		}
		else {ReturnedUser = null;}
	
	
		return ReturnedUser;
}
}