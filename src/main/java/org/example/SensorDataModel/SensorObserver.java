package org.example.SensorDataModel;

import org.example.SensorDataModel.DTOs.Sensorparent;
import org.example.SensorDataModel.DTOs.TemperaturesensorDTO;

public interface SensorObserver {
    void notify(TemperaturesensorDTO sensorDTO);
}
