package com.revature.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
	Map<String,Object> EmployeeModel = new HashMap<>();
	
	String body = ctx.body();
	Gson gson = new Gson();
	LoginEntity LDTO = gson.fromJson(body, LoginEntity.class);
	EmployeeModel.put("reimb_author", LDTO.getusers_id());
	EmployeeModel.put("ers_username", LDTO.getUsername());
	EmployeeModel.put("user_first_name", LDTO.getFirstName());
	
	UserLoginService LS = new UserLoginService();

	if(LS.employeeLogin(LDTO.getUsername(),LDTO.getPass()) != null) {
		ses = ctx.req.getSession();
		ses.setAttribute("currentUserName", EmployeeModel.get("ers_username"));
		ses.setAttribute("userFirstName", EmployeeModel.get("user_first_name"));
		ses.setAttribute("reimbAuthor", EmployeeModel.get("reimb_author"));
		ctx.status(202);
		System.out.println(ses.getAttribute("currentUserName") + " is logged in!");
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
	Map<String,Object> ManagerModel = new HashMap<String,Object>();
	ManagerModel.put("reimb_author", LDTO.getusers_id());
	ManagerModel.put("ers_username", LDTO.getUsername());
	ManagerModel.put("user_first_name", LDTO.getFirstName());
	
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

public static Handler UserRenderHandler = (ctx) -> {
	
	
	
	
			
	ctx.status(200);



}; 
	
	
	
	
}





