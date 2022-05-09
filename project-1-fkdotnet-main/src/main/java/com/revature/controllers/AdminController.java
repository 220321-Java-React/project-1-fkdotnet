package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.repository.ADRepo;
import com.revature.service.AdminService;

import io.javalin.http.Handler;

public class AdminController {

	public static Handler ApproveHandler = (ctx) -> {
		String body = ctx.body();
		AdminService AS = new AdminService();
		Gson gson = new Gson();
		ADRepo AD = gson.fromJson(body,ADRepo.class);
		int result = AS.ApproveService(AD.getReimb_id(), AD.getResolver());
		if(result > 0)
		{
			System.out.println("Reimbursement #" + AD.getReimb_id() + "Approved!");
		}
	};
	
	
	public static Handler DenyHandler = (ctx) -> {
		String body = ctx.body();
		AdminService AS = new AdminService();
		Gson gson = new Gson();
		ADRepo AD = gson.fromJson(body,ADRepo.class);
		int result = AS.DenyService(AD.getReimb_id(),AD.getResolver());
		if(result > 0)
		{
			
			System.out.println("Reimbursement #" + AD.getReimb_id() + "denied");
		
		}
	};
			
			
			
			
			
			
	public static Handler ApproveHandler1 = (ctx) -> {
		String body = ctx.body();
		AdminService AS = new AdminService();
		Gson gson = new Gson();
		ADRepo AD = gson.fromJson(body,ADRepo.class);
		int result = AS.ApproveService(AD.getReimb_id(),AD.getResolver());
		if(result > 0)
		{
			System.out.println("Reimbursement #" + AD.getReimb_id() + "denied");
		}
	
	};
}

		
		
	
