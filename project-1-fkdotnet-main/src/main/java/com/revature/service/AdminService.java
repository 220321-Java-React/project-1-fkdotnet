package com.revature.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.PGDaoClass;
import com.revature.controllers.HelloExample;

public class AdminService {
	PGDaoClass pgDao = new PGDaoClass();
	Logger log = LogManager.getLogger(AdminService.class);


	public int ApproveService(int ReimbID, int Author) {
		int status;
		status = pgDao.ApproveReimbursement(ReimbID, Author);
		log.info("Successfully sent approval to dao for ID #" + ReimbID);
		return status;

	}

	public int DenyService(int ReimbID, int Author) {
		int status;
		status = pgDao.DenyReimbursement(ReimbID, Author);
		log.info("Successfully sent approval to dao ID #" + ReimbID);
		return status;

	}

}
