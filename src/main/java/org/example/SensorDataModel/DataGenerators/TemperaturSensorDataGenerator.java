package org.example.SensorDataModel.DataGenerators;


import org.example.SensorDataModel.DTOs.TemperaturesensorDTO;
import org.example.SensorDataModel.SensorObservable;
import org.example.SensorDataModel.SensorObserver;

import java.util.ArrayList;

public class TemperaturSensorDataGenerator implements SensorObservable {

    //We made it implement the Observable so we can have more than one type of data, and others observe
    //the data being created.



    private ArrayList<SensorObserver> sensorObservers = new ArrayList<>();


    @Override
    public void run() {
        while(true){
            //create a
            TemperaturesensorDTO temperaturesensorDTO = new TemperaturesensorDTO();


            if(sensorObservers!=null){
                for( SensorObserver o: sensorObservers){

                    o.notify(temperaturesensorDTO);
                    //
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    public void registerSensorObserver(SensorObserver sensorObserver) {
        sensorObservers.add(sensorObserver);

    }
}
