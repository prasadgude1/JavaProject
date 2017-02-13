package com.prasad.am.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prasad.databasemgmt.connectionmgmt.ConnectionManager;

public class UserAssignmentAssociationDAO {
	private int student_Id;
	private int assignment_id;
	private Date assignment_date;
	private int parent_id;
	private String assign_complete_ind ;
	private Date assign_complete_date;
	private Date assign_due_date ;
	
	public Date getAssign_due_date() {
		return assign_due_date;
	}
	public void setAssign_due_date(Date assign_due_date) {
		this.assign_due_date = assign_due_date;
	}
	public int getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	public int getAssignment_id() {
		return assignment_id;
	}
	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}
	public Date getAssignment_date() {
		return assignment_date;
	}
	public void setAssignment_date(Date assignment_date) {
		this.assignment_date = assignment_date;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getAssign_complete_ind() {
		return assign_complete_ind;
	}
	public void setAssign_complete_ind(String assign_complete_ind) {
		this.assign_complete_ind = assign_complete_ind;
	}
	public Date getAssign_complete_date() {
		return assign_complete_date;
	}
	public void setAssign_complete_date(Date assign_complete_date) {
		this.assign_complete_date = assign_complete_date;
	}
	public UserAssignmentAssociationDAO(int student_Id, int assignment_id, Date assignment_date, int parent_id,
			String assign_complete_ind, Date assign_complete_date, Date assign_due_date) {
		super();
		this.student_Id = student_Id;
		this.assignment_id = assignment_id;
		this.assignment_date = assignment_date;
		this.parent_id = parent_id;
		this.assign_complete_ind = assign_complete_ind;
		this.assign_complete_date = assign_complete_date;
		this.assign_due_date = assign_due_date ;
	}
	
	public UserAssignmentAssociationDAO()
	{
		
	}
	
	@Override
	public String toString() {
		return "StudentAssignmentAssociationDAO [student_Id=" + student_Id + ", assignment_id=" + assignment_id
				+ ", assignment_date=" + assignment_date + ", parent_id=" + parent_id + ", assign_complete_ind="
				+ assign_complete_ind + ", assign_complete_date=" + assign_complete_date + ", assign_due_date="
				+ assign_due_date + "]";
	}
	public void getUserAssignmentAssociationUsingId(int studentId) 
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT ASSIGNEE_ID,ASSIGNER_ID,ASSIGNMENT_ID,ASSIGNMENT_DATE,ASSIGN_COMPLETE_DATE,ASSIGN_COMPLETE_IND FROM HM_STUDENT_ASSIGNMENT_ASSN WHERE ASSIGNEE_ID=?");
		    prepStmt.setInt(1, studentId);
		    ResultSet rs = prepStmt.executeQuery();
		   
		    while (rs.next()) {
		    	this.student_Id = rs.getInt("ASSIGNEE_ID");
		    	this.parent_id = rs.getInt("ASSIGNER_ID");
		    	this.assignment_id = rs.getInt("ASSIGNMENT_ID");
		    	this.assignment_date = rs.getDate("ASSIGNMENT_DATE");
		    	this.assign_complete_date = rs.getDate("ASSIGN_COMPLETE_DATE");
		    	this.assign_complete_ind = rs.getString("ASSIGN_COMPLETE_IND");
		    	
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	public void storeUserAssignmentAssociation()
	{
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("INSERT INTO HM_STUDENT_ASSIGNMENT_ASSN (ASSIGNEE_ID,ASSIGNER_ID,ASSIGNMENT_ID,ASSIGNMENT_DATE,ASSIGN_COMPLETE_DATE,ASSIGN_COMPLETE_IND) VALUES (?,?,?,?,?,?)");
		    prepStmt.setInt(1,this.student_Id);
		    prepStmt.setInt(2, this.parent_id);
		    prepStmt.setInt(3, this.assignment_id);
		    java.sql.Date sDate = new java.sql.Date(this.assignment_date.getTime());
		    prepStmt.setDate(4, sDate);
		    if(this.assign_complete_date != null)
		    {
		    	java.sql.Date sDate1 = new java.sql.Date(this.assign_complete_date.getTime());
		    	prepStmt.setDate(5, sDate1);
		    }
		    else
		    {
		    	prepStmt.setNull(5, 0);
		    }
		    prepStmt.setString(6, this.assign_complete_ind);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void deleteUserAssignmentAssociation()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("DELETE FROM HM_STUDENT_ASSIGNMENT_ASSN WHERE ASSIGNEE_ID =? AND ASSIGNER_ID=? AND ASSIGNMENT_ID=?");
		    prepStmt.setInt(1,this.student_Id);
		    prepStmt.setInt(2, this.parent_id);
		    prepStmt.setInt(3, this.assignment_id);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public void updateUserAssignmentAssociation()
	{
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_STUDENT_ASSIGNMENT_ASSN SET ASSIGN_COMPLETE_DATE = ? WHERE ASSIGNEE_ID =? AND ASSIGNER_ID=? AND ASSIGNMENT_ID=? ");
		    
		    java.sql.Date sDate = new java.sql.Date(this.assignment_date.getTime());
		    prepStmt.setDate(1,sDate);
		    prepStmt.setInt(2, this.student_Id);
		    prepStmt.setInt(3, this.parent_id);
		    prepStmt.setInt(4, this.assignment_id);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public static List<UserAssignmentAssociationDAO> getAllUserCompletedAssignments(int studentId_INP)
	{
		List<UserAssignmentAssociationDAO> stdAssignAssn_m_OUT = new ArrayList<UserAssignmentAssociationDAO>();
		
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = connection.prepareStatement("SELECT ASSIGNEE_ID,ASSIGNER_ID,ASSIGNMENT_ID,ASSIGNMENT_DATE,ASSIGN_COMPLETE_DATE,ASSIGN_COMPLETE_IND FROM HM_STUDENT_ASSIGNMENT_ASSN WHERE ASSIGNEE_ID=? AND ASSIGN_COMPLETE_IND=?");
		    prepStmt.setInt(1, studentId_INP);
		    prepStmt.setString(2, "Y");
		    ResultSet rs = prepStmt.executeQuery();
		   
		    while (rs.next()) {
		    	UserAssignmentAssociationDAO l_oStudentAssignmentAssociationDAO = new UserAssignmentAssociationDAO();
		    	l_oStudentAssignmentAssociationDAO.student_Id = rs.getInt("student_id");
		    	l_oStudentAssignmentAssociationDAO.parent_id = rs.getInt("parent_id");
		    	l_oStudentAssignmentAssociationDAO.assignment_id = rs.getInt("assignment_id");
		    	l_oStudentAssignmentAssociationDAO.assignment_date = rs.getDate("assignment_date");
		    	l_oStudentAssignmentAssociationDAO.assign_complete_date = rs.getDate("assign_complete_date");
		    	l_oStudentAssignmentAssociationDAO.assign_complete_ind = rs.getString("assign_complete_ind");
		    	
		    	stdAssignAssn_m_OUT.add(l_oStudentAssignmentAssociationDAO);
		    	
		    }
		    
		    rs.close();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		return stdAssignAssn_m_OUT ;
	}
	public void makeAssignmentComplete() {
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_STUDENT_ASSIGNMENT_ASSN SET ASSIGN_COMPLETE_IND = ?,ASSIGN_COMPLETE_DATE = ? WHERE ASSIGNEE_ID =? AND ASSIGNER_ID=? AND ASSIGNMENT_ID=? ");
		    
		    java.sql.Date sDate = new java.sql.Date(this.assign_complete_date.getTime());
		    prepStmt.setString(1,"Y");
		    prepStmt.setDate(2, sDate);
		    prepStmt.setInt(3, this.student_Id);
		    prepStmt.setInt(4, this.parent_id);
		    prepStmt.setInt(5, this.assignment_id);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
	}
	public void makeAssignmentInComplete() {
		Connection connection = null ;
		
		try
		{
			connection = ConnectionManager.getConnection();
		    Statement stmt = connection.createStatement();
		    PreparedStatement prepStmt = 
		    		connection.prepareStatement("UPDATE HM_STUDENT_ASSIGNMENT_ASSN SET ASSIGN_COMPLETE_IND = ?,ASSIGN_COMPLETE_DATE = ? WHERE ASSIGNEE_ID =? AND ASSIGNER_ID=? AND ASSIGNMENT_ID=? ");
		    
		    prepStmt.setString(1,"N");
		    prepStmt.setNull(2,0);
		    prepStmt.setInt(3, this.student_Id);
		    prepStmt.setInt(4, this.parent_id);
		    prepStmt.setInt(5, this.assignment_id);
		    
		    prepStmt.execute();
		   
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
	}
	
}
