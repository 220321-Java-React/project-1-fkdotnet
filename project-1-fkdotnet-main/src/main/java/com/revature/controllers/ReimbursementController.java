package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.repository.entities.ReimbursementEntity;
import com.revature.service.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	ReimbursementService RS = new ReimbursementService();
	
	
	public static Handler SubmitReimbursementHandler = (ctx) -> {
		
	
	
	
	
	
	};
	
	
	
	
	public static Handler GetAllReimbursementsHandler = (ctx) -> {
		ReimbursementService RS = new ReimbursementService();
		
			ArrayList <ReimbursementEntity> ReimbursementTable = RS.GetAllReimbursements();
			Gson gson = new Gson();
		String TableJson =	gson.toJson(ReimbursementTable);
			ctx.result(TableJson);
			System.out.println("context reached"+TableJson);
			ctx.status(200);
	

				
			
		};
		
	}


