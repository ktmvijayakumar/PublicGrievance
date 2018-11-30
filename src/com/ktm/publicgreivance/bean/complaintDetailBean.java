package com.ktm.publicgreivance.bean;

public class complaintDetailBean {
	int userId=0;
	String department="";
	String complaintTitle="";
	String complaintDesc="";
	String complaintAddress="";
	int complaintId=0;
	String complaintStatus="";
	public complaintDetailBean(int complaintId,int userId, String department,
			String complaintTitle, String complaintDesc, String complaintAddress,String complaintStatus) {
		this.complaintId=complaintId;
		this.userId = userId;
		this.department = department;
		this.complaintTitle = complaintTitle;
		this.complaintDesc = complaintDesc;
		this.complaintAddress = complaintAddress;
		this.complaintStatus=complaintStatus;
	}
	
	public complaintDetailBean(int complaintId) {
		super();
		this.complaintId = complaintId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getComplaintTitle() {
		return complaintTitle;
	}
	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}
	public String getComplaintDesc() {
		return complaintDesc;
	}
	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}
	public String getComplaintAddress() {
		return complaintAddress;
	}
	public void setComplaintAddress(String complaintAddress) {
		this.complaintAddress = complaintAddress;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	
	
}
