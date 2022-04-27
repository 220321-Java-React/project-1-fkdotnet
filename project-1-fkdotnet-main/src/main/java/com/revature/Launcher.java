package com.revature;


import com.revature.controllers.LoginController;

import io.javalin.Javalin;
import com.revature.service.*;

public class Launcher {

    public static void main(String[] args) {
    
    	Javalin App = Javalin.create(config -> {
    		config.enableCorsForAllOrigins();
    	
    		
    	
    	}).start(9898);
    	
    	App.post(PATH.LOGINJS, LoginController.LoginHandler);
    	
    	
    	}
    	}
