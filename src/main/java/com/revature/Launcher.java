package com.revature;

import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {
    	
    	Javalin App = Javalin.create().start(4848);
    	App.get("/", ctx -> ctx.result("Hello World"));
    	App.get("/greeting", ctx -> {ctx.res.getWriter().write("greetings from JavaLin demoooooo! Thank god it's friday");});

    	
    }
}
