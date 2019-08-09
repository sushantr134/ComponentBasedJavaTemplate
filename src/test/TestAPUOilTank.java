package test;

import base.PrimaryFlightDisplay;
import factory.ApuOilTankFactory;
import factory.BatteryFactory;
import logging.LogEngine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recorder.FlightRecorder;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class APUOilTank {
    private Object componentPort;

    @BeforeEach
    public void init() {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();
    }

    @Test
    public void factory() {
        componentPort = ApuOilTankFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void methods() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase",int.class);
            assertNotEquals(0,onMethod);

            Method offMethod = componentPort.getClass().getDeclaredMethod("Decrease",int.class);
            assertNotNull(offMethod);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Increase() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase",int.class);
            int level = (int) onMethod.invoke(componentPort);
            assertNotEquals(0,level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Decrease() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Decrease",int.class);
            int level = (int) onMethod.invoke(componentPort);
            assertEquals(0,level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void startup() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase",int.class);
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void taxi() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase",int.class);
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void takeoff() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void climbing() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void rightTurn() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void leftTurn() {
        componentPort = BatteryFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Increase");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void descent() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Decrease");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void landing() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Decrease");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(0,PrimaryFlightDisplay.instance.level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void shutdown() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("Decrease");
            int level = (int) onMethod.invoke(componentPort);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(1,PrimaryFlightDisplay.instance.level);
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