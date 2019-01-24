package classmodelling;

/**
 *
 * @author Stuart
 */
public class AirplaneATC {
    private double longitude, latitude, altitude;
    private double fuelRemaining;
    private double [] headingVector; // 6 values - direction and velocity in x,y,z
    private final String name;
    private final String model;
    private int passengers;

    AirplaneATC (String name, String model) {
        this.name = name;
        this.model = model;
    }
    
    public double[] getHeadingVector() {
        return headingVector;
    }

    public void setHeadingVector(double[] headingVector) {
        this.headingVector = headingVector;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
    
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getFuelRemaining() {
        return fuelRemaining;
    }

    public void setFuelRemaining(double fuelRemaining) {
        this.fuelRemaining = fuelRemaining;
    }
}
