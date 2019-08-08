package test;

import base.Airplane;
import base.PrimaryFlightDisplay;
import logging.LogEngine;
import org.junit.jupiter.api.*;
import recorder.FlightRecorder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestProcedure {
    private static Airplane airplane;

    @BeforeAll
    public static void setup() {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        airplane = new Airplane();
        airplane.build();
    }

    @Test
    @Order(1)
    public void getComponentPort() {
        System.out.println("--- TouristClassSeat ---");
        System.out.println("[#ports] \t\t\t\t\t\t: " + airplane.getBody().getTouristClassSeatPortList().size());
        assertEquals(2,airplane.getBody().getTouristClassSeatPortList().size());
    }

    @Test
    @Order(2)
    public void startup() {
        airplane.startup();

        //tourist_class_seat

        System.out.println("[startup \t| touristClassSeatAssign] : " + PrimaryFlightDisplay.instance.passenger);
        assertNotNull(PrimaryFlightDisplay.instance.passenger);

        System.out.println("[startup \t| isSeatBeltSignOn] : " + PrimaryFlightDisplay.instance.isSeatBeltSignOn);
        assertTrue(PrimaryFlightDisplay.instance.isSeatBeltSignOn);



    }

//    @Test
//    @Order(3)
//    public void taxi() {
//        airplane.taxi();
//
//        // weather_radar
//        System.out.println("[taxi \t\t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[taxi \t\t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(4)
//    public void takeoff() {
//        airplane.takeoff();
//
//        // weather_radar
//        System.out.println("[takeoff \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[takeoff \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(5)
//    public void climbing() {
//        airplane.climbing();
//
//        // weather_radar
//        System.out.println("[climbing \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[climbing \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(6)
//    public void cruise() {
//        airplane.cruise();
//
//        System.out.println("[cruise \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[cruise \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertTrue(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(7)
//    public void rightTurn() {
//        airplane.rightTurn();
//
//        // weather_radar
//        System.out.println("[rightTurn \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[rightTurn \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(8)
//    public void leftTurn() {
//        airplane.leftTurn();
//
//        // weather_radar
//        System.out.println("[leftTurn \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[leftTurn \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(9)
//    public void descent() {
//        airplane.descent();
//
//        // weather_radar
//        System.out.println("[descent \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[descent \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(10)
//    public void landing() {
//        airplane.landing();
//
//        // weather_radar
//        System.out.println("[landing \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertTrue(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[landing \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//    }
//
//    @Test
//    @Order(11)
//    public void shutdown() {
//        airplane.shutdown();
//
//        // weather_radar
//        System.out.println("[shutdown \t| isWeatherRadarOn] : " + PrimaryFlightDisplay.instance.isWeatherRadarOn);
//        assertFalse(PrimaryFlightDisplay.instance.isWeatherRadarOn);
//
//        System.out.println("[shutdown \t| isCloudScanned]   : " + PrimaryFlightDisplay.instance.isCloudScanned);
//        assertFalse(PrimaryFlightDisplay.instance.isCloudScanned);
//
//        System.out.println("---\n");
//    }

    @AfterAll
    public static void finish() {
        FlightRecorder.instance.shutdown();
        LogEngine.instance.close();
    }
}
