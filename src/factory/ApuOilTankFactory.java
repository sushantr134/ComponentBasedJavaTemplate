package factory;

import configuration.Configuration;
import recorder.FlightRecorder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ApuOilTankFactory {
    public static Object build() {
        Object apuOilTankPort = null;

        try {
            URL[] urlList = {new File(Configuration.instance.pathToApuOilTankJavaArchive).toURI().toURL()};
            URLClassLoader urlLoader = new URLClassLoader(urlList, ApuOilTankFactory.class.getClassLoader());
            Class apuoiltank = Class.forName("APUOilTank", true, urlLoader);
            FlightRecorder.instance.insert("ApuOilTankFactory", "ApuOilTank: " + apuoiltank.hashCode());

            Object apuoiltankInstance = apuoiltank.getMethod("getInstance").invoke(null);
            FlightRecorder.instance.insert("ApuOilTankFactory", "apuOilTankInstance: " + apuoiltankInstance.hashCode());

            apuOilTankPort = apuoiltank.getDeclaredField("port").get(apuoiltankInstance);
            FlightRecorder.instance.insert("ApuOilTankFactory","apuOilTankPort: "+apuoiltank.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return apuOilTankPort;
    }
}