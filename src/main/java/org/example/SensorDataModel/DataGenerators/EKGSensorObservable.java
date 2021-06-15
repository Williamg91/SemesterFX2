package org.example.SensorDataModel.DataGenerators;

import org.example.SensorDataModel.EKGSensorObserver;

public interface EKGSensorObservable extends Runnable{

void registerEKGSensorObserver(EKGSensorObserver ekgSensorObserver);
}
