package com.prasad.km.database;

import com.prasad.km.userrole.UserRole;

public class UserRoleDAOHelper {
	
	public static UserRole getUserRoleUsingId(int userId_INP)
	{
		UserRole l_oUserRole = new UserRole();
		UserRoleDAO l_oUserRoleDAO = new UserRoleDAO();
		
		l_oUserRoleDAO.getUserRoleUsingId(userId_INP);
		l_oUserRole.populateFromDAO(l_oUserRoleDAO);
		
		return l_oUserRole;
	}
	
	public static void storeUserRole(UserRole userRole_INP)
	{
		UserRoleDAO l_userRoleInKmDAO = new UserRoleDAO();
		l_userRoleInKmDAO = userRole_INP.populateToDAO();
		l_userRoleInKmDAO.storeUserRole();
	}
	
	public static void deleteUserRole(UserRole userRole_INP)
	{
		UserRoleDAO l_userRoleInKmDAO = new UserRoleDAO();
		l_userRoleInKmDAO = userRole_INP.populateToDAO();
		l_userRoleInKmDAO.deleteUserRole();
	}

}
