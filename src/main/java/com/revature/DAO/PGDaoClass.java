package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.repository.entities.LoginEntity;

public class PGDaoClass implements PostgreDaoInterface {

	@Override
	public LoginEntity PostEmpLogin(String UserID, String PW) {
		String EmpLoginSQL = "SELECT FROM ers_users WHERE ers_username = ? AND ers_password = ?";
		Optional<Connection> connection = Optional.empty();
		connection.ifPresent(conn->{
			try { 
				PreparedStatement EMPLoginStmt = conn.prepareStatement(EmpLoginSQL); {
				EMPLoginStmt.setString(1, UserID);
				EMPLoginStmt.setString(2, PW);
				ResultSet EmpLoginResults = EMPLoginStmt.executeQuery();
				
				//parse results here
		}	
		} catch(SQLException ex) {
			
		}
	
		
					
					
				
			
			
		});
		return null;
		
		
	}

	@Override
	public LoginEntity PostAdminLogin(String UserID, String PW) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LoginEntity> GetAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Integer> PostAddReimbursementRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Gson> GetReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPendingReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ApproveReimbursement(int ReimbursementID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DenyReimbursement(int ReimbursementID) {
		// TODO Auto-generated method stub
		
	}

}
