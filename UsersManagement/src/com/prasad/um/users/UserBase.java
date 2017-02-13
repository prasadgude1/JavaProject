package com.prasad.um.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prasad.um.database.UserBaseDAO;
import com.prasad.um.database.UserBaseDAOHelper;

public class UserBase {
	private String userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "UserBase [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	public UserBase()
	{
		
	}
	
	public UserBase(String userId, String firstName, String middleName, String lastName, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	public void populateFromDAO(UserBaseDAO personDAO_INP)
	{
		this.userId = personDAO_INP.getUserId() ;
		this.firstName = personDAO_INP.getFirstName();
		this.middleName = personDAO_INP.getMiddleName();
		this.lastName = personDAO_INP.getLastName() ;
		this.dateOfBirth =personDAO_INP.getDateOfBirth() ;
	}
	
	public UserBaseDAO populateToDAO()
	{
		UserBaseDAO personDAO_O = new UserBaseDAO();
		
		personDAO_O.setUserId(this.userId);
		personDAO_O.setFirstName(this.firstName);
		personDAO_O.setMiddleName(this.middleName);
		personDAO_O.setLastName(this.lastName);
		personDAO_O.setDateOfBirth(this.dateOfBirth);
		
		return personDAO_O ;
	}
	
	public static List<UserBase> getAllUsers()
	{
		List<UserBaseDAO> personDAO_m = new ArrayList<UserBaseDAO>();
		List<UserBase> person_m = new ArrayList<UserBase>();
		
		personDAO_m = UserBaseDAOHelper.getAllUsers();
		
		for(UserBaseDAO persondao:personDAO_m)
		{
			UserBase person_o = new UserBase();
			
			person_o.populateFromDAO(persondao);
			System.out.println("Inside Person");
			System.out.println(person_o.toString());
			person_m.add(person_o);
		}
		return person_m ;
	}
	
	public static UserBase getUserDetails(String userID_INP)
	{
		UserBase userBase = new UserBase();
		
		userBase = UserBaseDAOHelper.getUserDetails(userID_INP);
		
		return userBase ;
	}
	
}
