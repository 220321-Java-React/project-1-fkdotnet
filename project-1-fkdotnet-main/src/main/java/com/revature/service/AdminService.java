package com.revature.service;

import com.revature.DAO.PGDaoClass;

public class AdminService {
	PGDaoClass pgDao = new PGDaoClass();

	public int ApproveService(int ReimbID, int Author) {
		int status;
		status = pgDao.ApproveReimbursement(ReimbID, Author);

		return status;

	}

	public int DenyService(int ReimbID, int Author) {
		int status;
		status = pgDao.DenyReimbursement(ReimbID, Author);

		return status;

	}

}
