package com.prasad.um.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagementHelper {
	public static List<UserBase> getAllUsers()
	{
		List<UserBase> users = new ArrayList<UserBase>() ;
		
		users = UserBase.getAllUsers();
		
		return users ;
	}
	
	public static boolean newUserSignUp(Map<String,String> userInput)
	{
		boolean isUserIdAvailable = true;
		
		//Check if userID is available
		//If available insert data into userBase else raise error
		
		return isUserIdAvailable ;
	}
	
	public static boolean isUserIDAvailable(String userID_INP)
	{
		boolean isUserIDAvail = true ;
		
		UserBase userBase = new UserBase();
		
		userBase = UserBase.getUserDetails(userID_INP) ;
		
		if(userBase.getUserId() == null)
		{
			isUserIDAvail = false ;
		}
		
		return isUserIDAvail ;
	}
	
	public static String getUserRole (int houseHoldId, String userId)
	{
		
//		UserRole	l_userRole = new UserRole();
	
//		l_userRole.getUserRole(userId);
		
		return "dsada" ;
	}
}
