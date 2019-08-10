package base;

import com.google.common.eventbus.EventBus;
import event.Subscriber;
import event.battery.BatteryCharge;
import event.battery.BatteryDischarge;
import event.apu_oil_tank.APUOilTankDecreaseLevel;
import event.apu_oil_tank.APUOilTankIncreaseLevel;
import section.Body;
import section.Wing;

public class Airplane implements IAirplane {
    private EventBus eventBus;
    private Body body;
    private Wing leftWing;
    private Wing rightWing;

    public Airplane() {
        eventBus = new EventBus("EB-A380");
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void build() {
        body = new Body();
        addSubscriber(body);

        leftWing = new Wing();
        addSubscriber(leftWing);

        rightWing = new Wing();
        addSubscriber(rightWing);
    }

    public void startup() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankIncreaseLevel(100));
    }

    public void taxi() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(1));
    }

    public void takeoff() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(1));
    }

    public void climbing() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(10));
    }

    public void rightTurn() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(10));;
    }

    public void leftTurn() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(20));
    }

    public void descent() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(10));
    }

    public void landing() {
        // battery
        eventBus.post(new BatteryCharge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(10));
    }

    public void shutdown() {
        // battery
        eventBus.post(new BatteryDischarge());
        //apu_oil_tank
        eventBus.post(new APUOilTankDecreaseLevel(10));
    }
}