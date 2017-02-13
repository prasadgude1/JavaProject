package com.prasad.um.database;

import java.util.ArrayList;
import java.util.List;

import com.prasad.um.users.UserBase;

public class UserBaseDAOHelper {
	
	public static List<UserBaseDAO> getAllUsers()
	{
		List<UserBaseDAO> person_m = new ArrayList<UserBaseDAO>();
		
		UserBaseDAO personDAO = new UserBaseDAO();
		
		person_m = personDAO.getAllUsers();
		
		return person_m ;
	}

	public static void storeUserBase(UserBase userBase_INP)
	{
		UserBaseDAO userBaseDAO = new UserBaseDAO() ;
		
		userBaseDAO = userBase_INP.populateToDAO() ;
		
		userBaseDAO.storeUserBase();
	}
	
	public static void deleteUserBase(UserBase userBase_INP)
	{
		UserBaseDAO userBaseDAO = new UserBaseDAO() ;
		
		userBaseDAO = userBase_INP.populateToDAO() ;
		
		userBaseDAO.deleteUserBase();
	}
	
	public static UserBase getUserDetails(String userID_INP)
	{
		UserBaseDAO userBaseDAO = new UserBaseDAO();
		UserBase userBase = new UserBase();
		
		userBaseDAO.getUserDetails(userID_INP) ;
		
		userBase.populateFromDAO(userBaseDAO);
		
		return userBase ;
		
	}
}
