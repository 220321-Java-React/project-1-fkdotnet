package com.revature.repository.entities;

import java.util.Objects;

public class LoginEntity {
	
	
		
		private int users_id;
		private String username;
		private String password;
		private String firstName;
		private String lastName;
		private String eMail;
		private String Role;
		private int Roleid;
		
		
		public LoginEntity(int users_id,String username, String pass, String firstName, String lastName, String eMail, int roleid) {
			this.users_id = users_id;
			this.username = username;
			this.password = pass;
			this.firstName = firstName;
			this.lastName = lastName;
			this.eMail = eMail;
			Roleid = roleid;
		}

		public LoginEntity( String username, String pass) {
			super();
			
			this.username = username;
			this.password = pass;
		}

		public LoginEntity() {
			// TODO Auto-generated constructor stub
		}

		public int getusers_id() {
			return users_id;
		}

		public void setuser_id( int users_id) {
			this.users_id = users_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPass() {
			return password;
		}

		public void setPass(String pass) {
			this.password = pass;
		}

		@Override
		public int hashCode() {
			return Objects.hash(users_id, password, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			LoginEntity other = (LoginEntity) obj;
			return users_id  == other.users_id && Objects.equals(password, other.password)
					&& Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "LoginEntity [users_id=" +users_id  + ", username=" + username + ", pass=" + password + "]";
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String geteMail() {
			return eMail;
		}

		public void seteMail(String eMail) {
			this.eMail = eMail;
		}

		
	}

