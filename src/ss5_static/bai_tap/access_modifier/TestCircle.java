package ss5_static.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());

        Circle circle2 = new Circle(5);
        System.out.println("\nRadius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
    }
}
