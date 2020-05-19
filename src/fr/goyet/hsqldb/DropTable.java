package fr.goyet.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropTable {
   public static void main(String[] args) {
      Connection con = null;
      Statement stmt = null;
      int result = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeUpdate("DROP TABLE employee");
      }catch (Exception e) {
         e.printStackTrace(System.out);
      }
      
      System.out.println("Table dropped successfully");
   }
}
