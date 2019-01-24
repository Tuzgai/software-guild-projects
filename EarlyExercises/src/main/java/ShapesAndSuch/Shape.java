package ShapesAndSuch;

/**
 *
 * @author Stuart
 */
public abstract class Shape {

    String color;

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
