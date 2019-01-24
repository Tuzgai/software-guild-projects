package ShapesAndSuch;

/**
 *
 * @author Stuart
 */
public class Triangle extends Shape {

    double a, b, c;

    // User Heron's formula - https://www.mathopenref.com/heronsformula.html
    @Override
    public double getArea() {
        double p = getPerimeter();
        return Math.sqrt(p * (p - a) * (p - b) * (b - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

}
