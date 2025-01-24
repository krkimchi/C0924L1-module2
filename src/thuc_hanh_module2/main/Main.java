package thuc_hanh_module2.main;

import thuc_hanh_module2.controller.ContactController;
import thuc_hanh_module2.models.Contact;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContactController controller = new ContactController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -----");
                System.out.println("Chọn chức năng theo số (để tiếp tục):");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Tìm kiếm");
                System.out.println("6. Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        controller.displayContacts();
                        break;
                    case 2:
                        System.out.print("Nhập số điện thoại: ");
                        String phone = scanner.nextLine();
                        System.out.print("Nhập nhóm: ");
                        String group = scanner.nextLine();
                        System.out.print("Nhập họ tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giới tính: ");
                        String gender = scanner.nextLine();
                        System.out.print("Nhập địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.print("Nhập ngày sinh: ");
                        String birthDate = scanner.nextLine();
                        System.out.print("Nhập email: ");
                        String email = scanner.nextLine();

                        Contact contact = new Contact(phone, group, name, gender, address, birthDate, email);
                        controller.addContact(contact);
                        break;
                    case 3:
                        System.out.print("Nhập số điện thoại của danh bạ cần cập nhật: ");
                        String phoneUpdate = scanner.nextLine().trim();
                        List<Contact> contacts = controller.searchContacts(phoneUpdate);
                        if (contacts.isEmpty()) {
                            System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneUpdate);
                        } else {
                            Contact contactToUpdate = contacts.get(0);
                            System.out.println("Thông tin hiện có: " + contactToUpdate);

                            System.out.print("Nhập nhóm mới: ");
                            String newGroup = scanner.nextLine();
                            System.out.print("Nhập họ tên mới: ");
                            String newName = scanner.nextLine();
                            System.out.print("Nhập giới tính mới: ");
                            String newGender = scanner.nextLine();
                            System.out.print("Nhập địa chỉ mới: ");
                            String newAddress = scanner.nextLine();
                            System.out.print("Nhập ngày sinh mới: ");
                            String newBirthDate = scanner.nextLine();
                            System.out.print("Nhập email mới: ");
                            String newEmail = scanner.nextLine();

                            Contact updatedContact = new Contact(phoneUpdate, newGroup, newName, newGender, newAddress, newBirthDate, newEmail);
                            controller.updateContact(phoneUpdate, updatedContact);
                        }
                        break;
                    case 4:
                        System.out.print("Nhập số điện thoại của danh bạ muốn xóa: ");
                        String phoneDelete = scanner.nextLine();
                        controller.deleteContact(phoneDelete);
                        break;
                    case 5:
                        System.out.print("Nhập thông tin tìm kiếm: ");
                        String searchTerm = scanner.nextLine();
                        List<Contact> searchResults = controller.searchContacts(searchTerm);
                        if (searchResults.isEmpty()) {
                            System.out.println("Không tìm thấy kết quả tìm kiếm.");
                        } else {
                            controller.displayContacts(searchResults);
                        }
                        break;
                    case 6:
                        controller.readContactsFromFile();
                        break;
                    case 7:
                        controller.saveContactsToFile();
                        break;
                    case 8:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Chọn lại chức năng.");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}
