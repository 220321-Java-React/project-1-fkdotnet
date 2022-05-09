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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.repository.entities.LoginEntity;
import com.revature.repository.entities.ReimbursementEntity;
import com.revature.service.UserLoginService;

public class PGDaoClass implements PostgreDaoInterface {
	Logger log = LogManager.getLogger(PGDaoClass.class);
	
	
	
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
					log.info("results parsing");
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
					User.setUser_role_id(RoleID);
					System.out.println(User.toString());
					}
				
				}
				
		} catch(SQLException ex) {
			ex.printStackTrace();
			log.info("database error at login")
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
					log.info("login succeeded");
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
					User.setUser_role_id(RoleID);
			
					
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
	public ReimbursementEntity PostAddReimbursementRequest(ReimbursementEntity Reimb) {
		Integer Status = null;
		String SubmitReimbursementSQL = "INSERT INTO ers_reimbursement (reimb_status_id, reimb_type_id, reimb_amount, reimb_author, reimb_description, reimb_submitted)" +
				" VALUES(?,?,?,?,?,CURRENT_TIMESTAMP)";
		
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement addReimbursement = conn.prepareStatement(SubmitReimbursementSQL);
			addReimbursement.setInt(1, Reimb.getReimb_status_id());
			addReimbursement.setInt(2, Reimb.getReimb_type_id());
			addReimbursement.setFloat(3, Reimb.getReimb_amount());
			addReimbursement.setInt(4, Reimb.getReimb_author());
			addReimbursement.setString(5, Reimb.getReimb_description());
			
			Status = addReimbursement.executeUpdate();
			if(Status > 0) {
				log.info("reimbursement submitted");
				return Reimb;
			}
			else{log.info("not sent");
				return null;}
			
		}catch(SQLException ex) {
		ex.printStackTrace();
		}
			return Reimb;
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
		log.info("reimbursements recvd");
		
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
		log.error("SQL error!");
	}
	return ReimbursementTable;
				
		
		
		
		
		
		
	}



	@Override
	public int ApproveReimbursement(int ReimbursementID, int ResolverID) {
		String ApproveSQL = "UPDATE ers_reimbursement SET reimb_status_id = 2, reimb_resolved = CURRENT_TIMESTAMP WHERE reimb_id = " + ReimbursementID+";";
		Connection conn = ConnectionFactory.getConnection();
		int status=0;
		try {
			Statement ApproveStatement = conn.createStatement();
			status = ApproveStatement.executeUpdate(ApproveSQL);
			if(status>0) {
				log.info("approval sent to db succesfully");
				return status;
			}
			
		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			log.error("sql error on approval");
		}
		return status;
		
	}

	@Override
	public int DenyReimbursement(int ReimbursementID,int ResolverID) {
		String DenySQL = "UPDATE ers_reimbursement SET reimb_status_id = 0, reimb_resolved = CURRENT_TIMESTAMP WHERE reimb_id = " + ReimbursementID;
		Connection conn = ConnectionFactory.getConnection();
		int status=0;
		try {
			Statement ApproveStatement = conn.createStatement();
			status = ApproveStatement.executeUpdate(DenySQL);
			if(status>0) {
				return status;
			}
			
		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			log.error("sql error with denial query");
		}
		return status;
		
	}
	@Override
	public ArrayList <LoginEntity> GetAllEmployees() {
		String GetAllUsers = "select * from ers_users;";
		ArrayList <LoginEntity> UserTable = new ArrayList<>();
		
		
		
			Connection conn = ConnectionFactory.getConnection();
					try {
						Statement getall = conn.prepareStatement(GetAllUsers);
						ResultSet users = getall.executeQuery(GetAllUsers);
						while(users.next()) {
							int userid, roleid;
							String Fn,last,email,username,password;
							userid = users.getInt("ers_users_id");
							roleid = users.getInt("u"
									
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		return null;
	}

}