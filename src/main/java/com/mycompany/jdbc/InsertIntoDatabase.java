package com.mycompany.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertIntoDatabase{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/practise";
        String user = "root";
        String password = "StrongPass123";
        System.out.println("Connecting to database...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database...");



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
