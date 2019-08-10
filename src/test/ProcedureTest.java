package test;

import base.Airplane;
import base.Cockpit;
import base.PrimaryFlightDisplay;
import logging.LogEngine;
import org.junit.jupiter.api.*;
import recorder.FlightRecorder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProcedureTest {
    private Airplane airplane;
    private Cockpit cockpit;

    @BeforeEach
    public void init() {
        LogEngine.instance.init();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        airplane = new Airplane();
        airplane.build();

        cockpit = new Cockpit(airplane);
    }

    @Test
    @Order(1)
    public void startUpTest() {
        cockpit.startup();

        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(2)
    public void taxiTest() {
        cockpit.taxi();

        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(3)
    public void takeOffTest() {
        cockpit.takeoff();
        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(4)
    public void climbingTest() {
        cockpit.climbing();
        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(5)
    public void rightTurnTest() {
        cockpit.rightTurn();
        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(6)
    public void leftTurnTest() {
        cockpit.leftTurn();
        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);
    }

    @Test
    @Order(7)
    public void descentTest() {
        cockpit.descent();
        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(8)
    public void landingTest() {
        cockpit.landing();
        // battery
        assertNotEquals(0,PrimaryFlightDisplay.instance.percentage);

    }

    @Test
    @Order(9)
    public void shutdownTest() {
        cockpit.shutdown();
        // battery
        assertNotEquals(1,PrimaryFlightDisplay.instance.percentage);

    }
}