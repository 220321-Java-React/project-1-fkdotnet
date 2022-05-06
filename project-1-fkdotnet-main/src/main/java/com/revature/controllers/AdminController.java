package com.revature.controllers;

import com.revature.service.AdminService;

import io.javalin.http.Handler;

public class AdminController {

	public static Handler ApproveHandler = (ctx) -> {
		AdminService AS = new AdminService();
		String ParamString = ctx.body();
		int paramID = Integer.parseInt(ParamString);
		int resultin = AS.ApproveService(paramID);
		if(resultin > 0) {
			System.out.println("updated!");
			ctx.status(202);
			
		}
		else {
			ctx.status(501);}
		
		
	};
	
	
	public static Handler DenyHandler = (ctx) -> {
		AdminService AS = new AdminService();
		String ParamString = ctx.body();
		int paramID = Integer.parseInt(ParamString);
		int resultin = AS.DenyService(paramID);
		if(resultin > 0) {
			System.out.println("updated!");
			ctx.status(202);
			
		}
		else {
			ctx.status(501);
		}
	};
	

		
		
		
		
	
	
	
}

