package com.kichigin.laba4.authors.test;

import com.kichigin.laba4.authors.connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetAllRows {

    public static void main(String[] args) {

        try{

            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM Authors";
            System.out.println("Authors:");
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                int id = resultSet.getInt("authorID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
