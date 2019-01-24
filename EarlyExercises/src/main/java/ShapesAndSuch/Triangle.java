package ShapesAndSuch;

/**
 *
 * @author Stuart
 */
public class Triangle extends Shape {
    double height, base, sideB, sideC;

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public double getPerimeter() {
        return base + sideB + sideC;
    }
    
    
}
