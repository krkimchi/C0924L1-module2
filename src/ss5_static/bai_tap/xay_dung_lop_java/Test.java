package ss5_static.bai_tap.xay_dung_lop_java;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        System.out.println("=====Ban đầu=====");
        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClasses());

        student.setName("Eric");
        student.setClasses("C09");

        System.out.println("\n=====Sau khi thêm giá trị mới=====");
        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClasses());
    }
}
