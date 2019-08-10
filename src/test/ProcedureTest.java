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

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(2)
    public void taxiTest() {
        cockpit.taxi();

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);;
    }

    @Test
    @Order(3)
    public void takeOffTest() {
        cockpit.takeoff();
        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(4)
    public void climbingTest() {
        cockpit.climbing();

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(5)
    public void rightTurnTest() {
        cockpit.rightTurn();

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(6)
    public void leftTurnTest() {
        cockpit.leftTurn();

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(7)
    public void descentTest() {
        cockpit.descent();

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(8)
    public void landingTest() {
        cockpit.landing();

        //apu_oil_tank
        assertNotEquals(0,PrimaryFlightDisplay.instance.level);
    }

    @Test
    @Order(9)
    public void shutdownTest() {
        cockpit.shutdown();

        //apu_oil_tank
        assertNotEquals(100,PrimaryFlightDisplay.instance.level);
    }
}