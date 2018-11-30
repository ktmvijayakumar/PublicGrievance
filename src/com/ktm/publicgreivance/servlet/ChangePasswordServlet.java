package com.ktm.publicgreivance.servlet;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.UserDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;


@WebServlet(urlPatterns={"/changePassword"})
public class ChangePasswordServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	public ChangePasswordServlet(){
		super();
	}
	 
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
    	try{
    		HttpSession session = request.getSession();
    		// Check User has logged on
    		UserDetailBean loginedUser = MyUtils.getLoginedUser(session);	
    		System.out.println(loginedUser);
    	    if(loginedUser.equals(" "))
    	    {		
    		RequestDispatcher dispatcher 
            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

            	 dispatcher.forward(request, response);
    	
    		}else{		 
    		RequestDispatcher dispatcher 
            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/changePasswordView.jsp");

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
    		String password = request.getParameter("password");
            String cpassword = request.getParameter("cpassword");
            String errorString=null;
            if (cpassword.isEmpty() || password.isEmpty()) {
            	errorString ="Please Enter all the fields...";
            	   request.setAttribute("errorString", errorString);
            	   RequestDispatcher dispatcher //
                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/changePasswordView.jsp");
        
                   dispatcher.forward(request, response);
            }else if(password.equals(cpassword)){
            	Connection conn = MyUtils.getStoredConnection(request);
                try {
                    // Find the user in the DB.
               	// System.out.println("login");
                	HttpSession session = request.getSession();
           		 
         	        // Check User has logged on
               	 	UserDetailBean loginedUser = MyUtils.getLoginedUser(session);
               	 	String user=loginedUser.getUsername();
               	 	System.out.println(user);
               	 	DBUtils.ChangePassword(conn, user, password);
                        request.setAttribute("user", loginedUser);
    	            	RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/views/userView.jsp");
    		            rd1.forward(request,response);    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    errorString = e.getMessage();
                }
           
            }else{
            	errorString ="Password doesn't match...";
            	 request.setAttribute("errorString", errorString);
            	   RequestDispatcher dispatcher //
                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/changePasswordView.jsp");
        
                   dispatcher.forward(request, response);
            }
    	}catch(Exception e){
    		System.out.print(e);
    	}
    }
}
