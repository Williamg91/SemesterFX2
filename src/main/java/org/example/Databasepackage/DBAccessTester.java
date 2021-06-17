package org.example.Databasepackage;

import org.example.App;

import java.io.IOException;
import java.sql.Connection;


public class DBAccessTester {


    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        //dårlig navngivning ? opret et objekt, der kan give en forbindelse.
        Connection connection = databaseConnection.getMYSQLConnection("client","henning","SundhedsteknologiDB");
        //brug en bruger kaldet client, med passwordet henning, i schemaet SundhedsteknologiDB.
        DBAccess dba = new DBAccess(connection);
        //Lav et objekt af DBAccess klassen, så vi kan bruge dens metoder
        String Mail="John@dillermand.dk";
        String password = "badedragt";
        //Kan ændres
       // dba.insertUser(Mail,password);
        //kald metoden til at sætte ind i databasen
      String[] combo=  dba.getUserAndPassword(Mail,password);
      //kald metoden til at få et svar tilbage fra databasen
      if(combo[1].equals(password)&& combo[0].equals(Mail) ){

          String url_open ="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
          try {
              java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
          } catch (IOException e) {
              e.printStackTrace();
          }
          System.out.println(combo[0]+combo[1]+"er et match");
      }


    }
}
