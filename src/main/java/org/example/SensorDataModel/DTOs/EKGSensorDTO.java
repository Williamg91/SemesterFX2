package org.example.SensorDataModel.DTOs;

public class EKGSensorDTO extends Sensorparent{

    //we may need to create simulated values from this sensor - ranging from 0-2^12 -1 = 4095

    public int getSimulatedMaxVoltage() {
        return simulatedMaxVoltage;
    }

    public void setSimulatedMaxVoltage(int simulatedMaxVoltage) {
        this.simulatedMaxVoltage = simulatedMaxVoltage;
    }

    int simulatedMaxVoltage = 4095;

    public int getSimulatedMinVoltage() {
        return simulatedMinVoltage;
    }

    public void setSimulatedMinVoltage(int simulatedMinVoltage) {
        this.simulatedMinVoltage = simulatedMinVoltage;
    }

    int simulatedMinVoltage = 0;

}
