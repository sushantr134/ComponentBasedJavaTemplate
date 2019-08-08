package base;

public enum PrimaryFlightDisplay {
    instance;

    // weather_radar
    public boolean isWeatherRadarOn;
    public boolean isCloudScanned;

    // touristClassSeat
    public boolean isSmokingSignOn;
    public boolean isSeatBeltSignOn;
    public int level;
    public Passenger passenger;
}
