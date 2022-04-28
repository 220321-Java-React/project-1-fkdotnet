package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.repository.entities.LoginEntity;

public class PGDaoClass implements PostgreDaoInterface {

	@Override
	public LoginEntity PostEmpLogin(String UserID, String PW) {
		
		String EmpLoginSQL = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
		Optional<Connection> connection = Optional.empty();
		LoginEntity User = new LoginEntity();
		
		
		connection.ifPresent(conn->{
			try { 
				PreparedStatement EMPLoginStmt = conn.prepareStatement(EmpLoginSQL); {
				EMPLoginStmt.setString(1, UserID);
				EMPLoginStmt.setString(2, PW);
				ResultSet EmpLoginResults = EMPLoginStmt.executeQuery();
				
				while(EmpLoginResults.next()) {
					
					int UID = EmpLoginResults.getInt("ers_users_id");
					String UserName = EmpLoginResults.getString("ers_username");
					String dbPW = EmpLoginResults.getString("ers_password");
					String FN = EmpLoginResults.getString("user_first_name");
					String LN = EmpLoginResults.getString("user_last_name");
					String Email = EmpLoginResults.getString("user_email");
					int RoleID = EmpLoginResults.getInt("user_role_id");
					User.setFirstName(FN);
					User.setLastName(LN);
					User.seteMail(Email);
					User.setUsername(UserName);
					User.setPass(dbPW);
					}
				
				}
				
		} catch(SQLException ex) {
			
		}
	
		
					
					
				
			
			
		});
		return User;
		
		
	}

	@Override
	public ArrayList <LoginEntity> PostAdminLogin(String UserID, String PW) {
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
