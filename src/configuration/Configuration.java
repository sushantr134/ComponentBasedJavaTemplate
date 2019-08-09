package configuration;

public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String commonPathToJavaArchive = userDirectory + fileSeparator + "components" + fileSeparator;

    public String lineSeparator = System.getProperty("line.separator");
    public String logFileDirectory = userDirectory + fileSeparator + "log" + fileSeparator;
    public String logFile = logFileDirectory + "A380.log";
    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String databaseFile = dataDirectory + "flightRecorderA380.db";


    //battery
    public String pathToBatteryJavaArchive = commonPathToJavaArchive + "battery" + fileSeparator + "jar" + fileSeparator + "battery.jar";
    public int numberOfBattery = 24;

    //apu_oil_tank
    public String pathToApuOilTankJavaArchive = commonPathToJavaArchive + "apu_oil_tank" + fileSeparator + "jar" + fileSeparator + "apu_oil_tank.jar";
    public int numberOfApuOilTank = 2;
}