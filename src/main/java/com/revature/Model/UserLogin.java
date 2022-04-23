package com.revature.Model;

import java.util.Objects;

public class UserLogin {
	private String userID;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return "UserLogin [userID=" + userID + ", PW=" + PW + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(PW, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(PW, other.PW) && Objects.equals(userID, other.userID);
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public UserLogin(String userID, String pW) {
		super();
		this.userID = userID;
		PW = pW;
	}

	private String PW;
}
