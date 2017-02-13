package com.prasad.am.assignments;

import java.util.Date;

import com.prasad.am.database.AssignmentDAO;
import com.prasad.am.database.AssignmentDAOHelper;

public class Assignment {
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

	public Assignment()
	{
		
	}
	
	public Assignment(int assignmentId, String assignmentType, String details, Date creationDate, int createdPersonId,
			String isActive, int points) {
		super();
		this.assignmentId = assignmentId;
		this.assignmentType = assignmentType;
		this.details = details;
		this.creationDate = creationDate;
		this.createdPersonId = createdPersonId;
		this.isActive = isActive;
		this.points = points ;
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
	public String isActive() {
		return isActive;
	}
	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	
	public void makeInactive()
	{
		this.isActive = "N";
		AssignmentDAOHelper.makeAssignmentInActive(this);
	}
	
	public void makeActive()
	{
		this.isActive = "Y";
		AssignmentDAOHelper.makeAssignmentActive(this);
	}
	
	public void populateFromDAO(AssignmentDAO assignmentDAO_INP)
	{
		this.assignmentId = assignmentDAO_INP.getAssignmentId();
		this.assignmentType = assignmentDAO_INP.getAssignmentType();
		this.createdPersonId = assignmentDAO_INP.getCreatedPersonId();
		this.creationDate = assignmentDAO_INP.getCreationDate();
		this.details = assignmentDAO_INP.getDetails();
		this.isActive = assignmentDAO_INP.getIsActive();
		this.points = assignmentDAO_INP.getPoints();
	}
	
	public AssignmentDAO populateToDAO()
	{
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO.setAssignmentId(this.assignmentId) ;
		l_oAssignmentDAO.setAssignmentType(this.assignmentType);
		l_oAssignmentDAO.setCreatedPersonId(this.createdPersonId);
		l_oAssignmentDAO.setCreationDate(this.creationDate);
		l_oAssignmentDAO.setDetails(this.details);
		l_oAssignmentDAO.setIsActive(this.isActive);
		l_oAssignmentDAO.setPoints(this.points);
		return l_oAssignmentDAO;
	}
	
	public void getAssignment(int assignmentId)
	{
		Assignment	l_oAssignment ;
		
		l_oAssignment = AssignmentDAOHelper.getAssignmentUsingId(assignmentId);
		
		this.assignmentId = l_oAssignment.assignmentId;
		this.assignmentType = l_oAssignment.assignmentType;
		this.createdPersonId = l_oAssignment.createdPersonId;
		this.creationDate = l_oAssignment.creationDate;
		this.details = l_oAssignment.details;
		this.isActive = l_oAssignment.isActive;
		this.points = l_oAssignment.points ;
		
	}
	
	public static boolean isAssignmentExists(int assignmentId) {
		Assignment	l_assignment = new Assignment();
		boolean isAssignExisst = true ;
		l_assignment.setAssignmentId(assignmentId);
		l_assignment.getAssignment(assignmentId);
		if(l_assignment.getDetails() == " ")
		{
			isAssignExisst = false ;
		}
		return isAssignExisst;
	}
	
	public void storeAssignment()
	{
		AssignmentDAOHelper.storeAssignment(this);
	}
	
	public void deleteAssignment()
	{
		AssignmentDAOHelper.deleteAssignment(this);
	}
	
	public void updateAssignment()
	{
		AssignmentDAOHelper.updateAssignment(this);
	}
	
	public void updatePoints(int id_INP)
	{
		AssignmentDAOHelper.updatePoints(this);
	}

	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentType=" + assignmentType + ", details="
				+ details + ", creationDate=" + creationDate + ", createdPersonId=" + createdPersonId + ", isActive="
				+ isActive + ", points=" + points + "]";
	}
	
}
