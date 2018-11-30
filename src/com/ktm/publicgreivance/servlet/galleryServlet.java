package com.ktm.publicgreivance.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/gallery" })
public class galleryServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	    public galleryServlet() {
	        super();
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      {
	    	try{     
				  RequestDispatcher dispatcher = request.getServletContext()
				                .getRequestDispatcher("/WEB-INF/views/galleryView.jsp");
				  dispatcher.forward(request, response);
		      	}
	         catch(Exception e){
	        	 System.out.println(e);
	         }
	    }
	 
}
