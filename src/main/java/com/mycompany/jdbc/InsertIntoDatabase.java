package com.mycompany.jdbc;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoDatabase{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/practise";
        String user = "root";
        String password = "StrongPass123";
        System.out.println("Connecting to database...");
        DataInputStream dis=new DataInputStream(System.in);
        try {

            System.out.println("Enter the id of the new employee");
            String empid=dis.readLine();
            System.out.println("Enter the name of the new employee");
            String empname=dis.readLine();
            System.out.println("Enter the email of the new employee");
            String empmail=dis.readLine();


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database...");

            Statement stmt=conn.createStatement();
            String insertquery="insert into emp (emp_id,emp_name,emp_mail) values("+empid+",'"+empname+"','"+empmail+"')";
//            stmt.executeQuery(insertquery);
            int rowsAffected=stmt.executeUpdate(insertquery);
            if(rowsAffected==1){
                System.out.println("Added Succeessfully");
            }
            conn.close();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
