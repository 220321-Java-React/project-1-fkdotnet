package com.revature.repository;


import com.revature.repository.entities.LoginEntity;
	

	public class LoginRepository {
		// This is the DAO layer
		// We would have CRUD Methods
		// I will fake the Read method, this should made with JDBC
		public LoginEntity getLogin(String username) {
			// As I am not implementing JDBC, I will fake a successful return
			
			if(username.equals("user1")) {
				return new LoginEntity(1, "user1", "pass1");
			}else {
				return null;
			}
		}
	}

