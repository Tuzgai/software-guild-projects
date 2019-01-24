package ShapesAndSuch;

/**
 *
 * @author Stuart
 */
public class Rectangle extends Shape {
    double side1, side2;
    
    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }
    
}
