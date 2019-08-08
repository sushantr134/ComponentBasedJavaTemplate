package factory;

import configuration.Configuration;
import recorder.FlightRecorder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class TouristClassSeatFactory {
    public static Object build() {
        Object touristClassSeatPort = null;

        try {
            URL[] urlList = {new File(Configuration.instance.pathToTouristClassSeatJavaArchive).toURI().toURL()};
            URLClassLoader urlLoader = new URLClassLoader(urlList, TouristClassSeatFactory.class.getClassLoader());
            Class touristClassSeat = Class.forName("TouristClassSeat", true, urlLoader);
            FlightRecorder.instance.insert("TouristClassSeatFactory", "touristClassSeat: " + touristClassSeat.hashCode());

            Object touristClassSeatInstance = touristClassSeat.getMethod("getInstance").invoke(null);
            FlightRecorder.instance.insert("touristClassSeatFactory", "touristClassSeatInstance: " + touristClassSeatInstance.hashCode());

            touristClassSeatPort = touristClassSeat.getDeclaredField("port").get(touristClassSeatInstance);
            FlightRecorder.instance.insert("TouristClassSeatFactory","touristClassSeatPort: "+touristClassSeatPort.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return touristClassSeatPort;
    }
}