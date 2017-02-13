package com.prasad.pm.points;

import java.util.ArrayList;
import java.util.List;

import com.prasad.am.assignments.Assignment;
import com.prasad.am.assignments.UserAssignmentAssociation;

public class UserPoints {
	
	public static int getUserPoints(int student_id_INP)
	{
		int points_OUT = 0;
		
		List<Assignment> assignments = new ArrayList<Assignment>();
		
		assignments = UserAssignmentAssociation.getAllUserCompletedAssignments(student_id_INP) ;
		
		for(Assignment assignment : assignments)
		{
			points_OUT = points_OUT + assignment.getPoints() ;
		}
		
		return points_OUT;
	}

}
