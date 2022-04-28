package com.revature.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static Connection conn;

	public static Connection getConnection() {
		
		
	
			final String HOST = "database-1.cbiem97ytw7h.us-east-1.rds.amazonaws.com";
			final String PORT = "5432";
			final String SQL_UN = "postgres";
			final String PW = "sdrep2016";
			final String DB_NAME = "postgres";
			final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME + "?user=" + SQL_UN
					+ "&password=" + PW;
		
			try {
		Connection conn = DriverManager.getConnection(JDBC_URL);
			return conn;
	}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			return conn;
}
}
