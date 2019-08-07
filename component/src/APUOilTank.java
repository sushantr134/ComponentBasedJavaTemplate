public class APUOilTank {
    private static APUOilTank instance = new APUOilTank();
    public Port port;
    private String manufacturer = "<Abhishek Chauhan>";
    private String type="team<28>";
    private String id = "<161B294>";
    private int level=0;

    //instance declaration
    public APUOilTank(){
        port = new Port();
    }
    public static APUOilTank getinstance()
    {
        return instance;
    }

    //inner methods defined
    public String innerVersion(){
        return "APUOilTank//"+ manufacturer+ "-"+type+ "-"+id;
    }
    public int innerIncreaseLevel(){
        level++;
        return level;
    }
    public int innerDecreaseLevel(){
        level--;
        return level;
    }
    public class Port implements IAPUOilTank{
        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int increase(int value) {
            return innerIncreaseLevel();
        }

        @Override
        public int decrease(int value) {
            return innerDecreaseLevel();
        }

    }

}
