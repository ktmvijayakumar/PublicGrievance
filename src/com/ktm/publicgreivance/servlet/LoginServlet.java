package com.ktm.publicgreivance.servlet;


import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.UserDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;
 
@WebServlet(urlPatterns={"/login"})
public class LoginServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
    public LoginServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
    	try{
            	 RequestDispatcher dispatcher 
            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

            	 dispatcher.forward(request, response);
    	}catch(Exception e){
    		System.out.print(e);
    	}
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response){
    	try{
    		String emailid = request.getParameter("emailid");
            String password = request.getParameter("password");
            String errorString=null;
            UserDetailBean user=null;
            if (emailid.isEmpty() || password.isEmpty()) {
            	errorString ="Please Enter all the fields...";
            	   request.setAttribute("errorString", errorString);
            	   RequestDispatcher dispatcher //
                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        
                   dispatcher.forward(request, response);
            }else{
            	 Connection conn = MyUtils.getStoredConnection(request);
                 try {
                     // Find the user in the DB.
                	// System.out.println("login");
                     user = DBUtils.findUser(conn, emailid, password);
                     System.out.println("login");
                     if (user == null) {	           
                         errorString = "Email id or password invalid";
                         request.setAttribute("errorString", errorString);
                         RequestDispatcher dispatcher //
                                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
                         dispatcher.forward(request, response);
              
                     }else{
                    	 System.out.println("login");
                    	 HttpSession session = request.getSession();
                         MyUtils.storeLoginedUser(session, user);
                         System.out.println( user); 
                    	 response.sendRedirect(request.getContextPath() + "/userInfo");
                    	 
                     }
                 } catch (SQLException e) {
                     e.printStackTrace();
                     errorString = e.getMessage();
                 }
            	//response.sendRedirect(request.getContextPath() + "/userInfo");
            }
    	}catch(Exception e){
    		System.out.print(e);
    	}
    }
}