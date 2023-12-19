package com.kichigin.laba4.authors.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.kichigin.laba4.authors.util.Constants.*;


public class JDBC {

    public static Connection connection = null;

    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        if (connection == null) {
            throw new SQLException();
        } else {
            System.out.println("Successfully connected");
        }
    }


    public static void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }

}