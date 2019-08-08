package base;

import logging.LogEngine;
import recorder.FlightRecorder;

public class Application {
    public static void main(String... args) {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        Airplane airplane = new Airplane();
        airplane.build();
        airplane.startup();
        airplane.taxi();
        airplane.takeoff();
        airplane.climbing();
        airplane.cruise();
        airplane.rightTurn();
        airplane.leftTurn();
        airplane.descent();
        airplane.landing();
        airplane.shutdown();

        FlightRecorder.instance.shutdown();
        LogEngine.instance.close();
    }
}
