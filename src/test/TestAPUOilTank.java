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

class TestAPUOilTank {
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("increase",int.class);
            assertNotNull(onMethod);

            Method offMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            assertNotNull(offMethod);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Increase() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("increase",int.class);
            int level = (int) onMethod.invoke(componentPort,100);
            assertEquals(100,level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Decrease() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,10);
            assertNotEquals(100,level);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void startup() {
        componentPort = ApuOilTankFactory.build();
        try {
            Method onMethod = componentPort.getClass().getDeclaredMethod("increase",int.class);
            int level = (int) onMethod.invoke(componentPort,100);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,1);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,1);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,10);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,10);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,10);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,10);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,20);
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
            Method onMethod = componentPort.getClass().getDeclaredMethod("decrease",int.class);
            int level = (int) onMethod.invoke(componentPort,50);
            PrimaryFlightDisplay.instance.level = level;
            assertNotEquals(100,PrimaryFlightDisplay.instance.level);
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