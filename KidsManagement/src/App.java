import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prasad.am.assignments.Assignment;
import com.prasad.am.assignments.UserAssignmentAssociation;
import com.prasad.km.userrole.UserRole;
import com.prasad.pm.points.UserPoints;
import com.prasad.um.users.UserBase;
import com.prasad.um.users.UserManagementHelper;

public class App {

	public static void main(String[] args) {
		Assignment l_oAssignment = new Assignment();
		
		l_oAssignment.getAssignment(1);
		System.out.println(l_oAssignment.toString());
		
		Assignment l_oAssignment1 = new Assignment();
		l_oAssignment1.setAssignmentId(4);
		l_oAssignment1.makeActive();
		
		List<UserBase> person_m = new ArrayList<UserBase>();
		
		person_m = UserManagementHelper.getAllUsers();
		
		for(UserBase person:person_m)
		{
			System.out.println(person.toString()) ;
		}
		
//		Assignment l_oAssignment2 = new Assignment();
//		l_oAssignment2.setAssignmentId(6);
//		l_oAssignment2.deleteAssignment();
		
//		Assignment l_oAssignment3 = new Assignment();
//		
//		l_oAssignment3.setAssignmentId(4);
//		l_oAssignment3.setDetails("Updating with Social");
//		l_oAssignment3.updateAssignment();
		
//		StudentAssignmentAssociation l_StudentAssignmentAssociation = new StudentAssignmentAssociation();
//		
//		l_StudentAssignmentAssociation.setStudent_Id(2);
//		l_StudentAssignmentAssociation.setParent_id(2);
//		l_StudentAssignmentAssociation.setAssignment_id(7);
//		l_StudentAssignmentAssociation.setAssignment_date(new Date());
//		l_StudentAssignmentAssociation.setAssign_complete_date(null);
//		l_StudentAssignmentAssociation.setAssign_complete_ind("N");
//		
//		l_StudentAssignmentAssociation.storeStudentAssignmentAssociation();
//		
//		int std1Points = 0 ;
//		
//		std1Points = StudentPoints.getStudentPoints(1);
//		
//		System.out.println("Student 1 points = " + std1Points);
//		
//		int std2Points = 0 ;
//		
//		std2Points = StudentPoints.getStudentPoints(2);
//		
//		System.out.println("Student 2 points = " + std2Points);
//		
//		UserRoleInKm userRole = new UserRoleInKm();
//		
//		userRole.setUserId(1);
//		userRole.setUserRole("Parent");
//		
//		userRole.storeUserRole();
//		
//		userRole.setUserId(2);
//		userRole.setUserRole("Parent");
//		
//		userRole.storeUserRole();
//		
//		userRole.setUserId(3);
//		userRole.setUserRole("Child");
//		
//		userRole.storeUserRole();
//		
//		userRole.setUserId(4);
//		userRole.setUserRole("Child");
//		
//		userRole.storeUserRole();
		

	}

}
