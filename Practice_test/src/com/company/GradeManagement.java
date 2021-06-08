/*
package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeManagement {
    // save a student to student table
    public static void saveStudent(Student student) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root",
                    "A@12345abc");

            Statement stmt = con.createStatement();
            int signal = stmt.executeUpdate("INSERT INTO students values(" + student.getId() + ",'" + student.getName()
                    + "'," + student.getGrade() + ")");
            System.out.println(signal);

            // version 2: prepareStatement
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // get all the students from the student table
    // connection pool
    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grade_management_system", "root",
                    "A@12345abc");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // get a student by id
    //  make sure student(id) ... exist in this table
    public static Student getStudentById_db1(int id) {
        Student result = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root",
                    "A@12345abc");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id=" + id);
            while (rs.next()) {
                result = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Student> getStudents_db1() {
        List<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root",
                    "A@12345abc");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return students;
    }



    public static Student getStudentById_db2(int id) {
        Student result = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root",
                    "A@12345abc");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id=" + id);
            while (rs.next()) {
                result = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



    public static List<Student> getStudents_db2() {
        List<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root",
                    "A@12345abc");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return students;
    }





    public static void main(String[] args) {
        getStudentById_db1(999);
        getStudentById_db2(999);
    }


}
*/
