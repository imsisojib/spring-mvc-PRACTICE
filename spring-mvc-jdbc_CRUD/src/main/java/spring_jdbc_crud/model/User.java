package spring_jdbc_crud.model;

import java.io.Serializable;

public class User implements Serializable {
	String userMobileNumber;
	String userName,userAddress;
	public User() {
		super();
	}
	public User(String userMobileNumber, String userName, String userAddress) {
		super();
		this.userMobileNumber = userMobileNumber;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User Mobile: "+userMobileNumber+" User Name: "+userName+" User Address: "+userAddress;
	}
	
	
	
	
}
