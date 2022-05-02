package com.revature.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;



import com.google.gson.Gson;
import com.revature.DAO.PGDaoClass;
import com.revature.repository.entities.LoginEntity;
import com.revature.service.UserLoginService;

import io.javalin.http.Handler;

public class LoginController {
static HttpSession ses;


public static Handler EmployeeLoginHandler = (ctx) -> { 
	Map<String,Object> EmployeeModel = new HashMap<>();
	
	String body = ctx.body();
	Gson gson = new Gson();
	
	LoginEntity LoginRepo = gson.fromJson(body, LoginEntity.class);
	
	
	
	
	UserLoginService LS = new UserLoginService();

	if(LS.employeeLogin(LoginRepo.getUsername(),LoginRepo.getPass())!= null) {
		LoginEntity LDTO = LS.employeeLogin(LoginRepo.getUsername(),LoginRepo.getPass());
		ctx.sessionAttribute("ers_username",LDTO.getUsername());
		ctx.sessionAttribute("user_first_name",LDTO.getFirstName());
		ctx.sessionAttribute("ers_users_id",LDTO.getusers_id());
		
		int ersUser = ctx.sessionAttribute("ers_users_id");
		System.out.println(ersUser);
		System.out.println(LDTO.toString());
		
		ctx.status(202);
		
		
		String employeeJSON = gson.toJson(LS.employeeLogin(LDTO.getUsername(), LDTO.getPass()));
		System.out.println(employeeJSON);
		ctx.result(employeeJSON);
		
		System.out.println(employeeJSON);
			

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
	Map<String,Object> ManagerModel = new HashMap<String,Object>();
	ManagerModel.put("ers_users_id", LDTO.getusers_id());
	ManagerModel.put("ers_username", LDTO.getUsername());
	ManagerModel.put("user_first_name", LDTO.getFirstName());
	
	if(LS.AdminLogin(LDTO.getUsername(),LDTO.getPass()) != null) {
	
		
		ctx.status(202);
		
		String employeeJSON = gson.toJson(LS.AdminLogin(LDTO.getUsername(), LDTO.getPass()));
		ctx.result(employeeJSON);
		System.out.println("a user logged in succesfully!");
			

		} else {
	ctx.status(401);
	System.out.println("A user failed at login!");
		}
};

public static Handler UserRenderHandler = (ctx) -> {
	Gson gson = new Gson();
	Map <String, Object> RenderedUser = new HashMap<>(); 
	RenderedUser.put("ers_user_id",ctx.sessionAttribute("ers_user_id"));
	RenderedUser.put("user_first_name",ctx.sessionAttribute("user_first_name"));
	RenderedUser.put("ers_username", ctx.sessionAttribute("ers_username"));
	
	String JsonRenderedUser = gson.toJson(RenderedUser);
	ctx.result(JsonRenderedUser);
	
};

	

}; 
	

