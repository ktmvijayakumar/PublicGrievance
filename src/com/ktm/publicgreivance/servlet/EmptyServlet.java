package com.ktm.publicgreivance.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.UserDetailBean;
import com.ktm.publicgreivance.utils.MyUtils;

@WebServlet(urlPatterns = { "/userInfo" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class EmptyServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	public EmptyServlet(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	    	try{
	    		System.out.println("loginuser");
	    	    HttpSession session = request.getSession();
	    	    UserDetailBean loginedUser = MyUtils.getLoginedUser(session);
	    	    System.out.println(loginedUser);
	    	    if(loginedUser.equals(" "))
	    	    {
	    	    	RequestDispatcher dispatcher 
	                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
	        		dispatcher.forward(request, response);
	    	    }else{
		    		request.setAttribute("user", loginedUser);
		        	RequestDispatcher dispatcher 
		                 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userView.jsp");
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
