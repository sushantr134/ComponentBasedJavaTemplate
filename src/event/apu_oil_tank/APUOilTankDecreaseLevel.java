package event.apu_oil_tank;

public class APUOilTankDecreaseLevel {
    int level;
    public APUOilTankDecreaseLevel(int level) {
        this.level = level;
    }
    public String toString() {
        return "Event: APUOilTank - DecreaseLevel";
    }
}
