package org.example.SensorDataModel;


public interface TempSensorObservable extends Runnable {
     //Extend Runnable to make a Thread

      void registerSensorObserver(TempSensorObserver sensorObserver);
//who is observing THIS sensor? Take in an Observer -



}
