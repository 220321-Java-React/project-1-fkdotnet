package com.revature.repository.entities;

import java.util.Objects;

public class LoginEntity {
	
	
		
		private int login_id;
		private String username;
		private String pass;
		private String firstName;
		private String lastName;
		private String eMail;
		private String Role;
		private int Roleid;
		
		
		public LoginEntity(String username, String pass, String firstName, String lastName, String eMail, int roleid) {
			super();
			this.username = username;
			this.pass = pass;
			this.firstName = firstName;
			this.lastName = lastName;
			this.eMail = eMail;
			Roleid = roleid;
		}

		public LoginEntity( String username, String pass) {
			super();
			
			this.username = username;
			this.pass = pass;
		}

		public LoginEntity() {
			// TODO Auto-generated constructor stub
		}

		public int getLogin_id() {
			return login_id;
		}

		public void setLogin_id(int login_id) {
			this.login_id = login_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		@Override
		public int hashCode() {
			return Objects.hash(login_id, pass, username);
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
			return login_id == other.login_id && Objects.equals(pass, other.pass)
					&& Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "LoginEntity [login_id=" + login_id + ", username=" + username + ", pass=" + pass + "]";
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

