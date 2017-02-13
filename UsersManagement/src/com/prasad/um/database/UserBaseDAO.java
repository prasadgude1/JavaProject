package com.prasad.um.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prasad.databasemgmt.connectionmgmt.ConnectionManager;

public class UserBaseDAO {
	
	private String userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public UserBaseDAO()
	{
		
	}
	
	public UserBaseDAO(String userId, String firstName, String middleName, String lastName, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "UserBaseDAO [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}

	public List<UserBaseDAO> getAllUsers()
	{
		System.out.println("Inside getAllUsers...");
		List<UserBaseDAO> person_m = new ArrayList<UserBaseDAO>();
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DOB FROM HM_USER_BASE");
		    ResultSet rs = prepStmt.executeQuery();
		    while (rs.next()) {
		    	UserBaseDAO personDAO = new UserBaseDAO();
		    	personDAO.userId = rs.getString("USER_ID");
		    	personDAO.firstName = rs.getString("FIRST_NAME");
		    	personDAO.middleName = rs.getString("MIDDLE_NAME");
		    	personDAO.lastName = rs.getString("LAST_NAME");
		    	personDAO.dateOfBirth = rs.getDate("DOB");
		    	
		    	person_m.add(personDAO);
		    	
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		return person_m ;
		
	}
	
	public void getUserDetails(String userID_INP)
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DOB FROM HM_USER_BASE WHERE USER_ID=?");
		    prepStmt.setString(1, userID_INP);
		    ResultSet rs = prepStmt.executeQuery();
		    while (rs.next()) {
		    	this.userId = rs.getString("USER_ID");
		    	this.firstName = rs.getString("FIRST_NAME");
		    	this.middleName = rs.getString("MIDDLE_NAME");
		    	this.lastName = rs.getString("LAST_NAME");
		    	this.dateOfBirth = rs.getDate("DOB");
		    	
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void storeUserBase()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
connection.prepareStatement("INSERT INTO HM_USER_BASE (USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DOB) VALUES (?,?,?,?,?)");
		    prepStmt.setString(1,this.userId);
		    prepStmt.setString(2, this.firstName);
		    prepStmt.setString(3, this.middleName);
		    prepStmt.setString(4, this.lastName);
		    java.sql.Date sDate = new java.sql.Date(this.dateOfBirth.getTime());
		    prepStmt.setDate(5, sDate);
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void deleteUserBase()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("DELETE FROM HM_USER_BASE WHERE ID =?");
		    prepStmt.setString(1,this.userId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}
