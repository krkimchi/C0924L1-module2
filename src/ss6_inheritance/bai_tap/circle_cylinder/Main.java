package ss6_inheritance.bai_tap.circle_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        Cylinder cylinder = new Cylinder(4.0, "white", 5.0);
        System.out.println(cylinder);
    }
}
