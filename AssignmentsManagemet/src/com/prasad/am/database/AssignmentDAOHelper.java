package com.prasad.am.database;

import com.prasad.am.assignments.Assignment;

public class AssignmentDAOHelper {
	public static Assignment getAssignmentUsingId(int assignmentId)
	{
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		Assignment l_oAssignment = new Assignment();
		
		l_oAssignmentDAO.getAssignment(assignmentId);
		
		l_oAssignment.populateFromDAO(l_oAssignmentDAO);
		
		return l_oAssignment;
	}
	
	public static void storeAssignment(Assignment assignment_INP)
	{
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO = assignment_INP.populateToDAO();
		l_oAssignmentDAO.storeAssignment();
	}

	public static void deleteAssignment(Assignment assignment) {
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO = assignment.populateToDAO();
		l_oAssignmentDAO.deleteAssignment();
		
	}
	
	public static void updateAssignment(Assignment assignment) {
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO = assignment.populateToDAO();
		l_oAssignmentDAO.updateAssignment();
		
	}
	
	public static void updatePoints(Assignment assignment)
	{
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO = assignment.populateToDAO();
		l_oAssignmentDAO.updatePoints();
	}
	
	public static void makeAssignmentInActive(Assignment assignment)
	{
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO = assignment.populateToDAO();
		l_oAssignmentDAO.makeAssignmentInActive();
	}
	
	public static void makeAssignmentActive(Assignment assignment)
	{
		AssignmentDAO l_oAssignmentDAO = new AssignmentDAO();
		l_oAssignmentDAO = assignment.populateToDAO();
		l_oAssignmentDAO.makeAssignmentActive();
	}
}
