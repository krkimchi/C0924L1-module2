package ss8_clean_code.controller;

import ss8_clean_code.service.CustomerService;
import ss8_clean_code.model.Customer;

import java.util.List;
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
                    Customer customer = inputDataForCustomer("add");
                    customerService.addCustomer(customer);
                    break;
                case 2:
                    List<Customer> list = customerService.getAllCustomers();
                    displayCustomer(list);
                    break;
                case 3:
                    int updateId = inputIdCustomer("Nhập ID cần cập nhật: ");
                    Customer cus = customerService.getCustomerByID(updateId);
                    if (cus != null) {
                        Customer newCustomer = inputDataForCustomer("update");
                        newCustomer.setId(updateId);
                        customerService.updateCustomer(newCustomer);
                        System.out.println("Update thành công");
                    } else {
                        System.out.println("ID không tồn tại");
                    }
                    break;
                case 4:
                    int id = inputIdCustomer("Nhập ID cần xóa: ");
                    boolean isSuccess = customerService.deleteCustomerByID(id);
                    if (isSuccess) {
                        System.out.print("Đã xóa thành công");
                    } else {
                        System.out.print("Không tìm thấy ID");
                    }
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

    private Customer inputDataForCustomer(String type) {
        int id = -1;
        if (type.equals("add")) {
            System.out.print("Nhập ID khách hàng: ");
            id = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh khách hàng: ");
        String dob = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, dob, address);
        return customer;
    }

    private void displayCustomer(List<Customer> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }
        System.out.println("===Danh sách khách hàng===");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    private int inputIdCustomer(String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Phải là 1 số nguyên");
            }
        }
    }
}
