package ss4_object_class.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    // Bước 1: Khai báo các thuộc tính (properties) a, b, c và định nghĩa các phương thức khởi tạo (constructors).
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Bước 2: Định nghĩa các phương thức getter để truy cập giá trị của a, b, c
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    // Bước 3: Định nghĩa phương thức getDiscriminant() trả về delta theo công thức delta = b2 - 4ac.
    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    // Phương thức định nghĩa Root1
    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.pow(delta, 0.5)) / (2 * a);
        } else {
            return 0;
        }
    }

    // Phương thức định nghĩa Root2
    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.pow(delta, 0.5)) / (2 * a);
        } else {
            return 0;
        }
    }

    // Viết chương trình thực thi
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double delta = equation.getDiscriminant();

        if (delta > 0) {
            System.out.println("The equation has two roots " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("The equation has one root " + equation.getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}
