package com.revature.controllers;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.repository.entities.ReimbursementEntity;
import com.revature.service.LocalDateTimeDeserializer;
import com.revature.service.LocalDateTimeSerializer;
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
	/// may consider sprinting through a table framework for better looks and functions sunday!
	public static ArrayList <ReimbursementEntity> ReimbursementTable; 

	
	public static Handler SubmitReimbursementHandler = (ctx) -> {
		
		ReimbursementService RS = new ReimbursementService();
		GsonBuilder Bob = new GsonBuilder();
		Bob.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
		Bob.serializeNulls();
		Gson gson = Bob.setPrettyPrinting().create();
		
		String SerializedReimb = ctx.body();
		ReimbursementEntity ReimbRepo = gson.fromJson(SerializedReimb, ReimbursementEntity.class);
		RS.submitReimbursement(ReimbRepo);
		System.out.println(ReimbRepo.toString()+"sent");
	
		
		
		ctx.status(202);
		
	
	
	
	
	};
	
	
	
	
	public static Handler GetAllReimbursementsHandler = (ctx) -> {
		ReimbursementService RS = new ReimbursementService();
		Gson gson = new Gson();
		String ReimbursementJson = RS.GetAllReimbursements();  
		gson.toJson(ReimbursementJson);
			ctx.result(ReimbursementJson);
			
			ctx.status(200);
	

				
			
		};

		
		
	
	}


