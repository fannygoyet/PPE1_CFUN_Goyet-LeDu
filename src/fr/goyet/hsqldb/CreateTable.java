package fr.goyet.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
   
   public static void main(String[] args) {
      
      Connection con = null;
      Statement stmt = null;
      int result = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
         stmt = con.createStatement();
         
         result = stmt.executeUpdate("CREATE TABLE Salles ( " +
        		 " idSalle INT NOT NULL PRIMARY KEY, " +
        		 " nomSalle VARCHAR(40), " +
        		 " places INT, " +
        		 " placesOccupees INT); ");

         result += stmt.executeUpdate("CREATE TABLE Billets( " + 
        		 " idBillet BIGINT PRIMARY KEY NOT NULL, " +
        		 " type BOOLEAN, " +
        		 " salleConcernee VARCHAR(40), " +
        		 " date DATE, " +
        		 " montant REAL DEFAULT NULL); ");

			
      }  catch (Exception e) {
         e.printStackTrace(System.out);
      }
      System.out.println("Table created successfully");
   }
}