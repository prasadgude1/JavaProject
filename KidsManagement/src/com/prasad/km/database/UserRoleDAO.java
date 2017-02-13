package com.prasad.km.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.prasad.databasemgmt.connectionmgmt.ConnectionManager;

public class UserRoleDAO {
	private int userId;
	private String userRole;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserRoleDAO [userId=" + userId + ", userRole=" + userRole + "]";
	}
	public UserRoleDAO(int userId, String userRole) {
		super();
		this.userId = userId;
		this.userRole = userRole;
	}
	
	public UserRoleDAO()
	{
		
	}
	
	public UserRoleDAO getUserRoleUsingId(int userId_INP)
	{
		UserRoleDAO l_oUserRoleDAO = new UserRoleDAO();
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT USER_ID,USER_ROLE FROM USERROLE_KM WHERE USER_ID=?");
		    prepStmt.setInt(1, userId_INP);
		    ResultSet rs = prepStmt.executeQuery();
		   
		    while (rs.next()) {
		    	l_oUserRoleDAO.userId = rs.getInt("user_id");
		    	l_oUserRoleDAO.userRole = rs.getString("user_role");
		    	
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		return l_oUserRoleDAO;
	}
	
	public void storeUserRole() 
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO USERROLE_KM (USER_ID,USER_ROLE) VALUES (?,?)");
		    prepStmt.setInt(1,this.userId);
		    prepStmt.setString(2, this.userRole);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		    
		}
	}
	
	public void deleteUserRole()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("DELETE FROM USERROLE_KM WHERE USER_ID=?");
		    prepStmt.setInt(1,this.userId);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}
