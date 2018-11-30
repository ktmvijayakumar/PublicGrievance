package com.ktm.publicgreivance.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.UserDetailBean;
import com.ktm.publicgreivance.utils.MyUtils;

@WebServlet(urlPatterns={"/checkStatusId"})
public class CheckStatusIdServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
    public CheckStatusIdServlet() {
        super();
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
            	 	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/checkStatusIdView.jsp");

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
    		String complaintId = request.getParameter("complaintId");
            String errorString=null;
            if (complaintId.isEmpty()) {
            	errorString ="Please Enter all the fields...";
            	   request.setAttribute("errorString", errorString);
            	   RequestDispatcher dispatcher //
                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/checkStatusIdView.jsp");
        
                   dispatcher.forward(request, response);
            }else{
            	 try {
                         request.setAttribute("complaintId", complaintId);
                         RequestDispatcher dispatcher //
                                 = this.getServletContext().getRequestDispatcher("/checkStatus");
                         dispatcher.forward(request, response);
                    	 
                     
                 } catch (Exception e) {
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