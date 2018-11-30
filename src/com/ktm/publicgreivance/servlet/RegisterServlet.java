package com.ktm.publicgreivance.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktm.publicgreivance.bean.UserDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;

import java.sql.Connection;


@WebServlet(urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	public RegisterServlet(){
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
	    		
	            	 RequestDispatcher dispatcher 
	            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");

	            	 dispatcher.forward(request, response);
	    	}catch(Exception e){
	    		System.out.print(e);
	    	}
	    }
	    protected void doPost(HttpServletRequest request,HttpServletResponse response){
	    	try{
	    		
	    		Connection conn = MyUtils.getStoredConnection(request);
	    		String username = request.getParameter("name");
	            String age = request.getParameter("age");
	            String emailid = request.getParameter("emailId");
	            String phoneno = request.getParameter("phoneNumber");
	            String password = request.getParameter("password");
	            String confirmpassword = request.getParameter("confirmPassword");
	            String errorString=null;
	             
	            if (username.isEmpty() || password.isEmpty() || age.isEmpty() || emailid.isEmpty()|| phoneno.isEmpty()
	            		|| confirmpassword.isEmpty()){
	            	errorString ="Please Enter all the fields...";
	            	 request.setAttribute("errorString", errorString);
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
	        
	                   dispatcher.forward(request, response);
	        
	            }else if(password.equals(confirmpassword) && MyUtils.isValid(emailid)){
	            	if(phoneno.length() == 10) {
	            	UserDetailBean udb=new UserDetailBean(username,age,emailid,phoneno,password);	
	            	String text1="\t\t\tPublic Grievance System"+"\n\n"+"Dear Citizen,";
	                String text="You have registered in Public Grievance System";
	                String end="Regards,"+"\n"+"Public Grievance System.";
	                String complaint=text1+"\n\n"+text+"\n"+"Your Access code:"	+"\n\n"+"\tEmail id: "+emailid+"\n"+
	                							"\tPassword: "+password+"\n\n"+end;
	                System.out.println(udb.getEmailid());
	                String email=EmailUtilityServlet.sendEmail(host, port, user, pass, udb.getEmailid(), "Public Grievance System",
		              		complaint);
	                if(email=="Success") {
	                	DBUtils.insertUser(conn, udb);
	                	 request.setAttribute("successMessage", "Registered Successfully");
		            	RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			            rd1.forward(request,response);
		               }else {
		            	    request.setAttribute("errorString", email);
			            	RequestDispatcher dispatcher //
			                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
			                dispatcher.forward(request, response);
		               }
	            	}else {
	            		errorString ="Phone number should be 10 numbers";
		            	 request.setAttribute("errorString", errorString);
		            	   RequestDispatcher dispatcher //
		                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
		        
		                   dispatcher.forward(request, response);	            		
	            	}
	            }else{
	            	errorString ="Email id inValid or Password doesn't match";
	            	 request.setAttribute("errorString", errorString);
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
	        
	                   dispatcher.forward(request, response);
	            } 
	    	}catch(Exception e){
	    		System.out.print(e);
	    	}
	    }
}
