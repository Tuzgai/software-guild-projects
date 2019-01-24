package classmodelling;

import java.util.Date;

/**
 *
 * @author Stuart
 */
public class IceCreamStock {
    private final String name;
    private double cost;
    private int stockLevel;
    private boolean timeToReorder;
    private boolean reorderIncoming;
    private Date reorderDue;

    public IceCreamStock(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public boolean isTimeToReorder() {
        return timeToReorder;
    }

    public void setTimeToReorder(boolean timeToReorder) {
        this.timeToReorder = timeToReorder;
    }

    public boolean isReorderIncoming() {
        return reorderIncoming;
    }

    public void setReorderIncoming(boolean reorderIncoming) {
        this.reorderIncoming = reorderIncoming;
    }

    public Date getReorderDue() {
        return reorderDue;
    }

    public void setReorderDue(Date reorderDue) {
        this.reorderDue = reorderDue;
    }
    
}
