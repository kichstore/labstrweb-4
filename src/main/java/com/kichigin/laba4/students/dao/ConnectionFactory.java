package com.kichigin.laba4.students.dao;

import com.kichigin.laba4.students.util.StudentsConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(StudentsConstants.URL, StudentsConstants.USER, StudentsConstants.PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return connection;
    }
}
