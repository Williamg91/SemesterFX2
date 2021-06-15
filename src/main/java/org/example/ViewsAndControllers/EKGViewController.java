package org.example.ViewsAndControllers;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.SensorDataModel.DTOs.EKGSensorDTO;
import org.example.SensorDataModel.DTOs.TemperaturesensorDTO;
import org.example.SensorDataModel.DataGenerators.EKGDataGenerator;
import org.example.SensorDataModel.EKGSensorObserver;
import org.example.SensorDataModel.TempSensorObserver;

import java.util.ArrayList;

public class EKGViewController implements EKGSensorObserver, TempSensorObserver {
    //the observer interface tells a class it

    String activeCPR = "";

    @FXML
    private Label latestMeasurement;

    EKGDataGenerator ekgDataGenerator = new EKGDataGenerator();
    //the generator uses Runnable - something can look at it  - and notify
    @FXML
    public Button testknap;
    @FXML
    ArrayList<Integer> fakeMaalinger = new ArrayList<>();


    @FXML
    LineChart chartMeup;
    @FXML
    public void makefakeData(){
        System.out.println("hejsa");

    }


    @FXML
    Button knap;

    public void startEKGMeasurementsWithLogging(){


        Thread ekg = new Thread(ekgDataGenerator);
        //tag mod en klasse, der implementerer et Runnable Interface
            ekg.start();
            //
        ekgDataGenerator.registerEKGSensorObserver(this);



    }

    @Override
    public void notify(EKGSensorDTO ekgSensorDTO) {

        System.out.println(ekgSensorDTO.getSimulatedMaxVoltage());

    }

    @Override
    public void notify(TemperaturesensorDTO sensorDTO) {

    }
}
