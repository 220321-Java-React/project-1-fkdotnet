package com.revature.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.DAO.PGDaoClass;
import com.revature.repository.entities.ReimbursementEntity;

public class ReimbursementService {
	PGDaoClass RDao = new PGDaoClass();	
	LocalDateTimeSerializer LDTS = new LocalDateTimeSerializer();

	
	
	
	
public String GetAllReimbursements() {
	
ArrayList<ReimbursementEntity> ReimbursementTable = RDao.GetReimbursements();
GsonBuilder Bob = new GsonBuilder();
Bob.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
Bob.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
Bob.serializeNulls();
Gson gson = Bob.setPrettyPrinting().create();


String ReimbursementJSON = gson.toJson(ReimbursementTable);	

return ReimbursementJSON;
		

}
public ReimbursementEntity submitReimbursement(ReimbursementEntity Submitted) {
	
	ReimbursementEntity ReturnedReimb = RDao.PostAddReimbursementRequest(Submitted);
	
	
	
	
	
	
	
	
	return ReturnedReimb;
	
}



}