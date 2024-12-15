package ss8_clean_code.controller;

import ss8_clean_code.service.CustomerService;
import ss8_clean_code.model.Customer;
import java.util.Scanner;

public class CustomerController {
    private CustomerService customerService;
    private Scanner scanner;

    public CustomerController() {
        customerService = new CustomerService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("----- Quản lý khách hàng -----");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Cập nhật khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Thoát");
            System.out.print("Chọn một chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    showCustomers();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        } while (choice != 5);
    }

    private void addCustomer() {
        System.out.print("Nhập ID khách hàng: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh khách hàng: ");
        String dob = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, dob, address);
        customerService.addCustomer(customer);
        System.out.println("Khách hàng đã được thêm.");
    }

    private void showCustomers() {
        customerService.displayCustomers();
    }

    private void updateCustomer() {
        System.out.print("Nhập ID khách hàng cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập ngày sinh mới: ");
        String newDob = scanner.nextLine();
        System.out.print("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();

        Customer customer = new Customer(id, newName, newDob, newAddress);
        if (customerService.updateCustomer(customer)) {
            System.out.println("Khách hàng đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy khách hàng với ID: " + id);
        }
    }

    private void deleteCustomer() {
        System.out.print("Nhập ID khách hàng cần xóa: ");
        int id = scanner.nextInt();
        if (customerService.deleteCustomer(id)) {
            System.out.println("Khách hàng đã được xóa.");
        } else {
            System.out.println("Không tìm thấy khách hàng với ID: " + id);
        }
    }
}
