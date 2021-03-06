package org.example.SensorDataModel.DTOs;
import jssc.*;
import org.example.Observable;

import java.util.ArrayList;

public class EKGSensorDTO implements Observable {
    private  int simulatedmaxHeartRate,simulatedmin;
    //Give this to a Datagenerator

    private SerialPort serialPort;
    public EKGSensorDTO(){
        String[] portNames= SerialPortList.getPortNames();
        for (String name : portNames){
            System.out.println(name);
        }
        serialPort = new SerialPort(portNames[0]);
        //use the first one.
        //STOP sending shit back and forward. Do shit that needs to be done once, only once, and STOP closing ports that are used.
        try {
            //Standard SeriaPort opsætning med buad rate på 57600

            serialPort.openPort();  // åbner porten
            serialPort.setParams(57600, 8, 1, 0);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort.setDTR(true);
            System.out.println("Port is open. Now close me as I'm being used.");
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    private String endBuffer="";
    private String frontBuffer="";
    private String[] inddeltOgFiltreretArray;

    private ArrayList<Integer> aSimpleMethodThatDoesntCloseThePortButReturnsOurData(){
        ArrayList<Integer> data= new ArrayList<>();
        String input = "";

        try {
            if (serialPort.getInputBufferBytesCount() > 0) {
                input = serialPort.readString();

                if(input!=null){

                    input=applyFilterToInput(input);
                }

                //and the end

                String[] split = input.split(",");
               //this is where it can get tricky - what happens in each case?

                for(String indholdISplitteren: split){
                    //For each element of the Split array - do something

                    //Check for remainers

                    //add the converted, filterede values
                    data.add(Integer.parseInt(indholdISplitteren));
                }

                //tilføj start og slut for hver af jeres målinger:

            } else {
                Thread.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;


    }

    private String applyFilterToInput(String input) {
//This is private, because Other classes don't CARE about whether or not

        int forsteForeKomstAfSkilleTegn=input.indexOf(",");
        int sidsteForekomstAfSkilleTegn = input.lastIndexOf(",");
        try{
            //check for leftovers in the start
            String dataForForsteSkilletegn = input.substring(0,forsteForeKomstAfSkilleTegn);
            int heltalForForsteSkilletegn = Integer.parseInt(dataForForsteSkilletegn);

            String materialeEfterSidsteSkilletegn = input.substring(sidsteForekomstAfSkilleTegn,input.length());
            //And in the end
            int heltalEfterSidsteSkilletegn =Integer.parseInt(materialeEfterSidsteSkilletegn);
            if(dataForForsteSkilletegn!=null){
                frontBuffer=dataForForsteSkilletegn;
            }
            if(materialeEfterSidsteSkilletegn!=null){
                endBuffer=materialeEfterSidsteSkilletegn;
            }
        }catch (NumberFormatException ex){
            if(!frontBuffer.equals("")||!endBuffer.equals("")){
                ex.printStackTrace();
                //if our front our end is NOT equal to a blank space and we get an error, print the stack.
            }
        }

        return input ;
    }

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



    @Override
    public void notify(Object listener) {

    }
}
