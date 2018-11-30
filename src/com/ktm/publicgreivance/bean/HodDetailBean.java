package com.ktm.publicgreivance.bean;

public class HodDetailBean {

	String hodname="";
	String hodpassword="";
	String hodage="";
	String hodphoneNumber="";
	String hodemailid="";
	String hoddept="";
	public HodDetailBean(String hodname,  String hodage, String hodemailid, 
			String hodphoneNumber, String hodpassword,  String hoddept) {
		super();
		this.hodname = hodname;
		this.hodpassword = hodpassword;
		this.hodage = hodage;
		this.hodphoneNumber = hodphoneNumber;
		this.hodemailid = hodemailid;
		this.hoddept = hoddept;
	}
	public String getHodname() {
		return hodname;
	}
	public void setHodname(String hodname) {
		this.hodname = hodname;
	}
	public String getHodpassword() {
		return hodpassword;
	}
	public void setHodpassword(String hodpassword) {
		this.hodpassword = hodpassword;
	}
	public String getHodage() {
		return hodage;
	}
	public void setHodage(String hodage) {
		this.hodage = hodage;
	}
	public String getHodphoneNumber() {
		return hodphoneNumber;
	}
	public void setHodphoneNumber(String hodphoneNumber) {
		this.hodphoneNumber = hodphoneNumber;
	}
	public String getHodemailid() {
		return hodemailid;
	}
	public void setHodemailid(String hodemailid) {
		this.hodemailid = hodemailid;
	}
	public String getHoddept() {
		return hoddept;
	}
	public void setHoddept(String hoddept) {
		this.hoddept = hoddept;
	}
	
	
}
