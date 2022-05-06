package com.revature.service;

import com.revature.DAO.PGDaoClass;

public class AdminService {
	PGDaoClass pgDao = new PGDaoClass();

	public int ApproveService(int ReimbID) {
		int status;
		status = pgDao.ApproveReimbursement(ReimbID);

		return status;

	}

	public int DenyService(int ReimbID) {
		int status;
		status = pgDao.DenyReimbursement(ReimbID);

		return status;

	}

}
