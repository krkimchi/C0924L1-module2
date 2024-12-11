package ss7_interface_abstract_class.bai_tap.code_gym;

import ss7_interface_abstract_class.bai_tap.colorable.Colorable;
import ss7_interface_abstract_class.bai_tap.resizeable.Resizeable;

public class Square extends Shape implements Resizeable, Colorable {
    private double side;

    public Square() {
        this.side = 1.0;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public void resize(double percent) {
        this.side += this.side * percent / 100;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
