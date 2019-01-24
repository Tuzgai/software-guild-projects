package classmodelling;

/**
 *
 * @author Stuart
 */
public class House3D {
    private String title, designer;
    private int xCoord, yCoord, zCoord;
    private ModelObject [] models; // The design is a collection of 3d objects
    
    public House3D (String title, String designer) {
        this.title = title;
        this.designer = designer;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getzCoord() {
        return zCoord;
    }

    public void setzCoord(int zCoord) {
        this.zCoord = zCoord;
    }

    public ModelObject[] getModels() {
        return models;
    }

    public void setModels(ModelObject[] models) {
        this.models = models;
    }
}
