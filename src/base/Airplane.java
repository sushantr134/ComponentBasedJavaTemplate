package base;

import section.Body;
import section.Wing;

public class Airplane {
    private Body body;
    private Wing leftWing;
    private Wing rightWing;

    public Body getBody() {
        return body;
    }

    public Wing getLeftWing() {
        return leftWing;
    }

    public Wing getRightWing() {
        return rightWing;
    }

    public void build() {
        body = new Body();
        leftWing = new Wing();
        rightWing = new Wing();
    }

    public void startup() {
        //battery
        body.setBatteryCharge();

        //apu_oil_tank
        body.setApuOilTankIncreaseLevel(100);
    }

    public void taxi() {
        // weather_radar

    }

    public void takeoff() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("sky");
    }

    public void climbing() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("sky");
    }

    public void cruise() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("cloud");
    }

    public void rightTurn() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("sky");
    }

    public void leftTurn() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("sky");
    }

    public void descent() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("sky");
    }

    public void landing() {
        // weather_radar
//        body.weatherRadarOn();
//        body.weatherRadarScan("sky");
    }

    public void shutdown() {
        //battery
        body.setBatteryDischarge();

        //apu_oil_tank
        body.setApuOilTankDecreaseLevel(0);
    }
}
