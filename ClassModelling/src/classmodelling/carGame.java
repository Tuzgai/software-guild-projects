package classmodelling;

/**
 *
 * @author Stuart
 */
public class carGame {
    private final String make; 
    private final String model;
    private double velocity, acceleration, xCoord, yCoord, wheelAngle;
    private final double weight;
    private final double tractionCoefficient;  
    private final double turnRadius;
    private final double maxSpeed;
    private final double maxAcceleration;

    public carGame(String make, String model, double weight, double tractionCoefficient, double turnRadius, double maxAcceleration, double maxSpeed) {
        this.make = make;
        this.model = model;
        this.weight = weight;
        this.tractionCoefficient = tractionCoefficient;
        this.turnRadius = turnRadius;
        this.maxAcceleration = maxAcceleration;
        this.maxSpeed = maxSpeed;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public double getWheelAngle() {
        return wheelAngle;
    }

    public void setWheelAngle(double wheelAngle) {
        this.wheelAngle = wheelAngle;
    }
    
    
}
