package ss6_inheritance.bai_tap.circle_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 2.0;
        this.color = "black";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius = " + radius + ", color = " + color + ", area = " + getArea() + "]";
    }
}
