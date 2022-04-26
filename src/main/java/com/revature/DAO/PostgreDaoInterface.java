package com.revature.DAO;

import java.util.ArrayList;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.repository.entities.LoginEntity;

public interface PostgreDaoInterface {
	LoginEntity PostEmpLogin(String UserID,String PW);
	LoginEntity PostAdminLogin(String UserID,String PW);
	
	ArrayList <LoginEntity> GetAllEmployees();
	Optional<Integer> PostAddReimbursementRequest();
	ArrayList<Gson> GetReimbursements();
	ArrayList<String> getPendingReimbursements();
	void ApproveReimbursement(int ReimbursementID);
	void DenyReimbursement(int ReimbursementID);

}
