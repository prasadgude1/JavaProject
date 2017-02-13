package com.prasad.um.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prasad.databasemgmt.connectionmgmt.ConnectionManager;

public class HouseHoldMembersDAO {
	private String houseHoldID ;
	private String userID ;
	private String role ;
	public String getHouseHoldID() {
		return houseHoldID;
	}
	public void setHouseHoldID(String houseHoldID) {
		this.houseHoldID = houseHoldID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "HouseHoldMembersDAO [houseHoldID=" + houseHoldID + ", userID=" + userID + ", role=" + role + "]";
	}
	public HouseHoldMembersDAO(String houseHoldID, String userID, String role) {
		super();
		this.houseHoldID = houseHoldID;
		this.userID = userID;
		this.role = role;
	}
	
	public HouseHoldMembersDAO()
	{
		
	}
	
	public void storeHouseHoldMember()
	{
Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
connection.prepareStatement("INSERT INTO HM_HOUSE_HOLD_MEMBERS (HOUSE_HOLD_ID,USER_ID,HOUSE_HOLD_ROLE) VALUES (?,?,?)");
		    prepStmt.setString(1,this.houseHoldID);
		    prepStmt.setString(2, this.userID);
		    prepStmt.setString(3, this.role);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void deleteHouseHoldMember()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("DELETE FROM HM_HOUSE_HOLD_MEMBERS WHERE HOUSE_HOLD_ID =? and USER_ID=?");
		    prepStmt.setString(1,this.houseHoldID);
		    prepStmt.setString(2, this.userID);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public List<HouseHoldMembersDAO> getAllHouseHoldMembers(String houseHoldID_INP)
	{
		List<HouseHoldMembersDAO> HouseHoldMembersDAO_l = new ArrayList<HouseHoldMembersDAO>();
		
		return HouseHoldMembersDAO_l ;
	}
	public static String getUserRole(int houseHoldId2, String userID2) 
	{
		String userRole = new String();
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT HOUSE_HOLD_ROLE FROM HM_USER_BASE WHERE HOUSE_HOLD_ID = ? AND USER_ID=?");
		    prepStmt.setInt(1, houseHoldId2);
		    prepStmt.setString(2, userID2);
		    ResultSet rs = prepStmt.executeQuery();
		    while (rs.next()) {
		    	userRole = rs.getString("HOUSE_HOLD_ROLE");
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		return userRole;
	}
}
