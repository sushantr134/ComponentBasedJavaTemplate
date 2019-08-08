package section;

import base.Passenger;
import base.PrimaryFlightDisplay;
import configuration.Configuration;
import factory.TouristClassSeatFactory;
import factory.WeatherRadarFactory;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Body {
    private ArrayList<Object> touristClassSeatPortList;

    public Body() {
        touristClassSeatPortList = new ArrayList<>();
        build();
    }

    public void build() {

        for(int i = 0; i < Configuration.instance.numberOfTouristClassSeat;i++)
        {
            touristClassSeatPortList.add(TouristClassSeatFactory.build());
        }
    }

    public ArrayList<Object> getTouristClassSeatPortList()
    {
        return touristClassSeatPortList;
    }
    public void setTouristClassSeatAssign()
    {

        LogEngine.instance.write("+ Body.receive(touristClassSeatAssign)");
        FlightRecorder.instance.insert("Body","receive(touristClassSeatAssign)");

        try {
            for(int i=0; i<Configuration.instance.numberOfTouristClassSeat;i++)
            {
                Method onMethod = touristClassSeatPortList.get(i).getClass().getDeclaredMethod("assign",Passenger.class);
                FlightRecorder.instance.insert("Body","receive(touristClassSeatAssign)");

                Passenger p = new Passenger();
                System.out.println("Passenger"+p.hashCode());
                int assign = (int)onMethod.invoke(touristClassSeatPortList.get(i),p);
                LogEngine.instance.write("touristSeatAssign = " + assign);

                PrimaryFlightDisplay.instance.passenger = p;
                FlightRecorder.instance.insert("Body", "TouristClassSeatAssign: " + assign);

                LogEngine.instance.write("+");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (touristClassSeatAssign -- passenger): " + PrimaryFlightDisplay.instance.passenger);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "touristClassSeatAssign -- passenger:  " + PrimaryFlightDisplay.instance.passenger);
    }
    public void touristClassSeatSeatBeltOn()
    {
        LogEngine.instance.write("+ Body.receive(touristClassSeatBeltOn)");
        FlightRecorder.instance.insert("Body","receive(touristClassSeatBeltOn)");

        try {
            for(int i=0; i<Configuration.instance.numberOfTouristClassSeat;i++)
            {
                Method onMethod = touristClassSeatPortList.get(i).getClass().getDeclaredMethod("seatBeltSignOn");
                FlightRecorder.instance.insert("Body","receive(touristClassSeatBeltOn)");

                boolean isOn = (boolean) onMethod.invoke(touristClassSeatPortList.get(i));
                LogEngine.instance.write("isSeatBeltSignOn = " + isOn);

                PrimaryFlightDisplay.instance.isSeatBeltSignOn = isOn;
                FlightRecorder.instance.insert("Body", "TouristClassSeat (isSeatBeltSignOn): " + isOn);

                LogEngine.instance.write("+");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        LogEngine.instance.write("PrimaryFlightDisplay (isSeatBeltSignOn): " + PrimaryFlightDisplay.instance.isSeatBeltSignOn);
        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isSeatBeltSignOn: " + PrimaryFlightDisplay.instance.isSeatBeltSignOn);
    }

//
//     public void weatherRadarScan(String environment) {
//        LogEngine.instance.write("+ Body.receive(weatherRadarScan)");
//        FlightRecorder.instance.insert("Body", "receive(weatherRadarScan)");
//
//        try {
//            for (int i = 0; i < Configuration.instance.numberOfWeatherRadar; i++) {
//                Method scanMethod = weatherRadarPortList.get(i).getClass().getMethod("scan", String.class);
//                LogEngine.instance.write("scanMethod = " + scanMethod);
//
//                boolean isCloudScanned = (boolean) scanMethod.invoke(weatherRadarPortList.get(i), environment);
//                LogEngine.instance.write("isCloudScanned = " + isCloudScanned);
//
//                PrimaryFlightDisplay.instance.isCloudScanned = isCloudScanned;
//                FlightRecorder.instance.insert("Body", "WeatherRadar (isCloudScanned): " + isCloudScanned);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        LogEngine.instance.write("PrimaryFlightDisplay (isCloudScanned): " + PrimaryFlightDisplay.instance.isCloudScanned);
//        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isCloudScanned: " + PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    public void weatherRadarOff() {
//        LogEngine.instance.write("+ Body.receive(weatherRadarOff)");
//        FlightRecorder.instance.insert("Body", "receive(weatherRadarOff)");
//
//        try {
//            for (int i = 0; i < Configuration.instance.numberOfWeatherRadar; i++) {
//                Method offMethod = weatherRadarPortList.get(i).getClass().getDeclaredMethod("off");
//                LogEngine.instance.write("offMethod = " + offMethod);
//
//                boolean isOn = (boolean) offMethod.invoke(weatherRadarPortList.get(i));
//                LogEngine.instance.write("isOn = " + isOn);
//
//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isOn;
//                FlightRecorder.instance.insert("Body", "WeatherRadar (isOn): " + isOn);
//
//                LogEngine.instance.write("+");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        LogEngine.instance.write("PrimaryFlightDisplay (isWeatherRadarOn): " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        FlightRecorder.instance.insert("PrimaryFlightDisplay", "isWeatherRadarOn: " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//    }
}
