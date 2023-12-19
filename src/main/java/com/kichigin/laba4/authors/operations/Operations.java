package com.kichigin.laba4.authors.operations;


import com.kichigin.laba4.authors.connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operations {

    // 1: Сделайте выборку по авторам, отсортировав по их Имени и Фамилии
    public static void selectAuthors() {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();

            String selectAuthors = "SELECT * FROM Authors ORDER BY firstName, lastName";
            ResultSet resultSet = stmt.executeQuery(selectAuthors);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    // 2: Добавьте нового Издателя
    public static void addPublisher(String publisherName) {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();

            String addPublisher = "INSERT INTO Publishers (publisherName) VALUES ('" + publisherName + "')";
            stmt.executeUpdate(addPublisher);

            System.out.println("Added new publisher: " + publisherName);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    // 3: Сделайте выборку Издателей и измените имя определенного Издателя
    public static void updatePublisherName(String oldName, String newName) {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();

            String updatePublisher = "UPDATE Publishers SET publisherName = '" + newName +
                    "' WHERE publisherName = '" + oldName + "'";
            stmt.executeUpdate(updatePublisher);

            System.out.println("Updated publisher name from " + oldName + " to " + newName);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    // 4: Предоставьте отсортированный список книг определенного издателя
    public static void selectBooksByPublisher(int publisherID) {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();

            String selectBooks = "SELECT * FROM Titles WHERE publisherID = " + publisherID + " ORDER BY title";
            ResultSet resultSet = stmt.executeQuery(selectBooks);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    // 5: Выполните добавление Нового автора в БД
    public static void addAuthor(String firstName, String lastName) {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();

            String addAuthor = "INSERT INTO Authors (firstName, lastName) VALUES ('" + firstName + "', '" + lastName + "')";
            stmt.executeUpdate(addAuthor);

            System.out.println("\nAdded new author: " + firstName + " " + lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    // 6: Обновите Имя автора по определенному id
    public static void updateAuthorName(int authorID, String newFirstName, String newLastName) {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();

            String updateAuthor = "UPDATE Authors SET firstName = '" + newFirstName + "', lastName = '" + newLastName +
                    "' WHERE authorID = " + authorID;
            stmt.executeUpdate(updateAuthor);

            System.out.println("\nUpdated author name for authorID " + authorID);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }


    public static void main(String[] args) {

        selectAuthors();
        System.out.println("\n--------------------------\n");

        addPublisher("NEW PUBLISHER ");
        System.out.println("\n--------------------------\n");

        updatePublisherName("NEW PUBLISHER", "PUBLISHER");
        System.out.println("\n--------------------------\n");

        selectBooksByPublisher(1);
        System.out.println("\n--------------------------\n");

        addAuthor("New", "Author");
        System.out.println("\n--------------------------\n");

        updateAuthorName(1, "Updated", "Author");

    }


}
