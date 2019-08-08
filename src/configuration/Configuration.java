package configuration;

public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String commonPathToJavaArchive = userDirectory + fileSeparator + "components" + fileSeparator;

    public String lineSeparator = System.getProperty("line.separator");
    public String logFileDirectory = userDirectory + fileSeparator + "log" + fileSeparator;
    public String logFile = logFileDirectory + "airbus_a380.log";

    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String databaseFile = dataDirectory + "flight_recorder_airbus_a380.db";

    // weather_radar
    public String pathToWeatherRadarJavaArchive = commonPathToJavaArchive + "weather_radar" + fileSeparator + "jar" + fileSeparator + "weather_radar.jar";
    public int numberOfWeatherRadar = 2;

    //tourist_class_seat
     public String pathToTouristClassSeatJavaArchive = commonPathToJavaArchive + "tourist-class-seat" + fileSeparator + "jar" + fileSeparator + "tourist-class-seat.jar";
     public int numberOfTouristClassSeat = 480;

}