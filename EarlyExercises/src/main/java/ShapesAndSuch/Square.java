package ShapesAndSuch;

/**
 *
 * @author Stuart
 */
public class Square extends Shape {

    double side;

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

}
