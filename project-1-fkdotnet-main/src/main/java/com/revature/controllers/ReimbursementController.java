package com.revature.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.repository.entities.ReimbursementEntity;
import com.revature.service.ReimbursementService;
import java.lang.reflect.Type;
import java.util.Date;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	public static ArrayList <ReimbursementEntity> ReimbursementTable; 

	
	public static Handler SubmitReimbursementHandler = (ctx) -> {
		ReimbursementService RS = new ReimbursementService();
	
	
	
	
	
	};
	
	
	
	
	public static Handler GetAllReimbursementsHandler = (ctx) -> {
		ReimbursementService RS = new ReimbursementService();
		
		String ReimbursementJson = RS.GetAllReimbursements();  
		
			ctx.result(ReimbursementJson);
			
			ctx.status(200);
	

				
			
		};

		
		
	
	}


