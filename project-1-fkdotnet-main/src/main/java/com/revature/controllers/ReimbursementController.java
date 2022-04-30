package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.repository.entities.ReimbursementEntity;
import com.revature.service.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	public static ArrayList <ReimbursementEntity> ReimbursementTable; 

	
	public static Handler SubmitReimbursementHandler = (ctx) -> {
		
	
	
	
	
	
	};
	
	
	
	
	public static Handler GetAllReimbursementsHandler = (ctx) -> {
		ReimbursementService RS = new ReimbursementService();
		Gson gson = new Gson();
		ArrayList<ReimbursementEntity> ReimbursementTable = RS.GetAllReimbursements();  
		String TableJson = gson.toJson(ReimbursementTable);
			ctx.result(TableJson);
			
			ctx.status(200);
	

				
			
		};
		
	}


