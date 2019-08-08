package factory;

import configuration.Configuration;
import recorder.FlightRecorder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class BatteryFactory {
    public static Object build() {
        Object batteryPort = null;

        try {
            URL[] urlList = {new File(Configuration.instance.pathToBatteryJavaArchive).toURI().toURL()};
            URLClassLoader urlLoader = new URLClassLoader(urlList, BatteryFactory.class.getClassLoader());
            Class battery = Class.forName("Battery", true, urlLoader);
            FlightRecorder.instance.insert("BatteryFactory", "battery: " + battery.hashCode());

            Object batteryInstance = battery.getMethod("getInstance").invoke(null);
            FlightRecorder.instance.insert("batteryFactory", "batteryInstance: " + batteryInstance.hashCode());

            batteryPort = battery.getDeclaredField("port").get(batteryInstance);
            FlightRecorder.instance.insert("batteryFactory","batteryPort: "+batteryPort.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return batteryPort;
    }
}
