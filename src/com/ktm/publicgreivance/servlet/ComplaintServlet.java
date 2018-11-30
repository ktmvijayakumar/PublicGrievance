package com.ktm.publicgreivance.servlet;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.UserDetailBean;
import com.ktm.publicgreivance.bean.complaintDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;


@WebServlet(urlPatterns={"/complaint"})
public class ComplaintServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	public ComplaintServlet(){
		super();
	}
	private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
        System.out.println(host+port+user+pass);
    }
 
	
	 protected void doGet(HttpServletRequest request,HttpServletResponse response){
	    	try{
	    		HttpSession session = request.getSession();
	    		// Check User has logged on
	    		UserDetailBean loginedUser = MyUtils.getLoginedUser(session);
	    		
	    		System.out.println("loginuser");
	    	    System.out.println(loginedUser);
	    	    if(loginedUser.equals(" "))
	    	    {
	    	    	RequestDispatcher dispatcher 
	                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
	        		dispatcher.forward(request, response);
	    	    	
	    		}else{		 
	    		RequestDispatcher dispatcher 
	            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/complaintView.jsp");

	            	 dispatcher.forward(request, response);
	    	}
	    	}catch(NullPointerException e){
	    		try{
	    			response.sendRedirect(request.getContextPath() + "/login");
	    		}catch(Exception e1){
	    			System.out.println(e1);
	    		}
	    	}
	    	catch(Exception e){
	    		System.out.print(e);
	    	}
	    }
	    protected void doPost(HttpServletRequest request,HttpServletResponse response){
	    	try{
	    		Connection conn = MyUtils.getStoredConnection(request);
	    		HttpSession session = request.getSession();
	    		// Check User has logged on
	    		UserDetailBean loginedUser = MyUtils.getLoginedUser(session);
	    		String department = request.getParameter("department");
	            String complainttitle = request.getParameter("complaintTitle");
	            String complaintdesc = request.getParameter("complaintDesc");
	            String complaintaddress = request.getParameter("complaintAddress");
	            System.out.println(loginedUser.getUsername());
	            int userId=DBUtils.findUserId(conn, loginedUser.getUsername());
	            String errorString=null;
	            int complaintId=0;
	            String complaintStatus="Bending...";
	            
	            if (department.isEmpty() || complainttitle.isEmpty() || complaintdesc.isEmpty() || complaintaddress.isEmpty()){
	            	errorString ="Please Enter all the fields...";
	            	 request.setAttribute("errorString", errorString);
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/complaintView.jsp");
	        
	                   dispatcher.forward(request, response);	        
	            }else{ 
	            	
	            	complaintDetailBean cdb=new complaintDetailBean(complaintId,userId,department,complainttitle,complaintdesc,
	            			complaintaddress,complaintStatus);	 	            
	                System.out.println(host+port+user+pass);
	                String text1="\t\t\tPublic Grievance System"+"\n\n"+"Dear Citizen,";
	                String end="Regards,"+"\n"+"Public Grievance System.";
	                String text="You have registered complaint about "+department+" deparment";
	                String complaint=text1+"\n\n"+text+"\n\n"+"\tComplaint Title: "+complainttitle+"\n"+
	                							"\tComplaint Description: "+ complaintdesc+"\n"+
	                							"\tComplaint Address: "+ complaintaddress+"\n"+
	                							"\tComplaint Status: "+complaintStatus+"\n\n\n"+
	                							end;
	                String email=EmailUtilityServlet.sendEmail(host, port, user, pass, loginedUser.getEmailid(), complainttitle,
	              		complaint);
	               if(email=="Success") {
	            	DBUtils.insertComplaint(conn, cdb);
	            	 request.setAttribute("successMessage", "Complaint Passed...");
	                request.setAttribute("user", loginedUser);
	            	RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/userView.jsp");
		            rd1.forward(request,response);
	               }else {
	            	   request.setAttribute("errorString", email);
		            	RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/complaintView.jsp");
			            rd1.forward(request,response);
	               }
	            }
	    	}catch(Exception e){
	    		System.out.print(e);
	    	}
	    }

}
