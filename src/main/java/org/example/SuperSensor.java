package org.example;

import com.fazecast.jSerialComm.SerialPort;

import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;


public abstract class SuperSensor {

    SerialPort[] serialPorts = SerialPort.getCommPorts();
    SerialPort chosenPort;

    protected String portname;
    protected String portOutput;

    public SuperSensor(){
        System.out.println("Main sensor created");
        chosenPort = serialPorts[0];
        chosenPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            };


            @Override
            public void serialEvent(SerialPortEvent serialPortEvent) {
                if (serialPortEvent.getEventType()!=SerialPort.LISTENING_EVENT_DATA_AVAILABLE){
                    System.out.println("Reading");
                    return;
                }
            }
        });
    }


}
