package org.example.SensorDataModel;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.example.SensorDataModel.DTOs.Sensorparent;

public class EKGSensor extends Sensorparent {
    //this class functions both as filter and a return - it also contains a constructor to autonomously build a port, according to available options.
    SerialPort[] serialPorts = SerialPort.getCommPorts();
    SerialPort serialPort =null;

    private String sensoroutput = "";
    public EKGSensor(){

        for (SerialPort port:serialPorts){
            System.out.println(port.toString());

        }
        try{
            String output ="";
           serialPort = serialPorts[2];
           serialPort.openPort();
           serialPort.setBaudRate(38400);
            serialPort.addDataListener(new SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                }

                @Override
                public void serialEvent(SerialPortEvent serialPortEvent) {
                    if (serialPortEvent.getEventType()!=SerialPort.LISTENING_EVENT_DATA_AVAILABLE){
                        System.out.println("Reading");
                        return;
                    }
                    byte[] newData = new byte[serialPort.bytesAvailable()];
                    int numRead = serialPort.readBytes(newData, newData.length);
                    sensoroutput = new String((newData));
                    //System.out.print(new String(newData));
                }
            });

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    int errorcounter = 0;
    public synchronized  int[] getSensoroutput(){
       // System.out.println(sensoroutput);
        String[] holder = sensoroutput.split("t");
        String buffer = "";
        int[] output = new int[sensoroutput.length()];
        try{
        for (int i =0;i<holder.length;i++){
            output[i] = Integer.parseInt(holder[i]);

        }}catch (Exception ex){
            ex.printStackTrace();
            errorcounter++;
            System.out.println(errorcounter);
        }

        return output;
    }



    //get

        //no port defined, just give us the first, the best.

}
