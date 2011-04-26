package com.floreantpos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class DBConnect
{
   private static String dbURL = "jdbc:derby://10.66.9.123:1527/posdb;create=true;user=app;password=sa";
   private static String tableName = "TICKET";
   // jdbc Connection
   private static Connection conn = null;
   private static Statement stmt = null;
   public static String foo;

   public static void main(String[] args)
   {
       createConnection();
       
       //insertRestaurants(5, "LaVals", "Berkeley");
       //selectRestaurants();
       //shutdown();
   }
  
   public static void createConnection()
   {
       try
       {
           Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
           //Get a connection
           conn = DriverManager.getConnection(dbURL);
           foo = new String("Woo!!!");
       }
       catch (Exception except)
       {
           except.printStackTrace();
           foo = new String("Boo!!!");
       }
   }
}