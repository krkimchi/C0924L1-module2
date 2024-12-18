package ss10_array_list.controller;

import java.util.Scanner;

public class MainController {
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final Scanner scanner;

    public MainController() {
        this.studentController = new StudentController();
        this.teacherController = new TeacherController();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int mainChoice;
        do {
            System.out.println("------Quản lý hệ thống-----");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý giáo viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn một chức năng: ");
            mainChoice = Integer.parseInt(scanner.nextLine());
            switch (mainChoice) {
                case 1:
                    manageStudentMenu();
                    break;
                case 2:
                    manageTeacherMenu();
                    break;
                case 3:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (mainChoice != 3);
    }

    private void manageStudentMenu() {
        studentController.showMenu();
    }

    private void manageTeacherMenu() {
        teacherController.showMenu();
    }
}
