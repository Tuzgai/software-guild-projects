package classmodelling;

/**
 *
 * @author Stuart
 */
public class AirplaneSim {
    private double longitude, latitude, altitude, pitch, yaw;
    private double fuelRemaining, damageTaken;
    private double [] headingVector; // 6 values - direction and velocity in x,y,z
    private String name;
    private final String model;
    
    public AirplaneSim (String model) {
        this.model = model;
    }
    
    public double getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(double damageTaken) {
        this.damageTaken = damageTaken;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getFuelRemaining() {
        return fuelRemaining;
    }

    public void setFuelRemaining(double fuelRemaining) {
        this.fuelRemaining = fuelRemaining;
    }

    public double[] getHeadingVector() {
        return headingVector;
    }

    public void setHeadingVector(double[] headingVector) {
        this.headingVector = headingVector;
    }
    
}