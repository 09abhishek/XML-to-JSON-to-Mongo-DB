package com.abhi.XMLtomySQL;

import java.sql.*;
import java.util.Calendar;

public class MysqlPreparedStatement
{

  public static void main(String[] args)
  {
    try
    {
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost/mydb";
    	String username = "root";
    	String password = "root";
    	Class.forName(driver); Connection conn = DriverManager.getConnection(url,username,password);
    
      // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
      String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
        + " values (?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString (1, "Abhishek");
      preparedStmt.setString (2, "Gautam");
      preparedStmt.setDate   (3, startDate);
      preparedStmt.setBoolean(4, false);
      preparedStmt.setInt    (5, 5000);

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}
