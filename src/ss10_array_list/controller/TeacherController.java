package ss10_array_list.controller;

import ss10_array_list.model.Teacher;
import ss10_array_list.service.TeacherService;

import java.util.List;
import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService;
    private Scanner scanner;

    public TeacherController() {
        teacherService = new TeacherService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n----- Quản lý giáo viên -----");
            System.out.println("1. Thêm giáo viên");
            System.out.println("2. Hiển thị danh sách giáo viên");
            System.out.println("3. Cập nhật giáo viên");
            System.out.println("4. Xóa giáo viên");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn một chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    List<Teacher> list = teacherService.getAllTeachers();
                    displayTeacher(list);
                    break;
                case 3:
                    int updateId = inputInt("Nhập ID cần cập nhật: ");
                    Teacher teacher = teacherService.getTeacherById(updateId);
                    if (teacher != null) {
                        Teacher newTeacher = inputTeacherData("update");
                        newTeacher.setId(updateId);
                        teacherService.updateTeacher(newTeacher);
                        System.out.println("Cập nhật giáo viên thành công!");
                    } else {
                        System.out.println("ID không tồn tại");
                    }
                    break;
                case 4:
                    int id = inputInt("Nhập ID cần xóa: ");
                    boolean isSuccess = teacherService.deleteTeacher(id);
                    if (isSuccess) {
                        System.out.println("Xóa giáo viên thành công!");
                    } else {
                        System.out.println("Không tìm thấy giáo viên với ID này.");
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

    private Teacher inputTeacherData(String type) {
        int id = -1;
        if (type.equals("add")) {
            System.out.print("Nhập ID giáo viên: ");
            id = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Nhập tên giáo viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập môn dạy: ");
        String subject = scanner.nextLine();
        System.out.print("Nhập lương: ");
        double salary = Double.parseDouble(scanner.nextLine());

        return new Teacher(id, name, subject, salary);
    }

    private void displayTeacher(List<Teacher> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách giáo viên trống.");
        } else {
            System.out.println("===Danh sách giáo viên===");
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        }
    }

    private void addTeacher() {
        Teacher teacher = inputTeacherData("add");
        teacherService.addTeacher(teacher);
        System.out.println("Đã thêm giáo viên thành công!");
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
