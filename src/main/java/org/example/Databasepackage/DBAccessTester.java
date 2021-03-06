package org.example.Databasepackage;

import org.example.App;

import java.io.IOException;
import java.sql.Connection;


public class DBAccessTester {


    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        //dårlig navngivning ? opret et objekt, der kan give en forbindelse.
        Connection connection = databaseConnection.getMYSQLConnection("client", "henning", "SundhedsteknologiDB");
        //brug en bruger kaldet client, med passwordet henning, i schemaet SundhedsteknologiDB.
        DBAccess dba = new DBAccess(connection);
        //Lav et objekt af DBAccess klassen, så vi kan bruge dens metoder
        String Mail = "John@dillermand.dk";
        String password = "badedragt";
        //Kan ændres
        // dba.insertUser(Mail,password);
        //kald metoden til at sætte ind i databasen


        // String[] combo = dba.getUserAndPassword(Mail, password);
        /*
        if(combo[1].equals(password)&& combo[0].equals(Mail) ){

            String url_open ="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
            try {
               // java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(combo[0]+combo[1]+"er et match");
        }
        */


        int[] testArray = {22, 55, 77, 99, 111, 133, 155, 177};


        String cpr = "17-6-2021";

        dba.insertMeasurementsIntoMeasurementsTable(testArray, cpr);
        //
        //kald metoden til at få et svar tilbage fra databasen

        int[] dbtester = dba.getMeasurementsFromCPR(cpr);

        if (dbtester != null) {

            String url_open = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
            try {
              //  java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0; i < dbtester.length; i++) {
                System.out.println("Fra DBtester" + dbtester[i]);


            }
        }

        Thread thread = new Thread(new DBUpdater(dba));
thread.start();

    }
}

    /*
    private static void testmateriale(){



        int[] dbtester = dba.getMeasurementsFromCPR(cpr);

        if(dbtester!=null){

            String url_open ="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i =0;i<dbtester.length;i++){
                System.out.println("Fra DBtester"+dbtester[i]);


            }


        }

String combo =new String[2];
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
*/

