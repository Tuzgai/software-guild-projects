package classmodelling;

/**
 *
 * @author Stuart
 */
public class HouseGPS {
    private final double xCoord, yCoord;
    private int buildingNumber;
    // Zip is a string because you don't need to do math on it and leading 0s are bad
    private String street, city, state, zip;
    
    public HouseGPS (double x, double y) {
        this.xCoord = x;
        this.yCoord = y;
    }
    
    public String getAddress() { 
        return "";
    }
    
    public double [] getCoords() {
        double [] arr = {this.xCoord, this.yCoord};
        return arr;
    }
    
    public double getDistanceFrom(HouseGPS location) {
        return 1;
    }
    
    // Getters and setters
    // Coordinates cannot be changed, everything else can.
    public double getxCoord() {
        return xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }
    
    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
