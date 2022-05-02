package com.revature;


import com.revature.DAO.PGDaoClass;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;

import io.javalin.Javalin;
import com.revature.service.*;

public class Launcher {

    public static void main(String[] args) {
    
    Javalin App = Javalin.create(config -> {
    	 	config.sessionHandler(javaserv::fileSessionHandler);
    		config.enableCorsForAllOrigins();
    	
    		
    	
    	}).start(9898);
    	
    	App.post(PATH.LOGINJS, LoginController.EmployeeLoginHandler);
    	App.post(PATH.ADMINLOGIN, LoginController.AdminLoginHandler);
    	App.get(PATH.USERRENDERGET, LoginController.UserRenderHandler);
    	App.get(PATH.GETREIMBURSEMENTS, ReimbursementController.GetAllReimbursementsHandler);
    	App.post(PATH.SUBMITREIMBURSEMENTS, ReimbursementController.SubmitReimbursementHandler);
    	}
}