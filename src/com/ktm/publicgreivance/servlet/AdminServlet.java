package com.ktm.publicgreivance.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.HodDetailBean;
import com.ktm.publicgreivance.utils.MyUtils;


@WebServlet(urlPatterns = { "/adminInfo" })

public class AdminServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 	
	public AdminServlet(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	    	try{
	      // /WEB-INF/views/userInfoView.jsp
	    		  System.out.println("loginuser");
	    	    HttpSession session = request.getSession();
	    		 
	    	        // Check User has logged on
	    	    HodDetailBean loginedHod = MyUtils.getLoginedHod(session);
	    	    System.out.println("loginHod");
	    	    System.out.println(loginedHod);
	    	    if(loginedHod.equals(" "))
	    	    {
	    	    	RequestDispatcher dispatcher 
	                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/othersLoginView.jsp");
	        		dispatcher.forward(request, response);
	    	    	
	    		}else{
	    		request.setAttribute("user", loginedHod);
	        	RequestDispatcher dispatcher 
	                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminView.jsp");
	        	dispatcher.forward(request, response);
	    	    }
	         
	    	}catch(NullPointerException e){
	    		try{
	    			response.sendRedirect(request.getContextPath() + "/othersLogin");
	    		}catch(Exception e1){
	    			System.out.println(e1);
	    		}
	    	}
	    	catch(Exception e){
	    		System.out.println(e);
	    	}
	    	
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	          {
	    	try{
	    		doGet(request, response);	
	    	}catch(Exception e){
	    		System.out.println(e);
	    	}
	        
	    }
}
