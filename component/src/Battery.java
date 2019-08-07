public class Battery {
    private static Battery instance = new Battery();
    public Port port;
    private String manufacturer = "<sushant singh>";
    private String type = "<QA2>";
    private String id = "<161b301>";
    private int percentage = 0;

    private Battery() {
        port = new Port();
    }

    public static Battery getInstance() {
        return instance;
    }

    //innerMethods
    public String innerVersion() {
        return manufacturer+" // "+ type+" // "+ id;
    }

    public int innerCharge() {
        percentage++;
        return percentage;
    }

    public int innerDischarge() {
        percentage--;
        return percentage;
    }

    public class Port implements IBattery {
        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int charge() {
            return innerCharge();
        }

        @Override
        public int discharge() {
            return innerDischarge();
        }

    }
}
