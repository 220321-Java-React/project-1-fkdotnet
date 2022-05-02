package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.repository.entities.LoginEntity;
import com.revature.repository.entities.ReimbursementEntity;

public class PGDaoClass implements PostgreDaoInterface {

	@Override
	public LoginEntity PostEmpLogin(String UserID, String PW) {
		
		String EmpLoginSQL = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
		
		LoginEntity User = new LoginEntity();
		
		
		
		
			try { 
				 Connection conn = ConnectionFactory.getConnection();

				PreparedStatement EMPLoginStmt = conn.prepareStatement(EmpLoginSQL); {
				EMPLoginStmt.setString(1, UserID);
				EMPLoginStmt.setString(2, PW);
				ResultSet EmpLoginResults = EMPLoginStmt.executeQuery();
				
				while(EmpLoginResults.next()) {
					System.out.println("in the loop");
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
					User.setuser_id(UID);
					System.out.println(User.toString());
					}
				
				}
				
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	
		
					
					
				
			
			
		
		return User;
		
		
	}

	@Override
	public LoginEntity PostAdminLogin(String UserID, String PW) {
		
		LoginEntity User = new LoginEntity();
		 Connection conn = ConnectionFactory.getConnection();
		 String AdminLoginSQL = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ? AND user_role_id = 2";
			PreparedStatement EMPLoginStmt;
			try {
				EMPLoginStmt = conn.prepareStatement(AdminLoginSQL);
				EMPLoginStmt.setString(1, UserID);
				EMPLoginStmt.setString(2, PW);
				ResultSet EmpLoginResults = EMPLoginStmt.executeQuery();
				
				while(EmpLoginResults.next()) {
					System.out.println("in the loop");
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
					User.setuser_id(UID);
			
					
					System.out.println(User.toString());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} { 
					}
				return User;
	}
	
	@Override
	public ArrayList <LoginEntity> GetAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementEntity PostAddReimbursementRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList <ReimbursementEntity> GetReimbursements() {
	
	String GetAllReimbursementsSQL = "select * from ers_reimbursement;";
	ArrayList <ReimbursementEntity> ReimbursementTable = new ArrayList<>();
	
	
		Connection conn = ConnectionFactory.getConnection();
	  
	try {
		Statement GetAllReimbStatement = conn.createStatement();
		ResultSet GetAllReimbResults = GetAllReimbStatement.executeQuery(GetAllReimbursementsSQL);
		while(GetAllReimbResults.next()){
		System.out.println("in the loop");
		
		int ID = GetAllReimbResults.getInt("reimb_id");
		float AMT = GetAllReimbResults.getFloat("reimb_amount");
		int authorid = GetAllReimbResults.getInt("reimb_author");
		String Dsc = GetAllReimbResults.getString("reimb_description");
		LocalDateTime ResTimeStamp = GetAllReimbResults.getObject("reimb_resolved",LocalDateTime.class);
		int ResolverID = GetAllReimbResults.getInt("reimb_resolver");
		int statusID = GetAllReimbResults.getInt("reimb_status_id");
		LocalDateTime SubTimeStamp =  GetAllReimbResults.getObject("reimb_submitted",LocalDateTime.class);
		int typeID = GetAllReimbResults.getInt("reimb_type_id");
		ReimbursementEntity Reimbursement = new ReimbursementEntity(ID,statusID,typeID,AMT,authorid,ResolverID,Dsc,SubTimeStamp,ResTimeStamp);
		System.out.println(ID + "" + AMT + "" + authorid);
		System.out.println(Reimbursement.toString());
		ReimbursementTable.add(Reimbursement);
		
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ReimbursementTable;
				
		
		
		
		
		
		
	}

	@Override
	public ArrayList<ReimbursementEntity> getPendingReimbursements() {
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