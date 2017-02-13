package com.prasad.um.users;

import java.util.ArrayList;
import java.util.List;

import com.prasad.um.database.HouseHoldMembersDAO;
import com.prasad.um.database.HouseHoldMembersDAOHelper;

public class HouseHoldMembers {
	private String houseHoldID ;
	private String userID ;
	private String role ;
	public String getHouseHoldID() {
		return houseHoldID;
	}
	public void setHouseHoldID(String houseHoldID) {
		this.houseHoldID = houseHoldID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "HouseHoldMembers [houseHoldID=" + houseHoldID + ", userID=" + userID + ", role=" + role + "]";
	}
	public HouseHoldMembers(String houseHoldID, String userID, String role) {
		super();
		this.houseHoldID = houseHoldID;
		this.userID = userID;
		this.role = role;
	}
	
	public HouseHoldMembers()
	{
		
	}
	
	public void storeHouseHoldMember()
	{
		HouseHoldMembersDAOHelper.storeHouseHoldMember(this);
	}
	
	public void deleteHouseHoldMember()
	{
		HouseHoldMembersDAOHelper.deleteHouseHoldMember(this);
	}
	
	public List<HouseHoldMembers> getAllHouseHoldMembers(String houseHoldID_INP)
	{
		List<HouseHoldMembers> HouseHoldMembers_l = new ArrayList<HouseHoldMembers>();
		
		return HouseHoldMembers_l ;
	}
	
	public void populateFromDAO(HouseHoldMembersDAO houseHoldMembersDAO_INP)
	{
		this.userID = houseHoldMembersDAO_INP.getUserID() ;
		this.houseHoldID = houseHoldMembersDAO_INP.getHouseHoldID();
		this.role = houseHoldMembersDAO_INP.getRole() ;
	}
	
	public HouseHoldMembersDAO populateToDAO()
	{
		HouseHoldMembersDAO houseHoldMembersDAO = new HouseHoldMembersDAO();
		
		houseHoldMembersDAO.setUserID(this.userID);
		houseHoldMembersDAO.setHouseHoldID(this.houseHoldID);
		houseHoldMembersDAO.setRole(this.role);
		
		return houseHoldMembersDAO ;
	}
	
	public static String getUserRole(int houseHoldId, String userID)
	{
		String userRole = new String();
		
		userRole = HouseHoldMembersDAOHelper.getUserRole(houseHoldId, userID);
		
		return userRole ;
	}
}

