package org.example.SensorDataModel.DTOs;



import java.util.concurrent.ThreadLocalRandom;

public class TemperaturesensorDTO extends Sensorparent {

//only for creating the Data


    // default values
    double simulatedmin =37.0;
    double simulatedmax =38.9;

    public TemperaturesensorDTO(){

    }
    public double getSimulatedValue() {


        return ThreadLocalRandom.current().nextDouble(simulatedmin, simulatedmax);
    }


    public double getActualValue() {
        return 0;
    }



    public TemperaturesensorDTO(String portname){
        super();
        //for an actual sensor
        this.portname=portname;

        //insert open ports logic
    }

    public TemperaturesensorDTO(double simulatedMax, double simulatedmin ){
        this.simulatedmax=simulatedMax;
        this.simulatedmin=simulatedmin;
    //tænkeopgave - skal sensoren forholde sig til om en værdi er for høj, eller er det
    //nok at sensoren bare leverer data?
    }


}
