package com.revature;

import com.revature.controllers.GetAllController;
import com.revature.controllers.LoginController;

import io.javalin.Javalin;
import com.revature.service.*;

public class Launcher {

    public static void main(String[] args) {
    	GetAllController GetAll = new GetAllController();
    	Javalin App = Javalin.create(config -> {
    		config.enableCorsForAllOrigins();
    	
    		
    	
    	}); 
    	
    	App.post(PATH.LOGINJS, LoginController.LoginHandler);
    	
    	
    	}
    	}
