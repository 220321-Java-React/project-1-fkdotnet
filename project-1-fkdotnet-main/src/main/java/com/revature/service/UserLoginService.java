package com.revature.service;

import com.revature.repository.LoginRepository;
import com.revature.repository.entities.LoginEntity;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Launcher;
import com.revature.DAO.*;

public class UserLoginService {
	PGDaoClass LDao = new PGDaoClass();
	Logger log = LogManager.getLogger(UserLoginService.class);

	LoginEntity ReturnedUser = new LoginEntity();

	public LoginEntity employeeLogin(String username,String password) {
		ReturnedUser = LDao.PostEmpLogin(username, password);
		String ReturnedPW = ReturnedUser.getPass();
		if(ReturnedPW!=null && ReturnedPW.equals(password)) {
			System.out.println("Login Succeeded!");
			log.info(ReturnedUser +"logged in");
			return ReturnedUser;
		}
		else {ReturnedUser = null;}
		return ReturnedUser;
		
}
	public LoginEntity AdminLogin(String username, String password) {
		ReturnedUser = LDao.PostAdminLogin(username, password);
		String ReturnedPW = ReturnedUser.getPass();
		if(ReturnedPW!=null && ReturnedPW.equals(password)) {
			System.out.println("Login Succeeded!");
			log.info(ReturnedUser +"logged in");

			return ReturnedUser;
		}
		else {ReturnedUser = null;}
		return ReturnedUser;
		
		
		
		
		
	}
	
	
}