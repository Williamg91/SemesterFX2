package org.example.SensorDataModel.DTOs;

public class PulseSensorDTO extends Sensorparent{



    double simulatedmax = 200.0;
    double simulatedmin = 40.0;


    public PulseSensorDTO(){
        System.out.println("made with love, but no port");

    }



    public PulseSensorDTO(String portname){
        System.out.println("made with a port and no love");


    }

}
