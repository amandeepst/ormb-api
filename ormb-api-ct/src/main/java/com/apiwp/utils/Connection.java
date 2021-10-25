package com.apiwp.utils;

public class Connection {

	private Connection() {
		
	}
	private static java.sql.Connection connection;

	public static java.sql.Connection getConnection() {
		return connection;
	}

	public static void setConnection(java.sql.Connection connection) {
		Connection.connection = connection;
	}
	
	

}
