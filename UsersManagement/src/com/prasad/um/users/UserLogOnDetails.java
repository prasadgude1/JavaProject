package com.prasad.um.users;

import java.sql.Timestamp;

import com.prasad.um.database.UserLogOnDetailsDAO;
import com.prasad.um.database.UserLogOnDetailsDAOHelper;

public class UserLogOnDetails {
	private String userID ;
	private String password ;
	private Timestamp lastLoggedInTime ;
	private String isUserLoggedIn ;
	private Timestamp loggedInTime ;
	
	public Timestamp getLoggedInTime() {
		return loggedInTime;
	}
	public void setLoggedInTime(Timestamp loggedInTime) {
		this.loggedInTime = loggedInTime;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLastLoggedInTime() {
		return lastLoggedInTime;
	}
	public void setLastLoggedInTime(Timestamp lastLoggedInTime) {
		this.lastLoggedInTime = lastLoggedInTime;
	}
	public String getIsUserLoggedIn() {
		return isUserLoggedIn;
	}
	public void setIsUserLoggedIn(String isUserLoggedIn) {
		this.isUserLoggedIn = isUserLoggedIn;
	}
	
	@Override
	public String toString() {
		return "UserLogOnDetails [userID=" + userID + ", password=" + password + ", lastLoggedInTime="
				+ lastLoggedInTime + ", isUserLoggedIn=" + isUserLoggedIn + ", loggedInTime=" + loggedInTime + "]";
	}
	
	public UserLogOnDetails(String userID, String password, Timestamp lastLoggedInTime, String isUserLoggedIn,
			Timestamp loggedInTime) {
		super();
		this.userID = userID;
		this.password = password;
		this.lastLoggedInTime = lastLoggedInTime;
		this.isUserLoggedIn = isUserLoggedIn;
		this.loggedInTime = loggedInTime;
	}
	public UserLogOnDetails()
	{
		
	}
	
	public boolean isUserAuthorized(String userID, String password)
	{
		boolean isUserAuthorized = false ;
		
		return isUserAuthorized ;
	}
	
	public void populateFromDAO(UserLogOnDetailsDAO authDAO_INP)
	{
		this.userID = authDAO_INP.getUserID() ;
		this.password = authDAO_INP.getPassword() ;
		this.lastLoggedInTime = authDAO_INP.getLastLoggedInTime() ;
		this.isUserLoggedIn = authDAO_INP.getIsUserLoggedIn() ;
		this.loggedInTime = authDAO_INP.getLoggedInTime();
	}
	
	public UserLogOnDetailsDAO populateToDAO()
	{
		UserLogOnDetailsDAO authDAO = new UserLogOnDetailsDAO();
		
		authDAO.setUserID(this.userID);
		authDAO.setPassword(this.password);
		authDAO.setLastLoggedInTime(this.lastLoggedInTime);
		authDAO.setIsUserLoggedIn(this.isUserLoggedIn);
		authDAO.setLoggedInTime(this.loggedInTime);
		
		return authDAO ;
	}
	
	public void storeLogOnDetails()
	{
		UserLogOnDetailsDAOHelper.storeLogOnDetails(this);
	}
	
	public static UserLogOnDetails getAuthDetails(String userID_INP, String password_INP)
	{
		UserLogOnDetails userLogOnDetl = new UserLogOnDetails();
		userLogOnDetl = UserLogOnDetailsDAOHelper.getAuthDetails(userID_INP, password_INP);
		
		return userLogOnDetl ;
	}
	
	public static void updateLogOnDetails(String userID_INP,String password_INP)
	{
		UserLogOnDetailsDAOHelper.updateLogOnDetails(userID_INP, password_INP);
	}
}
