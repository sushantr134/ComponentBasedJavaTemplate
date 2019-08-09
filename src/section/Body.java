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
import factory.ApuOilTankFactory;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Body extends Subscriber {
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

    // --- APUOilTank -----------------------------------------------------------------------------------------------
    @Subscribe
    public void receive(APUOilTankIncreaseLevel apuOilTankIncreaseLevel) {
        LogEngine.instance.write("+ Body.receive(" + apuOilTankIncreaseLevel.toString() + ")");
        FlightRecorder.instance.insert("Body", "receive(" + apuOilTankIncreaseLevel.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfApuOilTank; i++) {
                Method onMethod = apuOilTankPortList.get(i).getClass().getDeclaredMethod("increase",int.class);
                LogEngine.instance.write("onMethod = " + onMethod);

                int level = (int) onMethod.invoke(apuOilTankPortList.get(i),100);
                LogEngine.instance.write("increaseLevel = " + level);

                PrimaryFlightDisplay.instance.level = level;
                FlightRecorder.instance.insert("Body", "APUOilTank (increaseLevel): " + level);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (increaseLevel): " + PrimaryFlightDisplay.instance.level);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "increaseLevel: " + PrimaryFlightDisplay.instance.level);
    }

    @Subscribe
    public void receive(APUOilTankDecreaseLevel apuOilTankDecreaseLevel) {
        LogEngine.instance.write("+ Body.receive(" + apuOilTankDecreaseLevel.toString() + ")");
        FlightRecorder.instance.insert("Body", "receive(" + apuOilTankDecreaseLevel.toString() + ")");

        try {
            for (int i = 0; i < Configuration.instance.numberOfApuOilTank; i++) {
                Method onMethod = apuOilTankPortList.get(i).getClass().getDeclaredMethod("decrease",int.class);
                LogEngine.instance.write("onMethod = " + onMethod);

                int level = (int) onMethod.invoke(apuOilTankPortList.get(i),10);
                LogEngine.instance.write("decreaseLevel = " + level);

                PrimaryFlightDisplay.instance.level = level;
                FlightRecorder.instance.insert("Body", "APUOilTank (decreaseLevel): " + level);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (decreaseLevel): " + PrimaryFlightDisplay.instance.level);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "decreaseLevel: " + PrimaryFlightDisplay.instance.level);
    }

//    @Subscribe
//    public void receive(WeatherRadarScan weatherRadarScan) {
//        FlightRecorder.instance.insert("Body", "receive(" + weatherRadarScan.toString() + ")");
//    }

    // ----------------------------------------------------------------------------------------------------------------
}