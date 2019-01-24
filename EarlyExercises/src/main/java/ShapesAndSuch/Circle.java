package ShapesAndSuch;

/**
 *
 * @author Stuart
 */
public class Circle extends Shape {

    double radius;
    final double PI = 3.14;

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
