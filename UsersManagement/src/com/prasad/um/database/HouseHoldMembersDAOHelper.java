package com.prasad.um.database;

import java.util.ArrayList;
import java.util.List;

import com.prasad.um.users.HouseHoldMembers;

public class HouseHoldMembersDAOHelper {
	public static void storeHouseHoldMember(HouseHoldMembers HouseHoldMembersDAO_INP)
	{
		HouseHoldMembersDAO houseHoldMembersDAO = new HouseHoldMembersDAO();
		
		houseHoldMembersDAO = HouseHoldMembersDAO_INP.populateToDAO() ;
		
		houseHoldMembersDAO.storeHouseHoldMember();
	}
	
	public static void deleteHouseHoldMember(HouseHoldMembers HouseHoldMembersDAO_INP)
	{
		HouseHoldMembersDAO houseHoldMembersDAO = new HouseHoldMembersDAO();
		
		houseHoldMembersDAO = HouseHoldMembersDAO_INP.populateToDAO() ;
		
		houseHoldMembersDAO.deleteHouseHoldMember();
	}
	
	public List<HouseHoldMembersDAO> getAllHouseHoldMembers(String houseHoldID_INP)
	{
		List<HouseHoldMembersDAO> HouseHoldMembers_l = new ArrayList<HouseHoldMembersDAO>();
		
		return HouseHoldMembers_l ;
	}

	public static String getUserRole(int houseHoldId, String userID) 
	{
		String userRole = new String();
		
		userRole = HouseHoldMembersDAO.getUserRole(houseHoldId, userID);
		
		return userRole ;
	}
}
