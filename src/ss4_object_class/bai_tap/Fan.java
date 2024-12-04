package ss4_object_class.bai_tap;

public class Fan {
    // 2 hằng được đặt tên là SLOW, MEDIUM, và FAST với giá trị 1, 2, và 3 để biểu thị tốc độ quạt.
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;

    // Trường speed có kiểu số nguyên (private int) để xác định tốc độ quạt, mặc định là SLOW
    private int speed = SLOW;

    // Trường on có kiểu private boolean để xác định quạt đang bật hay tắt, mặc định là false (tắt).
    private boolean on = false;

    // Trường radius có kiểu private double để xác định bán kính quạt, giá trị mặc định là 5
    private double radius = 5;

    // Trường color có kiểu dữ liệu private String để xác định màu quạt, mặc định là blue
    private String color = "blue";

    // Các getter và setter cho các thuộc tính
    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Phương thức khởi tạo không tham số tạo đối tượng fan mặc định
    public Fan() {}

    // Phương thức toString
    @Override
    public String toString() {
        if (on) {
            return "Fan is on: speed = " + speed + ", color = " + color + ", radius = " + radius;
        } else {
            return "Fan is off: color = " + color + ", radius = " + radius;
        }
    }

    public static void main(String[] args) {
        // Đối tượng Fan 1: Gán giá trị lớn nhất cho speed, radius là 10, color là yellow và quạt ở trạng thái bật.
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.getFAST());
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        // Đối tượng Fan 2: Gán giá trị trung bình cho speed, radius là 5, color là blue và quạt ở trạng thái tắt
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.getMEDIUM());
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1);
        System.out.println(fan2);
    }
}
