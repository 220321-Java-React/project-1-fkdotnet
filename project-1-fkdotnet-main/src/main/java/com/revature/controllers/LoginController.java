package com.revature.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.DAO.PGDaoClass;
import com.revature.repository.entities.LoginEntity;
import com.revature.service.UserLoginService;

import io.javalin.http.Handler;

public class LoginController {
static HttpSession ses;


public static Handler EmployeeLoginHandler = (ctx) -> { 
	String body = ctx.body();
	Gson gson = new Gson();
	LoginEntity LDTO = gson.fromJson(body, LoginEntity.class);
	UserLoginService LS = new UserLoginService();

	if(LS.employeeLogin(LDTO.getUsername(),LDTO.getPass()) != null) {
		ses = ctx.req.getSession();
		ctx.status(202);
		
		String employeeJSON = gson.toJson(LS.employeeLogin(LDTO.getUsername(), LDTO.getPass()));
		ctx.result(employeeJSON);
		System.out.println("a user logged in succesfully!");
			

		} else {
	ctx.status(401);
	System.out.println("A user failed at login!");
		}
	 
	
	
	

};
public static Handler AdminLoginHandler = (ctx) -> {
	String body = ctx.body();
	Gson gson = new Gson();
	LoginEntity LDTO = gson.fromJson(body, LoginEntity.class);
	UserLoginService LS = new UserLoginService();
	
	if(LS.AdminLogin(LDTO.getUsername(),LDTO.getPass()) != null) {
		ses = ctx.req.getSession();
		ctx.status(202);
		
		String employeeJSON = gson.toJson(LS.AdminLogin(LDTO.getUsername(), LDTO.getPass()));
		ctx.result(employeeJSON);
		System.out.println("a user logged in succesfully!");
			

		} else {
	ctx.status(401);
	System.out.println("A user failed at login!");
		}
	
	
	
	
	
};
}




