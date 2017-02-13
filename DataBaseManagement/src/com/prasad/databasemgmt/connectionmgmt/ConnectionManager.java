package com.prasad.databasemgmt.connectionmgmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/prasad_personal";
		String username = "root";
		String password = "Dolly1319";
	
		System.out.println("Connecting database...");
	
		Connection connection = null;
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Connecting database Acquired...");

		return connection ;
	}
}
