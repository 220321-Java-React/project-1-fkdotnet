package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionFactory {
	private static Optional<Connection> connection = Optional.empty();


	public static Optional<Connection> getConnection() {
		
		
		if (!connection.isPresent()) 
		{
			final String HOST = "database-1.cbiem97ytw7h.us-east-1.rds.amazonaws.com";
			final String PORT = "5432";
			final String SQL_UN = "postgres";
			final String PW = "sdrep2016";
			final String DB_NAME = "postgres";
			final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME + "?user=" + SQL_UN
					+ "&password=" + PW;
		
		try {
			connection = Optional.ofNullable(DriverManager.getConnection(JDBC_URL));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		}
		return connection;
		}
	}

