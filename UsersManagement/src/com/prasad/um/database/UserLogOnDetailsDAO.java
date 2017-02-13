package com.prasad.um.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.prasad.databasemgmt.connectionmgmt.ConnectionManager;

public class UserLogOnDetailsDAO {
	private String userID ;
	private String password ;
	private Timestamp lastLoggedInTime ;
	private String isUserLoggedIn ;
	private Timestamp loggedInTime ;
	
	public Timestamp getLoggedInTime() {
		return loggedInTime;
	}
	public void setLoggedInTime(Timestamp loggedInTime) {
		this.loggedInTime = loggedInTime;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLastLoggedInTime() {
		return lastLoggedInTime;
	}
	public void setLastLoggedInTime(Timestamp lastLoggedInTime) {
		this.lastLoggedInTime = lastLoggedInTime;
	}
	public String getIsUserLoggedIn() {
		return isUserLoggedIn;
	}
	public void setIsUserLoggedIn(String isUserLoggedIn) {
		this.isUserLoggedIn = isUserLoggedIn;
	}
	
	@Override
	public String toString() {
		return "UserLogOnDetailsDAO [userID=" + userID + ", password=" + password + ", lastLoggedInTime="
				+ lastLoggedInTime + ", isUserLoggedIn=" + isUserLoggedIn + ", loggedInTime=" + loggedInTime + "]";
	}
	
	public UserLogOnDetailsDAO(String userID, String password, Timestamp lastLoggedInTime, String isUserLoggedIn,
			Timestamp loggedInTime) {
		super();
		this.userID = userID;
		this.password = password;
		this.lastLoggedInTime = lastLoggedInTime;
		this.isUserLoggedIn = isUserLoggedIn;
		this.loggedInTime = loggedInTime;
	}
	public UserLogOnDetailsDAO()
	{
		
	}
	
	public void getAuthDetails(String userID_INP, String password_INP)
	{
		
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT USER_ID,PASSWORD,LAST_LOGGED_IN_TIME,LOGGED_IN_TIME,USER_LOGGED_IN FROM HM_USER_LOGON_DETAILS WHERE USER_ID=? AND PASSWORD=?");
		    prepStmt.setString(1, userID_INP);
		    prepStmt.setString(2, password_INP);
		    ResultSet rs = prepStmt.executeQuery();
		    
		    while (rs.next()) {
		    	this.userID = rs.getString("USER_ID");
		    	this.password = rs.getString("PASSWORD");
		    	this.lastLoggedInTime = rs.getTimestamp("LAST_LOGGED_IN_TIME");
		    	this.isUserLoggedIn = rs.getString("USER_LOGGED_IN");
		    	this.loggedInTime = rs.getTimestamp("LOGGED_IN_TIME");
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAuthDetails(String userID_INP)
	{
		
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT USER_ID,PASSWORD,LAST_LOGGED-IN_TIME,LOGGED_IN_TIME,USER_LOGGED_IN FROM HM_USER_LOGON_DETAILS WHERE USER_ID=?");
		    prepStmt.setString(1, userID_INP);
		    ResultSet rs = prepStmt.executeQuery();
		    
		    while (rs.next()) {
		    	this.userID = rs.getString("USER_ID");
		    	this.password = rs.getString("PASSWORD");
		    	this.lastLoggedInTime = rs.getTimestamp("LAST_LOGGED_IN_TIME");
		    	this.isUserLoggedIn = rs.getString("USER_LOGGED_IN");
		    	this.loggedInTime = rs.getTimestamp("LOGGED_IN_TIME");
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void storeLogOnDetails()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
connection.prepareStatement("INSERT INTO HM_USER_LOGON_DETAILS (USER_ID,PASSWORD,LAST_LOGGED_IN_TIME,USER_LOGGED_IN,LOGGED_IN_TIME) VALUES (?,?,?,?,?)");
		    prepStmt.setString(1,this.userID);
		    prepStmt.setString(2, this.password);
		    prepStmt.setTimestamp(3, this.lastLoggedInTime);
		    prepStmt.setString(4, this.isUserLoggedIn);
//		    prepStmt.setTimestamp(5, this.loggedInTime);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void updateLogOnDetails(String userID_INP, String password_INP)
	{
Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
connection.prepareStatement("UPDATE HM_USER_LOGON_DETAILS SET USER_LOGGED_IN =?,LOGGED_IN_TIME=? WHERE USER_ID =? AND PASSWORD=?");
		    prepStmt.setString(1,"Y");
		    prepStmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		    prepStmt.setString(3, userID_INP);
		    prepStmt.setString(4, password_INP);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
}
