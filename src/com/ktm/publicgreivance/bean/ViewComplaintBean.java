package com.ktm.publicgreivance.bean;

public class ViewComplaintBean {
	String department="";
	String complaintTitle="";
	String complaintDesc="";
	String complaintAddress="";
	int complaintId=0;
	String complaintStatus="";
	String userName="";
	public ViewComplaintBean(int complaintId, String userName, String complaintTitle,
			String complaintDesc,  String department, String complaintAddress,
			String complaintStatus) {
		super();
		this.department = department;
		this.complaintTitle = complaintTitle;
		this.complaintDesc = complaintDesc;
		this.complaintAddress = complaintAddress;
		this.complaintId = complaintId;
		this.complaintStatus = complaintStatus;
		this.userName = userName;
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
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
