package test;

import base.PrimaryFlightDisplay;
import factory.BatteryFactory;
import logging.LogEngine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recorder.FlightRecorder;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TestBattery {
    private Object componentPort;

    @BeforeEach
    public void init() {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();
    }

    @Test
    public void factory() {
        componentPort = BatteryFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void methods() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            assertNotEquals(0,onMethod);

            Method offMethod = componentPort.getClass().getDeclaredMethod("discharge");
            assertNotNull(offMethod);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void charge() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            assertNotEquals(0,percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void discharge() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("discharge");
            int percentage = (int) onMethod.invoke(componentPort);
            assertEquals(0,percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void startup() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void taxi() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void takeoff() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void climbing() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void rightTurn() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void leftTurn() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void descent() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void landing() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("charge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void shutdown() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("discharge");
            int percentage = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.percentage = percentage;
            assertNotEquals(1,PrimaryFlightDisplay.instance.percentage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void close() {
        FlightRecorder.instance.shutdown();
        LogEngine.instance.close();
    }
}