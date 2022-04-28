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
		String ReturnedPW = ReturnedUser.getPass();
		if(ReturnedPW!=null && ReturnedPW.equals(password)) {
			System.out.println("Login Succeeded!");
			return ReturnedUser;
		}
		else {ReturnedUser = null;}
		return ReturnedUser;
		
}
}