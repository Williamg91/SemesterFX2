package org.example.Databasepackage;

import java.sql.Connection;

public class DBUpdater implements Runnable {
    //Connection db;
    DBAccess dbAccess;

    public DBUpdater(DBAccess dbAccess){
        this.dbAccess=dbAccess;
    }


    @Override
    public void run() {
        while(true) {


            int[] data = {3454, 4, 5, 3, 313151, 312314, 3};
            dbAccess.insertMeasurementsIntoMeasurementsTable(data, "henning");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
