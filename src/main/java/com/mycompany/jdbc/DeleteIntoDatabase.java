package com.mycompany.jdbc;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteIntoDatabase {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/practise";
        String user="root";
        String password="StrongPass123";
        System.out.println("Connecting to database...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,password);
            Statement stmt=conn.createStatement();
            DataInputStream dis=new DataInputStream(System.in);
            //getting id
            System.out.println("Enter id of the employee you want to delete");
            String id=dis.readLine();

            int x= stmt.executeUpdate("delete from emp where emp_id='"+id+"'");
            if(x>0){
                System.out.println("Employee deleted successfully");
            }else {
                System.out.println("Employee not deleted successfully");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
