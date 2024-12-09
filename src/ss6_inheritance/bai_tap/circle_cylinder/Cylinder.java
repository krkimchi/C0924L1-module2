package ss6_inheritance.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder [radius = " + getRadius() + ", color = " + getColor() + ", height = " + getHeight() + ", volume = " + getVolume() + "]";
    }
}
