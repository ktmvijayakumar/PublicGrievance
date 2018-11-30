package com.ktm.publicgreivance.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktm.publicgreivance.bean.HodDetailBean;
import com.ktm.publicgreivance.utils.MyUtils;

@WebServlet("/adminlogout")
public class AdminLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AdminLogoutServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       {
    	try{
    		
        HttpSession session=request.getSession();
        HodDetailBean loginedUser = MyUtils.getLoginedHod(session);
        session.removeAttribute(loginedUser.getHodname());
        session.invalidate();
        // Redrect to Home Page.
        response.sendRedirect(request.getContextPath() + "/login");
    	}
    	catch(Exception e){
    		System.out.println(e);
    		try{
    		        response.sendRedirect(request.getContextPath() + "/login");
    		}catch(Exception e1){
    			System.out.println(e1);
    		}
    	}
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             {
    	try{
        this.doGet(request, response);
    	}
        catch(Exception e){
        	System.out.println(e);
        }
    	}
}