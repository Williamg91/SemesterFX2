package org.example.SensorDataModel.DataGenerators;

import org.example.SensorDataModel.DTOs.EKGSensorDTO;
import org.example.SensorDataModel.EKGSensorObserver;


import java.util.ArrayList;

public class EKGDataGenerator implements EKGSensorObservable {
    //EKG Observable uses Runnable to have a Run method and can notify an observer

   private ArrayList<EKGSensorObserver> sensorObservers = new ArrayList<>();


    @Override
    public void run() {
        EKGSensorDTO EKGDTO = new EKGSensorDTO(110,50);
        while(true){

            //while this is true, an object is made

            if(sensorObservers!=null){
                for( EKGSensorObserver o: sensorObservers){

                    o.notify(EKGDTO);
                    //
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }





    @Override
    public void registerEKGSensorObserver(EKGSensorObserver ekgSensorObserver) {
        sensorObservers.add(ekgSensorObserver);
    }
}
