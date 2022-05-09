package com.revature;


import com.revature.DAO.PGDaoClass;
import com.revature.controllers.AdminController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import static io.javalin.apibuilder.ApiBuilder.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.javalin.Javalin;
import com.revature.service.*;

public class Launcher {

    public static void main(String[] args) {
    	Logger log = LogManager.getLogger(Launcher.class);

    Javalin App = Javalin.create(config -> {
    	 	    		config.enableCorsForAllOrigins();
    	
    		
    	
    	}).start(9898);
    	App.before(ctx -> ctx.header("Access-Control-Allow-Credentials", "true"));
    	App.get(PATH.USERRENDERGET, LoginController.UserRenderHandler);
    	App.get(PATH.GETREIMBURSEMENTS, ReimbursementController.GetAllReimbursementsHandler);
    	App.post(PATH.SUBMITREIMBURSEMENTS, ReimbursementController.SubmitReimbursementHandler);
    	App.post(PATH.LOGINJS, LoginController.EmployeeLoginHandler);
    	App.post(PATH.ADMINLOGIN, LoginController.AdminLoginHandler);
    	App.post(PATH.APPROVE, AdminController.ApproveHandler);
    	App.post(PATH.DENY, AdminController.DenyHandler);
    	}
  
}