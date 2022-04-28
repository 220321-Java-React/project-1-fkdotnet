package com.revature.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.google.gson.Gson;
import com.revature.DAO.PGDaoClass;
import com.revature.repository.entities.LoginEntity;
import com.revature.service.LoginService;

import io.javalin.http.Handler;

public class LoginController {



public static Handler LoginHandler = (ctx) -> { 
	String body = ctx.body();
	Gson gson = new Gson();
	LoginEntity LDTO = gson.fromJson(body, LoginEntity.class);
	LoginService LS = new LoginService();

	if(LS.Login(LDTO.getUsername(),LDTO.getPass()) != null) {
		ctx.req.getSession();
		ctx.status(202);
		
		String employeeJSON = gson.toJson(LS.Login(LDTO.getUsername(), LDTO.getPass()));
		ctx.result(employeeJSON);
		System.out.println("a user logged in succesfully!");
			

		} else {
	ctx.status(401);
	System.out.println("A user failed at login!");
		}
	 
	
	
	

};
}




