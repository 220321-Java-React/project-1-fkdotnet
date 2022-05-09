package com.revature.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.UserLoginService;

public class ConnectionFactory {
	static Connection conn;

	public static Connection getConnection() {
		Logger log = LogManager.getLogger(UserLoginService.class);

		
	
			final String HOST = "localhost";
			final String PORT = "5432";
			final String SQL_UN = "postgres";
			final String PW = "sdrep2016";
			final String DB_NAME = "postgres";
			final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" +DB_NAME;
		
			try {
		Connection conn = DriverManager.getConnection(JDBC_URL,SQL_UN,PW);
			return conn;
	}
			catch (SQLException ex) {
				ex.printStackTrace();
				log.error("sql error");
			}
			return conn;
}
}
