package com.prasad.am.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.prasad.databasemgmt.connectionmgmt.ConnectionManager;

public class AssignmentDAO {
	private int assignmentId;
	private String assignmentType;
	private String details;
	private Date creationDate;
	private int createdPersonId;
	private String isActive;
	private int points;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getCreatedPersonId() {
		return createdPersonId;
	}

	public void setCreatedPersonId(int createdPersonId) {
		this.createdPersonId = createdPersonId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	

	@Override
	public String toString() {
		return "AssignmentDAO [assignmentId=" + assignmentId + ", assignmentType=" + assignmentType + ", details="
				+ details + ", creationDate=" + creationDate + ", createdPersonId=" + createdPersonId + ", isActive="
				+ isActive + ", points=" + points + "]";
	}

	public void getAssignment(int assignmentId) 
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT ASSIGNMENT_ID,TYPE,DETAILS,CREATION_DATE,CREATED_PERSON_ID,IS_ACTIVE,POINTS FROM HM_ASSIGNMENT WHERE ID=?");
		    prepStmt.setInt(1, assignmentId);
		    ResultSet rs = prepStmt.executeQuery();
		   
		    while (rs.next()) {
		    	this.assignmentId = rs.getInt("ID");
		    	this.assignmentType = rs.getString("TYPE");
		    	this.details = rs.getString("DETAILS");
		    	this.creationDate = rs.getDate("CREATION_DATE");
		    	this.createdPersonId = rs.getInt("CREATED_PERSON_ID");
		    	this.isActive = rs.getString("IS_ACTIVE");
		    	this.points = rs.getInt("POINTS");
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	public void storeAssignment()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
connection.prepareStatement("INSERT INTO HM_ASSIGNMENT (ASSIGNMENT_ID,TYPE,DETAILS,CREATION_DATE,CREATED_PERSON_ID,IS_ACTIVE,POINTS) VALUES (?,?,?,?,?,?)");
		    prepStmt.setInt(1,this.assignmentId);
		    prepStmt.setString(2, this.assignmentType);
		    prepStmt.setString(3, this.details);
		    java.sql.Date sDate = new java.sql.Date(this.creationDate.getTime());
		    prepStmt.setDate(4, sDate);
		    prepStmt.setInt(5, this.createdPersonId);
		    prepStmt.setString(6, this.isActive);
		    prepStmt.setInt(6, this.points);
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void deleteAssignment()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("DELETE FROM HM_ASSIGNMENT WHERE ASSIGNMENT_ID =?");
		    prepStmt.setInt(1,this.assignmentId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void updateAssignment()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_ASSIGNMENT SET DETAILS = ? WHERE ASSIGNMENT_ID =?");
		    prepStmt.setString(1,this.details);
		    prepStmt.setInt(2, this.assignmentId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void updatePoints()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_ASSIGNMENT SET POINTS = ? WHERE ASSIGNMENT_ID =?");
		    prepStmt.setInt(1,this.points);
		    prepStmt.setInt(2, this.assignmentId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void makeAssignmentInActive()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_ASSIGNMENT SET IS_ACTIVE = ? WHERE ASSIGNMENT_ID =?");
		    prepStmt.setString(1, "N");
		    prepStmt.setInt(2, this.assignmentId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void makeAssignmentActive()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_ASSIGNMENT SET IS_ACTIVE = ? WHERE ASSIGNMENT_ID =?");
		    prepStmt.setString(1, "Y");
		    prepStmt.setInt(2, this.assignmentId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
