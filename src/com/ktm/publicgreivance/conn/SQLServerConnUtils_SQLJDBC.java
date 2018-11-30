package com.ktm.publicgreivance.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SQLServerConnUtils_SQLJDBC {
 
    // Connect to SQL Server.
    // (Using JDBC Driver: SQLJDBC)
    public static Connection getSQLServerConnection_SQLJDBC() //
            throws ClassNotFoundException, SQLException {
 
        // Note: Change the connection parameters accordingly.
        String userName = "sa";
        String password = "1234";
        
        return getSQLServerConnection_SQLJDBC(userName, password);
    }
 
    // Connect to SQLServer, using SQLJDBC Library.
    private static Connection getSQLServerConnection_SQLJDBC(String userName, String password)//
            throws ClassNotFoundException, SQLException {
 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
        // Example:
        // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
        String connectionURL = "jdbc:sqlserver://LATITUDE"+";databaseName=publicGrievanceSystem";
 
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        System.out.println("connection");
        return conn;
    }
 
}