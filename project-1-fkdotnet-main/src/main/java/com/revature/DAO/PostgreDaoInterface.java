package com.revature.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.repository.entities.LoginEntity;
import com.revature.repository.entities.ReimbursementEntity;

public interface PostgreDaoInterface {
	LoginEntity PostEmpLogin(String UserID,String PW);
	LoginEntity PostAdminLogin(String UserID,String PW);
	ArrayList <LoginEntity> GetAllEmployees();
	ReimbursementEntity PostAddReimbursementRequest();
	ArrayList<ReimbursementEntity> GetReimbursements();
	ArrayList<ReimbursementEntity> getPendingReimbursements();
	void ApproveReimbursement(int ReimbursementID);
	void DenyReimbursement(int ReimbursementID);

}
