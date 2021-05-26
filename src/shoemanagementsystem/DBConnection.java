/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
      public static Connection getConnection()
{
    Connection conn=null;
   try{
    Class.forName("com.mysql.cj.jdbc.Driver"); 

     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectDB?","root","12345");
   return conn;
   }
   catch(Exception e)
   {
       System.out.println(e);  
       return null;
   }
}    
}
