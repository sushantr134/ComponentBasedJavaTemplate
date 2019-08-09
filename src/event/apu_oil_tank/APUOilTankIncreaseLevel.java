package event.apu_oil_tank;

public class APUOilTankIncreaseLevel {
    int level;
    public APUOilTankIncreaseLevel(int level) {
        this.level = level;
    }
    public String toString() {
        return "Event: APUOilTank - IncreaseLevel";
    }
}
