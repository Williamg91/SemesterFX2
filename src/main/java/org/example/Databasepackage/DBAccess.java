package org.example.Databasepackage;

import java.sql.*;
import java.util.ArrayList;

public class DBAccess {
private Connection conn;
private PreparedStatement preparedStatement;
private Statement statement;

    public DBAccess(Connection connection){
    this.conn=connection;
//all it does is contain logic for interacting with the database.
    }

    public void insertUser(String mail,String Password){
        try{
            //if no table:
            String lavTabel =
                    "CREATE TABLE if not exists `Persons` (\n" +
                    "  `idPersons` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `mail` varchar(45) DEFAULT NULL,\n" +
                    "  `passwd` varchar(45) NOT NULL,\n" +
                    "  `firstname` varchar(45) DEFAULT NULL,\n" +
                    "  `lastname` varchar(45) DEFAULT NULL,\n" +
                    "  `role` varchar(45) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`idPersons`),\n" +
                    "  UNIQUE KEY `mail_UNIQUE` (`mail`)\n" +
                    ") ;";
            statement = conn.createStatement();
            statement.execute(lavTabel);
            String SQLInsert = "insert into Persons(mail,passwd) values( ? ,? );";
            preparedStatement = conn.prepareStatement(SQLInsert);
            preparedStatement.setString(1,mail);
            preparedStatement.setString(2,Password);
            preparedStatement.executeUpdate();
            System.out.println("User inserted with parameters:"+mail+" and:"+Password);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void insertMeasurementsIntoMeasurementsTable(int[] datasomIfaarfraSensorKlassen,String CPR){
        try{
            //if no table:
            String lavTabel ="CREATE TABLE if not exists `measurements` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `CPR` varchar(11) NOT NULL,\n" +
                    "  `measurementvalue` int NOT NULL,\n" +
                    "  `lortetid` timestamp NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ";

            statement = conn.createStatement();
            statement.execute(lavTabel);

            String SQLInsert = "insert into measurements(measurementvalue,CPR) values (?,?);";
            preparedStatement = conn.prepareStatement(SQLInsert);
            //loop over the array or arrayList
            for (int i=0;i<datasomIfaarfraSensorKlassen.length;i++){
                preparedStatement.setInt(1,datasomIfaarfraSensorKlassen[i]);
                preparedStatement.setString(2,CPR);
                //alloker første plads i SQL Statementet - til at være det I'te element fra et Array eller ArrayList
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Data inserted, with "+datasomIfaarfraSensorKlassen.length+" values");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }


    public int[] getMeasurementsFromCPR(String CPR){
        // Inefficient method - make an ArrayList of measurements instead...
        int[] data =null; //Declare an array for later.
        try{
            String SqlSEARCH = "\n" +
                    "select cpr,measurementvalue from measurements where cpr =" +
                    " '%s'" +
                    //formateret string - %s betyder at man kan bruge String.format(StringensNavn,indsætVærdiHer)
                    //til at indsætte i en String, uden at bruge +""+
                    ";";
            statement = conn.createStatement();
            String counter = "select count(*) from measurements;";
            // statement.executeQuery(SqlSEARCH);
            ResultSet rowcount = statement.executeQuery(counter);
            int dataSampleSize=0;
            if(rowcount!=null){
                //if we get a count back...
                rowcount.next();
                dataSampleSize=rowcount.getInt(1);
                System.out.println("Found samples:"+dataSampleSize);
                data = new int[dataSampleSize];
            }
            //count rows - consider if there's a limit to how many seconds or samples you want presented.
            ResultSet resultSet = statement.executeQuery(String.format(SqlSEARCH, CPR ));

            if (resultSet != null)
            { int index =0;

                while(resultSet.next()){

                    //loop over the results.

                        data[index]= resultSet.getInt(2);
                    index++;
                }
                //https://stackoverflow.com/questions/192078/how-do-i-get-the-size-of-a-java-sql-resultset/192104
                 // moves cursor to the last row

               // resultSet.first();

            }





        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return data; //mind of NullPointer =this indicates error in loops
    }

    public String[] getUserAndPassword(String mail,String password){
        String[] data = new String[2];
        try{
            String SqlSEARCH = "\n" +
                    "select mail,passwd from Persons where mail =" +
                    "" +
                    " '%s' and passwd = '%s';";
            statement = conn.createStatement();
           // statement.executeQuery(SqlSEARCH);
            ResultSet resultSet = statement.executeQuery(String.format(SqlSEARCH, mail,password ));
            if(resultSet!=null && resultSet.next()){
                data[0]=resultSet.getString(1);
                //for mail
                data[1]=resultSet.getString(2);
                //for password
                //verify
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return data;
    }

    public int[] returnMeasurementsfromDB(int size){

        return new int[size];
    }




}
