package section;

import base.PrimaryFlightDisplay;
import configuration.Configuration;
import factory.ApuOilTankFactory;
import factory.BatteryFactory;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Body {
    private ArrayList<Object> batteryPortList;
    private ArrayList<Object> apuOilTankPortList;

    public Body() {
        batteryPortList = new ArrayList<>();
        apuOilTankPortList = new ArrayList<>();
        build();
    }

    public void build() {

        for(int i = 0; i < Configuration.instance.numberOfBattery;i++)
        {
            batteryPortList.add(BatteryFactory.build());
        }
        for(int j = 0; j < Configuration.instance.numberOfApuOilTank;j++)
        {
            apuOilTankPortList.add(ApuOilTankFactory.build());
        }
    }

    public ArrayList<Object> getApuOilTankPortList()
    {
        return apuOilTankPortList;
    }
    public  ArrayList<Object> getBatteryPortList()
    {
        return batteryPortList;
    }

    //battery_methods
    public void setBatteryCharge()
    {

        LogEngine.instance.write("+ Body.receive(batteryCharge)");
        FlightRecorder.instance.insert("Body","receive(batteryCharge)");

        try {
            for(int i=0; i<Configuration.instance.numberOfBattery;i++)
            {
                Method onMethod = batteryPortList.get(i).getClass().getDeclaredMethod("charge");
                FlightRecorder.instance.insert("Body","receive(batteryCharge)");

                int percentage = (int)onMethod.invoke(batteryPortList.get(i));
                LogEngine.instance.write("batteryCharge = " + percentage);

                PrimaryFlightDisplay.instance.percentage = percentage;
                FlightRecorder.instance.insert("Body", "BatteryCharge: " + percentage);

                LogEngine.instance.write("+");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (batteryCharge): " + PrimaryFlightDisplay.instance.percentage);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "batteryCharge:  " + PrimaryFlightDisplay.instance.percentage);
    }
    public void setBatteryDischarge()
    {

        LogEngine.instance.write("+ Body.receive(batteryDischarge)");
        FlightRecorder.instance.insert("Body","receive(batteryDischarge)");

        try {
            for(int i=0; i<Configuration.instance.numberOfBattery;i++)
            {
                Method onMethod = batteryPortList.get(i).getClass().getDeclaredMethod("discharge");
                FlightRecorder.instance.insert("Body","receive(batteryDischarge)");

                int percentage = (int)onMethod.invoke(batteryPortList.get(i));
                LogEngine.instance.write("batteryDischarge = " + percentage);

                PrimaryFlightDisplay.instance.percentage = percentage;
                FlightRecorder.instance.insert("Body", "BatteryDischarge: " + percentage);

                LogEngine.instance.write("+");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (batteryDischarge): " + PrimaryFlightDisplay.instance.percentage);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "batteryDischarge:  " + PrimaryFlightDisplay.instance.percentage);
    }

    //apu_oil_tank methods
    public void setApuOilTankIncreaseLevel(int value)
    {

        LogEngine.instance.write("+ Body.receive(apuOilTankIncreaseLevel)");
        FlightRecorder.instance.insert("Body","receive(apuOilTankIncreaseLevel)");

        try {
            for(int i=0; i<Configuration.instance.numberOfApuOilTank;i++)
            {
                Method onMethod = apuOilTankPortList.get(i).getClass().getDeclaredMethod("increase",Integer.class);
                FlightRecorder.instance.insert("Body","receive(apuOilTankIncreaseLevel)");

                int level = (int)onMethod.invoke(apuOilTankPortList.get(i),value);
                LogEngine.instance.write("apuOilTankIncreaseLevel = " + level);

                PrimaryFlightDisplay.instance.level = level;
                FlightRecorder.instance.insert("Body", "apuOilTankIncreaseLevel: " + level);

                LogEngine.instance.write("+");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (apuOilTankIncreaseLevel): " + PrimaryFlightDisplay.instance.level);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "apuOilTankIncreaseLevel:  " + PrimaryFlightDisplay.instance.level);
    }

    public void setApuOilTankDecreaseLevel(int value)
    {

        LogEngine.instance.write("+ Body.receive(apuOilTankDecreaseLevel)");
        FlightRecorder.instance.insert("Body","receive(apuOilTankDecreaseLevel)");

        try {
            for(int i=0; i<Configuration.instance.numberOfApuOilTank;i++)
            {
                Method onMethod = apuOilTankPortList.get(i).getClass().getDeclaredMethod("decrease",Integer.class);
                FlightRecorder.instance.insert("Body","receive(apuOilTankDecreaseLevel)");

                int level = (int)onMethod.invoke(apuOilTankPortList.get(i),value);
                LogEngine.instance.write("apuOilTankDecreaseLevel = " + level);

                PrimaryFlightDisplay.instance.level = level;
                FlightRecorder.instance.insert("Body", "apuOilTankDecreaseLevel: " + level);

                LogEngine.instance.write("+");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (apuOilTankDecreaseLevel): " + PrimaryFlightDisplay.instance.level);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "apuOilTankDecreaseLevel:  " + PrimaryFlightDisplay.instance.level);
    }

}
