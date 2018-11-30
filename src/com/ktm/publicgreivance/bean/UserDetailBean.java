package com.ktm.publicgreivance.bean;

public class UserDetailBean {
		String username="";
		String password="";
		String age="";
		String phoneNumber="";
		String emailid="";
		
		
		public UserDetailBean(String username, String age, String emailid,
				String phoneNumber, String password) {
		
			this.username = username;
			this.password = password;
			this.age = age;
			this.phoneNumber = phoneNumber;
			this.emailid = emailid;
		}
		
		public UserDetailBean(String username) {
			super();
			this.username = username;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
	
		
}
