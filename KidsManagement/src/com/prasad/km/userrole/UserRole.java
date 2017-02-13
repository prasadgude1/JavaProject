package com.prasad.km.userrole;

import com.prasad.km.database.UserRoleDAO;
import com.prasad.km.database.UserRoleDAOHelper;

public class UserRole {
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
	public UserRole(int userId, String userRole) {
		super();
		this.userId = userId;
		this.userRole = userRole;
	}
	
	public UserRole()
	{
		
	}
	
	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", userRole=" + userRole + "]";
	}
	
	public void populateFromDAO(UserRoleDAO auserroleDAO_INP)
	{
		this.userId = auserroleDAO_INP.getUserId();
		this.userRole = auserroleDAO_INP.getUserRole();
	}
	
	public UserRoleDAO populateToDAO()
	{
		UserRoleDAO l_oUserRoleDAO = new UserRoleDAO();
		l_oUserRoleDAO.setUserId(this.userId);
		l_oUserRoleDAO.setUserRole(this.userRole);
		
		return l_oUserRoleDAO;
	}
	
	public void getUserRole(int userId_INP)
	{
		UserRole l_oUserRole = new UserRole();
		
		l_oUserRole = UserRoleDAOHelper.getUserRoleUsingId(userId_INP);
		
		this.userId = l_oUserRole.userId;
		this.userRole = l_oUserRole.userRole;
		
	}
	
	public void storeUserRole()
	{
		UserRoleDAOHelper.storeUserRole(this);
	}
	
	public void deleteUserRole()
	{
		UserRoleDAOHelper.deleteUserRole(this);
	}
}
