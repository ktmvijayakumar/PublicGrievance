package com.ktm.publicgreivance.servlet;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.HodDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;

@WebServlet(urlPatterns={"/othersLogin"})
public class OthersLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	public OthersLoginServlet(){
		super();
	}
	
	 protected void doGet(HttpServletRequest request,HttpServletResponse response){
	    	try{
	            	 RequestDispatcher dispatcher 
	            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/othersLoginView.jsp");

	            	 dispatcher.forward(request, response);
	    	}catch(Exception e){
	    		System.out.print(e);
	    	}
	    }
	    protected void doPost(HttpServletRequest request,HttpServletResponse response){
	    	try{
	    		String hodemailid = request.getParameter("hodemailid");
	            String password = request.getParameter("password");
	            String errorString=null;
	            HodDetailBean user=null;
	            if (hodemailid.isEmpty() || password.isEmpty()) {
	            	errorString ="Please Enter all the fields...";
	            	   request.setAttribute("errorString", errorString);
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/othersLoginView.jsp");
	        
	                   dispatcher.forward(request, response);
	            }else{
	            	 Connection conn = MyUtils.getStoredConnection(request);
	                 try {
	                     user = DBUtils.findHod(conn, hodemailid, password);
	                     System.out.println("login");
	                     if (user == null) {	           
	                    	 errorString = "Email id or password invalid";
	                         request.setAttribute("errorString", errorString);
	                         RequestDispatcher dispatcher //
	                                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/othersLoginView.jsp");
	                         dispatcher.forward(request, response);
	         	            
	                     }else{
	                    	 System.out.println("login");
	                    	 HttpSession session = request.getSession();
	                         MyUtils.storeLoginedHod(session, user);
	                         System.out.println( user); 
	                    	 if(user.getHodname().equals("Admin")){
	                    		 request.setAttribute("user", user);
	                    		 RequestDispatcher rd1 = request.getRequestDispatcher("/adminInfo");
	         		             rd1.forward(request,response);   
	                    	 }else{
	                    		 request.setAttribute("user", user);
	                    		 RequestDispatcher rd1 = request.getRequestDispatcher("/hodInfo");
		         		         rd1.forward(request,response);   
	                    	 }
	                    		 
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
