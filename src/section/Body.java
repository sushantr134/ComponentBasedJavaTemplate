package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import configuration.Configuration;
import event.Subscriber;
import event.battery.BatteryCharge;
import event.battery.BatteryDischarge;
import event.apu_oil_tank.APUOilTankDecreaseLevel;
import event.apu_oil_tank.APUOilTankIncreaseLevel;
import factory.BatteryFactory;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Body extends Subscriber {
    private ArrayList<Object> batteryPortList;


    public Body() {
        batteryPortList = new ArrayList<>();
        build();
    }

    public void build() {

        for(int i = 0; i < Configuration.instance.numberOfBattery;i++)
        {
            batteryPortList.add(BatteryFactory.build());
        }

    }
    // --- Battery -----------------------------------------------------------------------------------------------

    @Subscribe
    public void receive(BatteryCharge batteryCharge) {
        LogEngine.instance.write("+ Body.receive(" + batteryCharge.toString() + ")");
        FlightRecorder.instance.insert("Body", "receive(" + batteryCharge.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfBattery; i++) {
                Method onMethod = batteryPortList.get(i).getClass().getDeclaredMethod("charge");
                LogEngine.instance.write("onMethod = " + onMethod);

                int percentage = (int) onMethod.invoke(batteryPortList.get(i));
                LogEngine.instance.write("percentage = " + percentage);

                PrimaryFlightDisplay.instance.percentage = percentage;
                FlightRecorder.instance.insert("Body", "Battery (percentage): " + percentage);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (Battery): " + PrimaryFlightDisplay.instance.percentage);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "chargeBatteryPercentage: " + PrimaryFlightDisplay.instance.percentage);
    }

    @Subscribe
    public void receive(BatteryDischarge batteryDischarge) {
        LogEngine.instance.write("+ Body.receive(" + batteryDischarge.toString() + ")");
        FlightRecorder.instance.insert("Body", "receive(" + batteryDischarge.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfBattery; i++) {
                Method onMethod = batteryPortList.get(i).getClass().getDeclaredMethod("discharge");
                LogEngine.instance.write("onMethod = " + onMethod);

                int percentage = (int) onMethod.invoke(batteryPortList.get(i));
                LogEngine.instance.write("percentage = " + percentage);

                PrimaryFlightDisplay.instance.percentage = percentage;
                FlightRecorder.instance.insert("Body", "Battery (percentage): " + percentage);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (Battery): " + PrimaryFlightDisplay.instance.percentage);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "dischargeBatteryPercentage: " + PrimaryFlightDisplay.instance.percentage);
    }



//    @Subscribe
//    public void receive(WeatherRadarScan weatherRadarScan) {
//        FlightRecorder.instance.insert("Body", "receive(" + weatherRadarScan.toString() + ")");
//    }

    // ----------------------------------------------------------------------------------------------------------------
}