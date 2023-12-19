package com.kichigin.laba4.students.dao;

import com.kichigin.laba4.students.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {

    Connection connection = null;
    PreparedStatement prepareStatement = null;
    ResultSet resultSet = null;
    int status;

    public int insert(Student student) throws SQLException {

        connection = ConnectionFactory.getConnection();

        try {
            String query = "insert into student(first_name,last_name,phone_number) "
                    + "values(?,?,?)";
            prepareStatement = connection.prepareStatement(query);

            prepareStatement.setString(1, student.getFirstName());
            prepareStatement.setString(2, student.getLastName());
            prepareStatement.setString(3, student.getPhoneNumber());

            status = prepareStatement.executeUpdate();
            System.out.println("inserted student " + status);

        } catch (Exception e) {
            e.printStackTrace();

        }

        connection.close();
        return status;

    }

    public int update(Student student) throws SQLException {

        connection = ConnectionFactory.getConnection();

        try {

            String query = "update student set first_name=?,last_name=?,phone_number=? where id=? ";

            prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, student.getFirstName());
            prepareStatement.setString(2, student.getLastName());
            prepareStatement.setString(3, student.getPhoneNumber());
            prepareStatement.setLong(4, student.getId());

            status = prepareStatement.executeUpdate();
            System.out.println("updated student " + status);

        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
        return status;
    }

    public int delete(long id) throws SQLException {

        connection = ConnectionFactory.getConnection();

        try {

            String query = "delete from student where id=? ";
            prepareStatement = connection.prepareStatement(query);
            prepareStatement.setLong(1, id);
            status = prepareStatement.executeUpdate();
            System.out.println("deleted student " + status);

        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
        return status;

    }

    public Student fetchById(long id) throws SQLException {

        Student student = new Student();
        connection = ConnectionFactory.getConnection();

        try {

            String query = "select * from student where id=?";
            prepareStatement = connection.prepareStatement(query);

            prepareStatement.setLong(1, id);
            resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
        return student;

    }


    public List<Student> fetchByPhoneNumber(String phoneNumber) throws SQLException {

        List<Student> students = new ArrayList<>();
        connection = ConnectionFactory.getConnection();

        try {
            String query = "select * from student where phone_number=?";
            prepareStatement = connection.prepareStatement(query);

            prepareStatement.setString(1, phoneNumber);
            resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
        return students;

    }

    public List<Student> searchByFirstName(String firstName) throws SQLException {

        List<Student> studentList = new ArrayList<>();
        connection = ConnectionFactory.getConnection();

        try {

            String query = "select * from student where first_name like ?";
            prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, firstName);
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
        return studentList;

    }


    public List<Student> fetchAll() throws SQLException {

        List<Student> studentList = new ArrayList<>();

        connection = ConnectionFactory.getConnection();
        try {

            String query = "select * from student";
            prepareStatement = connection.prepareStatement(query);
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
        return studentList;

    }

}
