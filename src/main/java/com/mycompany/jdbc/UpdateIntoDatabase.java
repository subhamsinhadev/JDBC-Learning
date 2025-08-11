package com.mycompany.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateIntoDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/practise";
        String user = "root";
        String password = "StrongPass123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,password);
            String info= String.valueOf(conn.getClass());
            System.out.println("Connected to database ");
            DataInputStream dis=new DataInputStream(System.in);
            System.out.println("Enter ID Of Employee Which Name Has To Be Updated");
            String newid=dis.readLine();
            System.out.println("Enter New Name Of Employee"+newid);
            String newname=dis.readLine();

            //query
            Statement stmt=conn.createStatement();
          int x=  stmt.executeUpdate("UPDATE  emp set emp_name='"+newname+"'where emp_id="+newid+"");

            if(x>0){
                System.out.println("Employee Updated Successfully");
            }else {
                System.out.println("Employee Not Updated Successfully");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
