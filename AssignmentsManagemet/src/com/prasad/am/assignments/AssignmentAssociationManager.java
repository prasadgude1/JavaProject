package com.prasad.am.assignments;

import java.util.Date;

public class AssignmentAssociationManager {
	
	public static void assignAssignmentToUser(int assignmentId, int student_id, int parent_id, Date assignmentDate, Date assignmentDueDate)
	{
		boolean isAssignmentExists = false;
		
		isAssignmentExists = Assignment.isAssignmentExists(assignmentId);
		
		if(isAssignmentExists)
		{
			UserAssignmentAssociation l_oStudentAssignmentAssn = new UserAssignmentAssociation() ;
			
			l_oStudentAssignmentAssn.setStudent_Id(student_id);
			l_oStudentAssignmentAssn.setAssignment_id(assignmentId);
			l_oStudentAssignmentAssn.setParent_id(parent_id);
			l_oStudentAssignmentAssn.setAssignment_date(assignmentDate);
			l_oStudentAssignmentAssn.setAssign_due_date(assignmentDueDate);
			
			l_oStudentAssignmentAssn.storeStudentAssignmentAssociation();
		}
		else
		{
			System.out.println("Assignment does not exists ...");
		}
	}
	
	public static void dissociateAssignmentFromUser(int assignmentId, int student_id, int parent_id)
	{
		boolean isAssignmentExists = false;
		
		isAssignmentExists = Assignment.isAssignmentExists(assignmentId);
		
		if(isAssignmentExists)
		{
			UserAssignmentAssociation l_oStudentAssignmentAssn = new UserAssignmentAssociation() ;
			
			l_oStudentAssignmentAssn.setStudent_Id(student_id);
			l_oStudentAssignmentAssn.setAssignment_id(assignmentId);
			l_oStudentAssignmentAssn.setParent_id(parent_id);
			
			l_oStudentAssignmentAssn.storeStudentAssignmentAssociation();
		}
		else
		{
			System.out.println("Assignment does not exists ...");
		}
	}
}
