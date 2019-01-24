package classmodelling;

/**
 *
 * @author Stuart
 */
public class IceCreamMachine {
    private final String name;
    private double creamSupply, sugarSupply, flavorSupply;
    private double churnRate, flowRate;
    private boolean jam, overfill, underfill;
    
    public double getCreamSupply() {
        return creamSupply;
    }

    public void updateFromSensors() {
        
    }
    
    public void reportError() {
        
    }
    
    public void startUp() {
        
    }
    
    public void shutDown() {
        
    }
    
    public void setCreamSupply(double creamSupply) {
        this.creamSupply = creamSupply;
    }

    public double getSugarSupply() {
        return sugarSupply;
    }

    public void setSugarSupply(double sugarSupply) {
        this.sugarSupply = sugarSupply;
    }

    public double getFlavorSupply() {
        return flavorSupply;
    }

    public void setFlavorSupply(double flavorSupply) {
        this.flavorSupply = flavorSupply;
    }

    public double getChurnRate() {
        return churnRate;
    }

    public void setChurnRate(double churnRate) {
        this.churnRate = churnRate;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

    public boolean isJam() {
        return jam;
    }

    public void setJam(boolean jam) {
        this.jam = jam;
    }

    public boolean isOverfill() {
        return overfill;
    }

    public void setOverfill(boolean overfill) {
        this.overfill = overfill;
    }

    public boolean isUnderfill() {
        return underfill;
    }

    public void setUnderfill(boolean underfill) {
        this.underfill = underfill;
    }

    public IceCreamMachine(String name) {
        this.name = name;
    }
}
