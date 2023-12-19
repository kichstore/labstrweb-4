package com.kichigin.laba4.students.action;

import com.kichigin.laba4.students.dao.StudentDao;
import com.kichigin.laba4.students.model.Student;

import java.sql.SQLException;
import java.util.List;


public class StudentAction {

    StudentDao studentDao = new StudentDao();
    int status;

    public void insert(Student student) throws SQLException {
        status = studentDao.insert(student);
        if (status > 0)
            System.out.println("Student Inserted Successfully");
        else
            System.out.println("Unable to Insert Student");
    }

    public void update(Student student) throws SQLException {
        status = studentDao.update(student);
        if (status > 0) {
            System.out.println("Student Updated Successfully");
        } else {
            System.out.println("Unable to update Student");
        }
    }

    public void delete(Long id) throws SQLException {
        status = studentDao.delete(id);
        if (status == 1) {
            System.out.println("Student Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }

    public void fetchById(Long id) throws SQLException {
        Student student = studentDao.fetchById(id);
        if (student.getId() == 0) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Student Details are :");
            System.out.println(student);
        }
    }

    public void fetchByPhoneNumber(String phoneNumber) throws SQLException {
        List<Student> studentList = studentDao.fetchByPhoneNumber(phoneNumber);
        if (studentList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Student Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void searchByFirstName(String firstName) throws SQLException {
        List<Student> studentList = studentDao.searchByFirstName(firstName);
        if (studentList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Student Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }

    }


    public void fetchAll() throws SQLException {
        List<Student> studentList = studentDao.fetchAll();
        if (studentList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Student Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

}


