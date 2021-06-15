package org.example.SensorDataModel;

import org.example.SensorDataModel.DTOs.TemperaturesensorDTO;

public interface TempSensorObserver {
    void notify(TemperaturesensorDTO sensorDTO);

}
