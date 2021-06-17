package org.example.SimpleObserverPattern;

import org.example.SensorDataModel.DTOs.EKGSensorDTO;
import org.example.SensorDataModel.EKGSensorObserver;

import java.util.ArrayList;

public class SimpObserverClass implements SimpleObserverInterface {
//har et interface for at indikere den bruger det.

  public static void main(String[] args) {
    SimpObservable simp = new SimpObservable();
    Thread simpsons = new Thread(simp);

  }



    @Override
    public void notify(ArrayList<String> availabledata) {
    //Her kan man faktisk give hvad som helst ind i Notify - Det kunne fx være en klasse eller objekt.
//called from other classes (: when this is called, do X.
    }
}
