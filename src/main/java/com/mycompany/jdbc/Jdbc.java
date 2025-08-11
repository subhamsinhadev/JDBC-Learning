/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbc;

/**
 *
 * @author subham
 */
import java.sql.*;
import java.io.*;

public class Jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/practise";
        String user = "root";
        String password = "StrongPass123";
        System.out.println("Connecting to database...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
           while (rs.next()) {
               System.out.println("Id:"+rs.getString(1));
               System.out.println("Name:"+rs.getString(2));
               System.out.println("Email:"+rs.getString(3)+"\n");
//               System.out.println(rs.getString(4));
           }

//            System.out.println("✅ Connected successfully!");
            conn.close();

           //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
