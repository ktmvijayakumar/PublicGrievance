package com.ktm.publicgreivance.utils;

import java.sql.Connection;
 
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ktm.publicgreivance.bean.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MyUtils {
 
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
    // Store Connection in request attribute.
    // (Information stored only exist during requests)
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    // Get the Connection object has been stored in attribute of the request.
    public static Connection getStoredConnection(ServletRequest request) {
    	//System.out.println(ATT_NAME_CONNECTION);
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
 
    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, UserDetailBean loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }
 
    // Get the user information stored in the session.
    public static UserDetailBean getLoginedUser(HttpSession session) {
    	UserDetailBean loginedUser = (UserDetailBean) session.getAttribute("loginedUser");
        return loginedUser;
    }
    public static void storeLoginedHod(HttpSession session, HodDetailBean loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedHod", loginedUser);
    }
 
    // Get the user information stored in the session.
    public static HodDetailBean getLoginedHod(HttpSession session) {
    	HodDetailBean loginedHod = (HodDetailBean) session.getAttribute("loginedHod");
        return loginedHod;
    }
 
    // Store info in Cookie
    public static void storeUserCookie(HttpServletResponse response, UserDetailBean user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUsername());
        // 1 day (Converted to seconds)
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }
 
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 seconds (This cookie will expire immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
    
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}