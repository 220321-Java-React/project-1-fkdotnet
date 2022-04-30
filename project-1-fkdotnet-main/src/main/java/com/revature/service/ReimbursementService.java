package com.revature.service;

import java.util.ArrayList;

import com.revature.DAO.PGDaoClass;
import com.revature.repository.entities.ReimbursementEntity;

public class ReimbursementService {
	PGDaoClass RDao = new PGDaoClass();	

public ArrayList<ReimbursementEntity> GetAllReimbursements() {
	
ArrayList<ReimbursementEntity> ReimbursementTable = RDao.GetReimbursements();
		return ReimbursementTable;

}
}