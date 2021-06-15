package org.example;


import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.example.SensorDataModel.EKGSensor;

public class PortTester {

    SerialPort[] serialPorts = SerialPort.getCommPorts();
    SerialPort chosenPort;
    public PortTester(){
        for (SerialPort s : serialPorts){
            System.out.println("port found:"+s);

        }

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
        //open the first, the best, port:

    }


    public static void main(String[] args) {

        EKGSensor ekg = new EKGSensor();
        while(true){
           ekg.getSensoroutput();

        }
    }
}
