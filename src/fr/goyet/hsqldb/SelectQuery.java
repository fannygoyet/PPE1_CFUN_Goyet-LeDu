package fr.goyet.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuery {
   
   public static void main(String[] args) {
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection(
            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery(
            "SELECT id, title, author FROM tutorials_tbl");
         
         while(result.next()){
            System.out.println(result.getInt("id")+" | "+
               result.getString("title")+" | "+
               result.getString("author"));
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }
}