package com.prasad.km.userrole;

public class UserManager {
	
	public static boolean isUserAuthorised(String action, int userId)
	{
		boolean isAuthorised = false ;
		
		String l_userRole ;
		
		l_userRole = UserManager.getUserRole(userId) ;
		
		if(l_userRole == "Parent")
		{
			isAuthorised = true ;
		}
		
		return isAuthorised ;
	}
	
	public static String getUserRole (int userId)
	{
		
		UserRole	l_userRole = new UserRole();
	
		l_userRole.getUserRole(userId);
		
		return l_userRole.getUserRole() ;
	}
}
