package ss7_interface_abstract_class.bai_tap.colorable;

import ss7_interface_abstract_class.bai_tap.code_gym.Circle;
import ss7_interface_abstract_class.bai_tap.code_gym.Rectangle;
import ss7_interface_abstract_class.bai_tap.code_gym.Shape;
import ss7_interface_abstract_class.bai_tap.code_gym.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.0);
        shapes[1] = new Rectangle(2.0, 4.0);
        shapes[2] = new Square(5.0);

        for (Shape shape : shapes) {
            System.out.println("Shape details:");
            System.out.println(shape);

            if (shape instanceof Circle) {
                System.out.println("Area: " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Area: " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("Area: " + ((Square) shape).getArea());
            }

            if (shape instanceof IColorable) {
                ((IColorable) shape).howToColor();
            }
            System.out.println();
        }
    }
}
