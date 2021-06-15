package org.example.SensorDataModel.DTOs;

public class EKGSensorDTO extends Sensorparent{
    //Give this to a Datagenerator

/*

This class is supposed to make 2 variants of measurements - a simulated ECG measurement, and 100s of simulated voltages
each second.
 */
    //we may need to create simulated values from this sensor - ranging from 0-2^12 -1 = 4095
    //increasingly high generating values - or do we just need a simulation of actual measurements?



    public EKGSensorDTO(int maxpuls,int minimumpuls){
        this.simulatedmaxHeartRate = maxpuls;
       this.simulatedmin =minimumpuls;
    }

    private double simulatedVoltage =1;
    boolean ascending = true;
    public double getIncreasingSimulatedVoltage(){

//inserted
        switch (simulatedMaxVoltage){
            case 4095:
                ascending=false;
            case 0:
                ascending=true;
        }

        if(simulatedVoltage<4095 &&ascending) {
            simulatedVoltage++;
            //increase if less
        }
        else if(simulatedVoltage==4095 && !ascending){
    simulatedVoltage--;
            }
        //decrease




        return simulatedVoltage;
    }

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
