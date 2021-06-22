package org.example.SensorDataModel.DTOs;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.util.ArrayList;

public class SensorMedFilter {
    private SerialPort serialPort;

    private String endBuffer="";
    private String frontBuffer="";
    private String[] inddeltOgFiltreretArray;
    String input = "";
    private ArrayList<Integer> data= new ArrayList<>();
    public SensorMedFilter(SerialPort serialPort) {
        this.serialPort = serialPort;
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

    public ArrayList<Integer> aSimpleMethodThatDoesntCloseThePortButReturnsOurData(){
        try {
            if (serialPort.getInputBufferBytesCount() > 0) {
                input = serialPort.readString();
                if(input!=null){
                    input=applyFilterToInput(input);
                }
                //and the end
                String[] split = input.split(",");
                //this is where it can get tricky - what happens in each case? We need to work on the filtering first
                for(String indholdISplitteren: split){
                    //For each element of the Split array - do something
                    data.add(Integer.parseInt(indholdISplitteren));
                    //add the converted, filterede values
                }
            } else {
                Thread.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;


    }

    private String applyFilterToInput(String input) {
//This is private, because Other classes don't CARE about how the class works. they care for results

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

}
