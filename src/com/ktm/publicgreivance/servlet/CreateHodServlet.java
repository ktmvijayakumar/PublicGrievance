package com.ktm.publicgreivance.servlet;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.HodDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;

@WebServlet(urlPatterns={"/createHod"})
public class CreateHodServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	public CreateHodServlet(){
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
	    		HodDetailBean loginedHod = MyUtils.getLoginedHod(session);
	    		
	    		System.out.println("loginuser");
	    	    System.out.println(loginedHod);
	    	    if(loginedHod.equals(" "))
	    	    {
	    	    	RequestDispatcher dispatcher 
	                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/othesLoginView.jsp");
	        		dispatcher.forward(request, response);
	    	    	
	    		}else{		 
	            	 RequestDispatcher dispatcher 
	            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/createHodView.jsp");

	            	 dispatcher.forward(request, response);
	    		}
	    	    }catch(NullPointerException e){
		    		try{
		    			response.sendRedirect(request.getContextPath() + "/login");
		    		}catch(Exception e1){
		    			System.out.println(e1);
		    		}
		    	}catch(Exception e){
	    		System.out.print(e);
	    	}
	    	
	    }
	    protected void doPost(HttpServletRequest request,HttpServletResponse response){
	    	try{
	    		
	    		Connection conn = MyUtils.getStoredConnection(request);
	    		HttpSession session = request.getSession();
	    		// Check User has logged on
	    		HodDetailBean loginedHod = MyUtils.getLoginedHod(session);
	    		String username = request.getParameter("name");
	            String age = request.getParameter("age");
	            String emailid = request.getParameter("emailId");
	            String phoneno = request.getParameter("phoneNumber");
	            String password = request.getParameter("password");
	            String confirmpassword = request.getParameter("confirmPassword");
	            String department=request.getParameter("department");
	            String errorString=null;
	            
	           
	            
	            if (username.isEmpty() || password.isEmpty() || age.isEmpty() || emailid.isEmpty()|| phoneno.isEmpty()
	            		|| confirmpassword.isEmpty() || department.isEmpty()){
	            	errorString ="Please Enter all the fields...";
	            	 request.setAttribute("errorString", errorString);
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createHodView.jsp");
	        
	                   dispatcher.forward(request, response);
	        
	            }else if(password.equals(confirmpassword) && phoneno.length() == 10 && MyUtils.isValid(emailid)){
	            	HodDetailBean udb=new HodDetailBean(username,age,emailid,phoneno,password,department);	
	            	String text1="\t\t\tPublic Grievance System";
	            	String text="You are HOD of the "+department+" department in Public Grievance System";
	            	String end="Regards,"+"\n"+"Public Grievance System.";
		                String complaint=text1+"\n\n"+text+"\n"+"Your Access code:"	+"\n\n"+"\tEmail id: "+emailid+"\n"+
		                							"\tPassword: "+password+"\n\n"+end;
		                System.out.println(udb.getHodemailid());
		                String email=EmailUtilityServlet.sendEmail(host, port, user, pass, udb.getHodemailid(), "Public Grievance System",
			              		complaint);
		                if(email=="Success") {
		                	DBUtils.insertHod(conn, udb);
				                
		                	 request.setAttribute("user", loginedHod);
		 	            	RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/adminView.jsp");
		 		            rd1.forward(request,response);
			               }else {
			            	   
				            	 request.setAttribute("errorString", email);
				            	   RequestDispatcher dispatcher //
				                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createHodView.jsp");
				        
				                   dispatcher.forward(request, response);
				        }
	            	
	               
		            
	            }else{
	            	errorString ="Email invalid or Password doesn't match or Phone Number should be equal to 10";
	            	 request.setAttribute("errorString", errorString);
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createHodView.jsp");
	        
	                   dispatcher.forward(request, response);
	            } 
	    	}catch(Exception e){
	    		System.out.print(e);
	    	}
	    }
}
