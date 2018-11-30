package com.ktm.publicgreivance.utils;

import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.ktm.publicgreivance.bean.*;
public class DBUtils {
	  public static UserDetailBean findUser(Connection conn, //
	        String emailId, String password) throws SQLException {
	 
	        String sql = "Select a.userName, a.userAge, a.emailId, a.phoneNo, a.userPassword from userDetail a " //
	                + " where a.emailId ='"+emailId+"' and a.userPassword= '"+password+"'";
	        System.out.println(emailId+" "+",'"+password);
	        Statement pstm1 = conn.createStatement();
	        ResultSet rs = pstm1.executeQuery(sql);
	 
	        if (rs.next()) {
	        	String age = rs.getString("userAge");
	            String userName = rs.getString("userName");
	            String phoneNo = rs.getString("phoneNo");
	            System.out.println(emailId+" "+password);
	 	            
	        	UserDetailBean user = new UserDetailBean(userName,age,emailId,phoneNo,password);
	            user.setUsername(userName);
	            user.setPassword(password);
	            user.setAge(age);
	            user.setEmailid(emailId);
	            user.setPhoneNumber(phoneNo);
	            
	            return user;
	        } 
	 	       
	        return null;
	    }
	 
	  public static HodDetailBean findHod(Connection conn, //
		        String emailid, String password) throws SQLException {
		 
		        String sql = "Select hodName, hodAge, hodemailId, hodphoneNo, hodPassword, hodDept from hodDetails" //
		                + " where hodemailId ='"+emailid+"' and hodPassword= '"+password+"'";
		        System.out.println(emailid+" "+",'"+password);
		        Statement pstm = conn.createStatement();
		        ResultSet rs = pstm.executeQuery(sql);
		        System.out.println(emailid+" "+",'"+password);
		        if (rs.next()) {
		        	String hodName=rs.getString("hodName");
		        	String age = rs.getString("hodAge");
		            String emailId = rs.getString("hodemailId");
		            String phoneNo = rs.getString("hodphoneNo");
		            String department = rs.getString("hodDept");
		            System.out.println(emailid+" "+password);
		 	            
		        	HodDetailBean user = new HodDetailBean(hodName,age,emailId,phoneNo,password,department);
		            user.setHodname(hodName);
		            user.setHodpassword(password);
		            user.setHodage(age);
		            user.setHodemailid(emailId);
		            user.setHodphoneNumber(phoneNo);
		            user.setHoddept(department);
		            
		            return user;
		        } 
		 	       
		        return null;
		    }
		 
	  public static int findUserId(Connection conn, //
		        String userName) throws SQLException {
		  		
		  		int userId;
		        String sql = "Select a.userId from userDetail a " //
		                + " where a.userName ='"+userName+"'";
		        System.out.println(userName);
		        Statement pstm = conn.createStatement();
		        ResultSet rs = pstm.executeQuery(sql);
		 
		        if (rs.next()) {
		        	userId = rs.getInt("userId");
		            System.out.println(userId);
		 	        return userId;
		        } 
		 	    return 0;
		    }
		  
	  
	    public static UserDetailBean findUser(Connection conn, String userName) throws SQLException {
	 
	        String sql = "Select a.userName, a.userAge, a.emailId, a.phoneNo, a.password from userDetail a "//
	                + " where a.userName = ? ";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, userName);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        if (rs.next()) {
	            String password = rs.getString("password");
	            String age = rs.getString("age");
	            String emailId = rs.getString("emailId");
	            String phoneNo = rs.getString("phoneNo");
	            UserDetailBean user = new UserDetailBean(userName,age,emailId,phoneNo,password);
	            user.setUsername(userName);
	            user.setPassword(password);
	            user.setAge(age);
	            user.setEmailid(emailId);
	            user.setPhoneNumber(phoneNo);
	            return user;
	        }
	        return null;
	    }
	 
	    public static complaintDetailBean findComplaint(Connection conn, int complaintid) throws SQLException {
	   	 
	        String sql = "Select a.complaintId, a.userId,a.department, a.complaintTitle, a.complaintDesc, a.complaintAddress,a.complaintStatus from userComplaint a "//
	                + " where a.complaintId = ? ";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, complaintid);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        if (rs.next()) {
	        	int userId=rs.getInt("userId");
	        	String department=rs.getString("department");
	            String complaintTitle = rs.getString("complaintTitle");
	            String complaintDesc = rs.getString("complaintDesc");
	            String complaintAddress = rs.getString("complaintAddress");
	            String complaintStatus = rs.getString("complaintStatus");
	            complaintDetailBean user = new complaintDetailBean(complaintid,userId,department,complaintTitle,complaintDesc,complaintAddress,complaintStatus);
	            user.setComplaintId(complaintid);
	            user.setUserId(userId);
	            user.setDepartment(department);
	            user.setComplaintTitle(complaintTitle);
	            user.setComplaintDesc(complaintDesc);
	            user.setComplaintAddress(complaintAddress);
	            user.setComplaintStatus(complaintStatus);
	            
	            return user;
	        }
	        return null;
	    }
	 
	 
	public static void insertUser(Connection conn, UserDetailBean user) throws SQLException {
        String sql = "INSERT INTO userDetail(userName, userAge, emailId, phoneNo, userPassword) values('"+
        		user.getUsername()+"'"+",'"+user.getAge()+"','"+user.getEmailid()+"','"
        		+user.getPhoneNumber()+"','"+user.getPassword()+"')";
        System.out.println("beforeinsert");
        System.out.println(user.getUsername()+" "+",'"+user.getAge()+"','"+user.getEmailid()+"','"
        		+user.getPhoneNumber()+"','"+user.getPassword());
        Statement pstm = conn.createStatement();
        pstm.executeUpdate(sql);
        System.out.println("afterinsert");
        
    }
	public static void insertHod(Connection conn, HodDetailBean user) throws SQLException {
        String sql = "INSERT INTO hodDetails(hodName, hodAge, hodemailId, hodphoneNo, hodPassword,hodDept) values('"+
        		user.getHodname()+"'"+",'"+user.getHodage()+"','"+user.getHodemailid()+"','"
        		+user.getHodphoneNumber()+"','"+user.getHodpassword()+"','"+user.getHoddept()+"')";
        System.out.println("beforeinsert");
        System.out.println(user.getHodname()+" "+",'"+user.getHodage()+"','"+user.getHodemailid()+"','"
        		+user.getHodphoneNumber()+"','"+user.getHodpassword()+"','"+user.getHoddept());
        Statement pstm = conn.createStatement();
        pstm.executeUpdate(sql);
        System.out.println("afterinsert");
        
    }
	public static void insertComplaint(Connection conn, complaintDetailBean complaint) throws SQLException {
        String sql = "INSERT INTO userComplaint(userId, department, complaintTitle, complaintDesc, complaintAddress, complaintStatus) values('"+
        		complaint.getUserId()+"'"+",'"+complaint.getDepartment()+"','"+complaint.getComplaintTitle()+"','"
        		+complaint.getComplaintDesc()+"','"+complaint.getComplaintAddress()+"','"+complaint.getComplaintStatus()+"')";
        
        System.out.println("beforeinsert");
        System.out.println(complaint.getUserId()+" "+",'"+complaint.getDepartment()+"','"+complaint.getComplaintTitle()+"','"
        		+complaint.getComplaintDesc()+"','"+complaint.getComplaintAddress()+"','"+complaint.getComplaintStatus());
        Statement pstm = conn.createStatement();
        pstm.executeUpdate(sql);
        System.out.println("afterinsert");
        
    }
	
	 public static List<complaintDetailBean> queryComplaint(Connection conn ,int userid) throws SQLException {
	        String sql = "Select a.complaintId, a.userId, a.department, a.complaintTitle, a.complaintDesc," +
	        		" a.complaintAddress , a.complaintStatus from userComplaint a"+ " where a.userId ='"+userid+"'";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	        List<complaintDetailBean> list = new ArrayList<complaintDetailBean>();
	        while (rs.next()) {
	        	int complaintId =rs.getInt("complaintId");
	        	int userId = rs.getInt("userId");
	            String department = rs.getString("department");
	            String complaintTitle = rs.getString("complaintTitle");
	            String complaintDesc = rs.getString("complaintDesc");
	            String complaintAddress = rs.getString("complaintAddress");
	            String complaintStatus = rs.getString("complaintStatus");
	            complaintDetailBean complaint = new complaintDetailBean(complaintId, userId, department,
	        			 complaintTitle, complaintDesc, complaintAddress, complaintStatus);
	            complaint.setComplaintId(complaintId);
	            
	            complaint.setDepartment(department);
	            complaint.setComplaintTitle(complaintTitle);
	            complaint.setComplaintDesc(complaintDesc);
	            complaint.setComplaintAddress(complaintAddress);
	            
	            list.add(complaint);
	            System.out.println(complaintId+department+complaintTitle+complaintAddress+complaintStatus);
	            System.out.println(complaint.getComplaintId());
	           
	        }
	        return list;
	    }
	 
	 public static List<ViewComplaintBean> hodqueryComplaint(Connection conn ,String dept) throws SQLException {
	        String sql = "Select a.complaintId, b.userName,a.userId, a.department, a.complaintTitle, a.complaintDesc,"+
	        		"a.complaintAddress , a.complaintStatus " +
	        		"from userComplaint a, userDetail b " +
	        		"Where a.userID=b.userId and a.department ='"+dept+"'";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	        List<ViewComplaintBean> list = new ArrayList<ViewComplaintBean>();
	        while (rs.next()) {
	        	int complaintId =rs.getInt("complaintId");
	        	String userName=rs.getString("userName");
	            String department = rs.getString("department");
	            String complaintTitle = rs.getString("complaintTitle");
	            String complaintDesc = rs.getString("complaintDesc");
	            String complaintAddress = rs.getString("complaintAddress");
	            String complaintStatus = rs.getString("complaintStatus");
	            ViewComplaintBean complaint = new ViewComplaintBean(complaintId, userName, 
	        			 complaintTitle, complaintDesc, department, complaintAddress, complaintStatus);
	            complaint.setComplaintId(complaintId);
	            complaint.setUserName(userName);
	            
	            complaint.setComplaintTitle(complaintTitle);
	            complaint.setComplaintDesc(complaintDesc);
	            complaint.setComplaintAddress(complaintAddress);
	            
	            list.add(complaint);
	            System.out.println(userName+complaintId+department+complaintTitle+complaintAddress+complaintStatus);
	            System.out.println(complaint.getComplaintId());
	             
	        }
	        return list;
	    }
	 
	 public static List<ViewComplaintBean> queryAdminComplaint(Connection conn) throws SQLException {
	        String sql = "Select a.complaintId, b.userName,a.userId, a.department, a.complaintTitle, a.complaintDesc,"+
	        		"a.complaintAddress , a.complaintStatus " +
	        		"from userComplaint a, userDetail b " +
	        		"Where a.userID=b.userId";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	        List<ViewComplaintBean> list = new ArrayList<ViewComplaintBean>();
	        while (rs.next()) {
	        	String userName=rs.getString("userName");
	        	int complaintId =rs.getInt("complaintId");
	        	
	            String department = rs.getString("department");
	            String complaintTitle = rs.getString("complaintTitle");
	            String complaintDesc = rs.getString("complaintDesc");
	            String complaintAddress = rs.getString("complaintAddress");
	            String complaintStatus = rs.getString("complaintStatus");
	            
	            ViewComplaintBean complaint = new ViewComplaintBean(complaintId, userName, 
	        			 complaintTitle, complaintDesc, department, complaintAddress, complaintStatus);
	            complaint.setComplaintId(complaintId);
	            complaint.setUserName(userName);
	            complaint.setDepartment(department);
	            complaint.setComplaintTitle(complaintTitle);
	            complaint.setComplaintDesc(complaintDesc);
	            complaint.setComplaintAddress(complaintAddress);
	            
	            list.add(complaint);
	            System.out.println(userName+complaintId+department+complaintTitle+complaintAddress+complaintStatus);
	            System.out.println(complaint.getComplaintId());
	           
	        }
	        return list;
	    }
	 

	 public static List<complaintDetailBean> queryCheckStatus(Connection conn ,int complaintid) throws SQLException {
	        String sql = "Select a.complaintId, a.userId, a.department, a.complaintTitle, a.complaintDesc," +
	        		" a.complaintAddress , a.complaintStatus from userComplaint a"+ " where a.complaintId ='"+complaintid+"'";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	        List<complaintDetailBean> list = new ArrayList<complaintDetailBean>();
	        while (rs.next()) {
	        	int complaintId =rs.getInt("complaintId");
	        	int userId = rs.getInt("userId");
	            String department = rs.getString("department");
	            String complaintTitle = rs.getString("complaintTitle");
	            String complaintDesc = rs.getString("complaintDesc");
	            String complaintAddress = rs.getString("complaintAddress");
	            String complaintStatus = rs.getString("complaintStatus");
	            complaintDetailBean complaint = new complaintDetailBean(complaintId, userId, department,
	        			 complaintTitle, complaintDesc, complaintAddress, complaintStatus);
	            complaint.setComplaintTitle(complaintTitle);
	            complaint.setComplaintDesc(complaintDesc);
	            complaint.setComplaintAddress(complaintAddress);
	            complaint.setComplaintStatus(complaintStatus);
	            list.add(complaint);
	            System.out.println(complaintId+department+complaintTitle+complaintAddress+complaintStatus);
	            System.out.println(complaint.getComplaintId());
	           
	        }
	        return list;
	    }
	 
	 public static complaintDetailBean findValidComplaintId(Connection conn, //
		        int userid,int compid) throws SQLException {
		 
		        String sql = "Select a.complaintId, a.userId, a.department, a.complaintTitle, a.complaintDesc," +
	        		" a.complaintAddress , a.complaintStatus from userComplaint a" //
		                + " where a.userId ='"+userid+"' and a.complaintId= '"+compid+"'";
		        System.out.println(userid+" "+",'"+compid);
		        Statement pstm = conn.createStatement();
		        ResultSet rs = pstm.executeQuery(sql);
		 
		        if (rs.next()) {
		            int complaintId =rs.getInt("complaintId");
		        	int userId = rs.getInt("userId");
		            String department = rs.getString("department");
		            String complaintTitle = rs.getString("complaintTitle");
		            String complaintDesc = rs.getString("complaintDesc");
		            String complaintAddress = rs.getString("complaintAddress");
		            String complaintStatus = rs.getString("complaintStatus");
		            complaintDetailBean complaint1 = new complaintDetailBean(complaintId, userId, department,
		        			 complaintTitle, complaintDesc, complaintAddress, complaintStatus);
		            complaint1.setComplaintId(complaintId);
		            
		            complaint1.setDepartment(department);
		            complaint1.setComplaintTitle(complaintTitle);
		            complaint1.setComplaintDesc(complaintDesc);
		            complaint1.setComplaintAddress(complaintAddress);
		            complaint1.setComplaintStatus(complaintStatus);
		            
		            return complaint1;
		        } 
		 	       
		        return null;
		    }

	 public static void ChangePassword(Connection conn, String userName ,String userPassword) throws SQLException {
		 
	        String sql = "Update userDetail set userPassword='"+userPassword+"' " //
	                + " where userName ='"+userName+"'";
	 
	        Statement pstm = conn.createStatement();
	        pstm.executeUpdate(sql);
	        }
	 public static void HodChangePassword(Connection conn, String userName ,String userPassword) throws SQLException {
		 
	        String sql = "Update hodDetails set hodPassword='"+userPassword+"' " //
	                + " where hodName ='"+userName+"'";
	 
	        Statement pstm = conn.createStatement();
	        pstm.executeUpdate(sql);
	        }
	 
	 public static void Updatecomplaint(Connection conn, int complaintid, String status) throws SQLException {
		 
	        String sql = "Update userComplaint set complaintStatus='"+status+"' " //
	                + " where complaintId ='"+complaintid+"'";
	 
	        Statement pstm = conn.createStatement();
	        pstm.executeUpdate(sql);
	        }
	 
	 
}
