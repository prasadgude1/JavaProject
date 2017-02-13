package com.prasad.um.authentication;

import com.prasad.um.database.UserLogOnDetailsDAOHelper;
import com.prasad.um.users.UserLogOnDetails;

public class LoginValidation {

	public static boolean isUserAutherized(String userID_INP, String password_INP)
	{
		boolean isUserAutherized = false ;
		
		UserLogOnDetails auth = new UserLogOnDetails();
		
		auth = UserLogOnDetails.getAuthDetails(userID_INP, password_INP) ;
		
		System.out.println("auth --PP = " + auth.toString());
		
		if(auth.getUserID() != null && auth.getPassword() != null)
		{
			if(auth.getUserID().trim().equalsIgnoreCase(userID_INP) && auth.getPassword().trim().equalsIgnoreCase(password_INP))
			{
				isUserAutherized = true ;
				
				UserLogOnDetailsDAOHelper.updateLogOnDetails(userID_INP,password_INP);
				
				//TO-DO update last_loggid_in_time and user_logged_in
			}
		}
		
		return isUserAutherized ;
	}
	 
}
