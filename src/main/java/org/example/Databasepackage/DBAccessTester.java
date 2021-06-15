package org.example.Databasepackage;

import org.example.App;

import java.io.IOException;
import java.sql.Connection;

public class DBAccessTester {


    public static void main(String[] args) {
        DatabaseConnection cdns = new DatabaseConnection();

        Connection connection = cdns.getMYSQLConnection("client","henning","SundhedsteknologiDB");
        DBAccess dba = new DBAccess(connection);
        //

       // dba.insertUser("Niels@dtu.dk","Jakson");

      String[] combo=  dba.getUserAndPassword("Niels@dtu.dk","Jakson");

      String password = "Jakson";
      String Mail="Niels@dtu.dk";

      if(combo[1].equals(password)&& combo[0].equals(Mail) ){

      }

        System.out.println(combo[0]+combo[1]);
    }
}
