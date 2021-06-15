package org.example.SimpleObserverPattern;

import org.example.SensorDataModel.DTOs.EKGSensorDTO;
import org.example.SensorDataModel.EKGSensorObserver;

import java.util.ArrayList;

public class ObserverClass implements SimpleObserverInterface {




  public void startThread(){
      System.out.println("Hej Henrik");


  }

    @Override
    public void notify(ArrayList<String> availabledata) {

    }
}
