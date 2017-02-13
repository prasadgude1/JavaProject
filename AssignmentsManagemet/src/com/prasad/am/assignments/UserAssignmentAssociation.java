package com.prasad.am.assignments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prasad.am.database.UserAssignmentAssociationDAO;
import com.prasad.am.database.UserAssignmentAssociationDAOHelper;

public class UserAssignmentAssociation {
	private int student_Id;
	private int assignment_id;
	private Date assignment_date;
	private int parent_id;
	private String assign_complete_ind ;
	private Date assign_complete_date;
	private Date assign_due_date;
	
	public Date getAssign_due_date() {
		return assign_due_date;
	}

	public void setAssign_due_date(Date assign_due_date) {
		this.assign_due_date = assign_due_date;
	}

	public Date getAssign_complete_date() {
		return assign_complete_date;
	}

	public void setAssign_complete_date(Date assign_complete_date) {
		this.assign_complete_date = assign_complete_date;
	}

	public UserAssignmentAssociation(int student_Id, int assignment_id, Date assignment_date, int parent_id,
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
	
	public UserAssignmentAssociation()
	{
		
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
	
	@Override
	public String toString() {
		return "StudentAssignmentAssociation [student_Id=" + student_Id + ", assignment_id=" + assignment_id
				+ ", assignment_date=" + assignment_date + ", parent_id=" + parent_id + ", assign_complete_ind="
				+ assign_complete_ind + ", assign_complete_date=" + assign_complete_date + ", assign_due_date="
				+ assign_due_date + "]";
	}

	public void populateFromDAO(UserAssignmentAssociationDAO StudentAssignmentAssociationDAO_INP)
	{
		this.assign_complete_date = StudentAssignmentAssociationDAO_INP.getAssign_complete_date() ;
		this.assign_complete_ind = StudentAssignmentAssociationDAO_INP.getAssign_complete_ind() ;
		this.assignment_date = StudentAssignmentAssociationDAO_INP.getAssignment_date() ;
		this.assignment_id = StudentAssignmentAssociationDAO_INP.getAssignment_id() ;
		this.parent_id = StudentAssignmentAssociationDAO_INP.getParent_id();
		this.student_Id = StudentAssignmentAssociationDAO_INP.getStudent_Id() ;
		this.assign_due_date = StudentAssignmentAssociationDAO_INP.getAssign_due_date() ;
	}
	
	public UserAssignmentAssociationDAO populateToDAO()
	{
		UserAssignmentAssociationDAO l_oStudentAssignmentAssociationDAO = new UserAssignmentAssociationDAO();
		
		l_oStudentAssignmentAssociationDAO.setAssign_complete_date(this.assign_complete_date);
		l_oStudentAssignmentAssociationDAO.setAssign_complete_ind(this.assign_complete_ind);
		l_oStudentAssignmentAssociationDAO.setAssignment_date(assignment_date);
		l_oStudentAssignmentAssociationDAO.setAssignment_id(assignment_id);
		l_oStudentAssignmentAssociationDAO.setParent_id(parent_id);
		l_oStudentAssignmentAssociationDAO.setStudent_Id(this.student_Id);
		l_oStudentAssignmentAssociationDAO.setAssign_due_date(assign_due_date);
		
		return l_oStudentAssignmentAssociationDAO;
	}
	
	public void makeAssignmentsComplete(List<UserAssignmentAssociation> studentAssignAssn_m_INP)
	{
		for(UserAssignmentAssociation studentAssignAssn : studentAssignAssn_m_INP)
		{
			UserAssignmentAssociationDAO studentAssignAssnDAO = new UserAssignmentAssociationDAO();
			studentAssignAssnDAO = studentAssignAssn.populateToDAO();
			UserAssignmentAssociationDAOHelper.makeAssignmentComplete(studentAssignAssnDAO);
		}
	}
	
	public void makeAssignmentsInComplete(List<UserAssignmentAssociation> studentAssignAssn_m_INP)
	{
		for(UserAssignmentAssociation studentAssignAssn : studentAssignAssn_m_INP)
		{
			UserAssignmentAssociationDAO studentAssignAssnDAO = new UserAssignmentAssociationDAO();
			studentAssignAssnDAO = studentAssignAssn.populateToDAO();
			UserAssignmentAssociationDAOHelper.makeAssignmentInComplete(studentAssignAssnDAO);
		}
	}
	
	public void getStudentAssignmentAssociationUsingId(int studentId)
	{
		UserAssignmentAssociation	l_oStudentAssignmentAssociation ;
		
		l_oStudentAssignmentAssociation = UserAssignmentAssociationDAOHelper.getUserAssignmentAssociationUsingId(studentId);
		
		this.assign_complete_date = l_oStudentAssignmentAssociation.assign_complete_date ;
		this.assign_complete_ind = l_oStudentAssignmentAssociation.assign_complete_ind ;
		this.assignment_date = l_oStudentAssignmentAssociation.assignment_date ;
		this.assignment_id = l_oStudentAssignmentAssociation.assignment_id ;
		this.parent_id = l_oStudentAssignmentAssociation.parent_id ;
		this.student_Id = l_oStudentAssignmentAssociation.student_Id ;
		this.assign_due_date = l_oStudentAssignmentAssociation.assign_due_date ;
		
	}
	
	public void storeStudentAssignmentAssociation()
	{
		UserAssignmentAssociationDAOHelper.storeUserAssignmentAssociation(this);
	}
	
	public void deleteStudentAssignmentAssociation()
	{
		UserAssignmentAssociationDAOHelper.deleteUserAssignmentAssociation(this);
	}
	
	public void updateStudentAssignmentAssociation()
	{
		UserAssignmentAssociationDAOHelper.updateUserAssignmentAssociation(this);
	}
	
	public static List<Assignment> getAllUserCompletedAssignments(int studentId_INP)
	{
		List<Assignment> assignments_OUT = new ArrayList<Assignment>();
		List<UserAssignmentAssociation> studentAssignmentAssociation_m = new ArrayList<UserAssignmentAssociation>();
		
		studentAssignmentAssociation_m = UserAssignmentAssociationDAOHelper.getAllUserCompletedAssignments(studentId_INP) ;
		
		for(UserAssignmentAssociation stdtAssignAssn : studentAssignmentAssociation_m)
		{
			Assignment l_oAssignment = new Assignment();
			
			l_oAssignment.getAssignment(stdtAssignAssn.assignment_id);
			assignments_OUT.add(l_oAssignment);
		}
		
		return assignments_OUT ;
	}
	
}
