package ss6_inheritance.bai_tap.point_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1.0f, 2.0f);
        System.out.println("Point: " + point);
        point.setXY(2.0f, 3.0f);
        System.out.println("Updated Point: " + point);

        MovablePoint movablePoint = new MovablePoint(3.0f, 5.0f, 2.0f, 2.0f);
        System.out.println("MovablePoint: " + movablePoint);

        movablePoint.move();
        System.out.println("Moved MovablePoint: " + movablePoint);

        movablePoint.setSpeed(3.0f, 3.0f);
        movablePoint.move();
        System.out.println("Moved MovablePoint with new speed: " + movablePoint);
    }
}

