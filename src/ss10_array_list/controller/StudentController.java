package ss10_array_list.controller;

import ss10_array_list.model.Student;
import ss10_array_list.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentService studentService;
    private Scanner scanner;

    public StudentController() {
        studentService = new StudentService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n----- Quản lý sinh viên -----");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn một chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    List<Student> list = studentService.getAllStudents();
                    displayStudent(list);
                    break;
                case 3:
                    int updateId = inputInt("Nhập ID cần cập nhật: ");
                    Student student = studentService.getStudentById(updateId);
                    if (student != null) {
                        Student newStudent = inputStudentData("update");
                        newStudent.setId(updateId);
                        studentService.updateStudent(newStudent);
                        System.out.println("Cập nhật sinh viên thành công!");
                    } else {
                        System.out.println("ID không tồn tại");
                    }
                    break;
                case 4:
                    int id = inputInt("Nhập ID cần xóa: ");
                    boolean isSuccess = studentService.deleteStudent(id);
                    if (isSuccess) {
                        System.out.println("Xóa sinh viên thành công!");
                    } else {
                        System.out.println("Không tìm thấy sinh viên với ID này.");
                    }
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        } while (choice != 5);
    }

    private Student inputStudentData(String type) {
        int id = -1;
        if (type.equals("add")) {
            System.out.print("Nhập ID sinh viên: ");
            id = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = inputInt("Nhập tuổi sinh viên: ");
        System.out.print("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();

        return new Student(id, name, age, address);
    }

    private void displayStudent(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("===Danh sách sinh viên===");
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    private void addStudent() {
        Student student = inputStudentData("add");
        studentService.addStudent(student);
        System.out.println("Đã thêm sinh viên thành công!");
    }

    private int inputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Phải là 1 số nguyên.");
            }
        }
    }
}
