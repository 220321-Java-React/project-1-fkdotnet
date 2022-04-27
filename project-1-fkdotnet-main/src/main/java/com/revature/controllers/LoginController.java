package com.revature.controllers;

import java.util.Map;

import com.google.gson.Gson;
import com.revature.DAO.PGDaoClass;
import com.revature.repository.entities.LoginEntity;

import io.javalin.http.Handler;

public class LoginController {



public static Handler LoginHandler = (ctx) -> { 
	PGDaoClass Dao = new PGDaoClass();
	String body = ctx.body();
	Gson gson = new Gson();
	
	System.out.println(ctx.body());
};
}
	/*
LoginEntity LDTO = Dao.PostEmpLogin(null, null)
if(Dao.PostEmpLogin(LDTO.getUsername(), LDTO.getPass()).size() != 0) {
	ctx.req.getSession();
	ctx.status(202);
	
	String employeeJSON = gson.toJson(Dao.PostEmpLogin(LDTO.getUsername(), LDTO.getPass()));
	ctx.result(employeeJSON);
	

} else {
ctx.status(401);
System.out.println("A user failed at login!");

}
};
	
}
	
*/

