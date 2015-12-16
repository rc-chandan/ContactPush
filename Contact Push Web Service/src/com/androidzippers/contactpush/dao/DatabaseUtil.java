package com.androidzippers.contactpush.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database object to get connection
 * @author Chandan Kumar Rana
 */
public class DatabaseUtil {

    private static Connection con;
    private static final String Driver = "oracle.jdbc.driver.OracleDriver";
    private static final String ConnectionString = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String user = "system";
    private static final String pwd = "password";

    /**
     * to connect to the database
     * @return a database connection
     * @throws SQLException throws an exception if an error occurs
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        con = DriverManager.getConnection(ConnectionString, user, pwd);
        System.out.println("db connected.");
        return con;
    }
}