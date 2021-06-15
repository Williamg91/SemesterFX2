package org.example.SensorDataModel;

import org.example.SensorDataModel.DTOs.EKGSensorDTO;

public interface EKGSensorObserver {

    //notify listeners with a Data Transfer Object.
    public void notify(EKGSensorDTO ekgSensorDTO);

}
