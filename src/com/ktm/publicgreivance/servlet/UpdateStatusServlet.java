package com.ktm.publicgreivance.servlet;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktm.publicgreivance.bean.complaintDetailBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;


@WebServlet(urlPatterns = { "/updateStatus" })
public class UpdateStatusServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	public UpdateStatusServlet(){
		super();
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        { try
	        {	        	
		        Connection conn = MyUtils.getStoredConnection(request);
		        System.out.println("conn");
		        String complaintId=(String) request.getParameter("complaintId");
		        System.out.println(complaintId);
		        int compid=Integer.parseInt(complaintId);
		        complaintDetailBean cdb = DBUtils.findComplaint(conn,compid);
		        request.setAttribute("complaint", cdb);
		        
		        RequestDispatcher dispatcher = request.getServletContext()
		                .getRequestDispatcher("/WEB-INF/views/updateComplaintView.jsp");
		        dispatcher.forward(request, response);
	        }catch(Exception e){
	        	System.out.println(e);
	        }
	 }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	          {try{
	        	  Connection conn = MyUtils.getStoredConnection(request);
	        	  String complaintId=(String)request.getParameter("complaintId");
	        	  System.out.println(complaintId);
	        	  int compid=Integer.parseInt(complaintId);
	        	  String errorString=null;
	        	  String status=(String)request.getParameter("status");
	        	  System.out.println(status);
	        	  if(status.isEmpty()){
	        		  errorString ="Please Enter the fields...";
	            	   request.setAttribute("errorString", errorString);
	            	   complaintDetailBean cdb = DBUtils.findComplaint(conn,compid);
	       	        request.setAttribute("complaint", cdb);
	       	        
	       	       
	            	   RequestDispatcher dispatcher //
	                           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateComplaintView.jsp");
	        
	                   dispatcher.forward(request, response);
	        	  }else{
	        	  DBUtils.Updatecomplaint(conn, compid, status);
	        	  response.sendRedirect(request.getContextPath() + "/hodviewCompList");
	        	  }
	        }catch(Exception e){
	        	  System.out.println(e);
	          }
	       
	 }
}