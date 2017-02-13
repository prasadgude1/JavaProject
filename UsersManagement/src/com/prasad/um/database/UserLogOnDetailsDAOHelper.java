package com.prasad.um.database;

import com.prasad.um.users.UserLogOnDetails;

public class UserLogOnDetailsDAOHelper {
	public static UserLogOnDetails getAuthDetails(String userID, String password)
	{
		UserLogOnDetailsDAO authDAO = new UserLogOnDetailsDAO();
		UserLogOnDetails auth = new UserLogOnDetails();
		
		authDAO.getAuthDetails(userID, password);
		
		auth.populateFromDAO(authDAO) ;
		
		return auth ;
	}
	
	public static UserLogOnDetails getAuthDetails(String userID)
	{
		UserLogOnDetailsDAO authDAO = new UserLogOnDetailsDAO();
		UserLogOnDetails auth = new UserLogOnDetails();
		
		authDAO.getAuthDetails(userID);
		
		auth.populateFromDAO(authDAO) ;
		
		return auth ;
	}
	
	public static void storeLogOnDetails(UserLogOnDetails userLogOnDetails_INP)
	{
		UserLogOnDetailsDAO userLogOnDetailsDAO = new UserLogOnDetailsDAO() ;
		
		userLogOnDetailsDAO = userLogOnDetails_INP.populateToDAO() ;
		
		userLogOnDetailsDAO.storeLogOnDetails();
	}
	
	public static void updateLogOnDetails(String userID_INP, String password_INP)
	{
		UserLogOnDetailsDAO usrLogOnDet = new UserLogOnDetailsDAO() ;
		usrLogOnDet.updateLogOnDetails(userID_INP, password_INP);
		
	}
}
