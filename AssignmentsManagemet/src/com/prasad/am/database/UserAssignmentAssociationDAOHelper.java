package com.prasad.am.database;

import java.util.ArrayList;
import java.util.List;

import com.prasad.am.assignments.UserAssignmentAssociation;

public class UserAssignmentAssociationDAOHelper {
	public static UserAssignmentAssociation getUserAssignmentAssociationUsingId(int studentId)
	{
		UserAssignmentAssociationDAO l_oStudentAssignmentAssociationDAO = new UserAssignmentAssociationDAO();
		UserAssignmentAssociation l_oStudentAssignmentAssociation = new UserAssignmentAssociation();
		
		l_oStudentAssignmentAssociationDAO.getUserAssignmentAssociationUsingId(studentId);
		
		l_oStudentAssignmentAssociation.populateFromDAO(l_oStudentAssignmentAssociationDAO);
		
		return l_oStudentAssignmentAssociation;
	}
	
	public static void storeUserAssignmentAssociation(UserAssignmentAssociation StudentAssignmentAssociation_INP)
	{
		UserAssignmentAssociationDAO l_oStudentAssignmentAssociationDAO = new UserAssignmentAssociationDAO();
		l_oStudentAssignmentAssociationDAO = StudentAssignmentAssociation_INP.populateToDAO();
		l_oStudentAssignmentAssociationDAO.storeUserAssignmentAssociation();
	}

	public static void deleteUserAssignmentAssociation(UserAssignmentAssociation StudentAssignmentAssociation_INP) {
		UserAssignmentAssociationDAO l_oStudentAssignmentAssociationDAO = new UserAssignmentAssociationDAO();
		l_oStudentAssignmentAssociationDAO = StudentAssignmentAssociation_INP.populateToDAO();
		l_oStudentAssignmentAssociationDAO.deleteUserAssignmentAssociation();
		
	}
	
	public static void updateUserAssignmentAssociation(UserAssignmentAssociation StudentAssignmentAssociation_INP) {
		UserAssignmentAssociationDAO l_oStudentAssignmentAssociationDAO = new UserAssignmentAssociationDAO();
		l_oStudentAssignmentAssociationDAO = StudentAssignmentAssociation_INP.populateToDAO();
		l_oStudentAssignmentAssociationDAO.updateUserAssignmentAssociation();
		
	}
	
	public static List<UserAssignmentAssociation> getAllUserCompletedAssignments(int studentId_INP)
	{
		List<UserAssignmentAssociation> stdAssignAssn_m_OUT = new ArrayList<UserAssignmentAssociation>();
		List<UserAssignmentAssociationDAO> stdAssignAssnDAO_OUT = new ArrayList<UserAssignmentAssociationDAO>();
		
		stdAssignAssnDAO_OUT = UserAssignmentAssociationDAO.getAllUserCompletedAssignments(studentId_INP) ;
		
		for(UserAssignmentAssociationDAO l_stdAssignAssnDAO : stdAssignAssnDAO_OUT)
		{
			UserAssignmentAssociation l_StudentAssignmentAssociation = new UserAssignmentAssociation();
			l_StudentAssignmentAssociation.populateFromDAO(l_stdAssignAssnDAO);
			stdAssignAssn_m_OUT.add(l_StudentAssignmentAssociation);
		}
		
		return stdAssignAssn_m_OUT ;
	}

	public static void makeAssignmentComplete(UserAssignmentAssociationDAO studentAssignAssn) {
		studentAssignAssn.makeAssignmentComplete();
		
	}

	public static void makeAssignmentInComplete(UserAssignmentAssociationDAO studentAssignAssn) {
		studentAssignAssn.makeAssignmentInComplete();
		
	}

}
