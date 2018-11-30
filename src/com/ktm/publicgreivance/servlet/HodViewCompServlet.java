package com.ktm.publicgreivance.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.HodDetailBean;
import com.ktm.publicgreivance.bean.ViewComplaintBean;
import com.ktm.publicgreivance.utils.DBUtils;
import com.ktm.publicgreivance.utils.MyUtils;

@WebServlet(urlPatterns = { "/hodviewCompList" })
public class HodViewCompServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
 
    public HodViewCompServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         { try{
        	
        	 HttpSession session = request.getSession();
    		 
 	        // Check User has logged on
 	    HodDetailBean loginedhod = MyUtils.getLoginedHod(session);
 	    System.out.println("loginuser");
 	    System.out.println(loginedhod);
 	    if(loginedhod.equals(" "))
 	    {
 	    	RequestDispatcher dispatcher 
              = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
     		dispatcher.forward(request, response);
 	    	
 		}else{
 	
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
       
        List<ViewComplaintBean> list = null;
        
        try {
        	//int userId=DBUtils.findUserId(conn, loginedUser.getUsername());
            list = DBUtils.hodqueryComplaint(conn,loginedhod.getHoddept());
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("adminViewComplaintList", list);
        System.out.println(list);
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/hodViewCompView.jsp");
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
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
     { try{
    	doGet(request, response);
     }catch(Exception e){
    	 System.out.println(e);
     }
    }
 
}