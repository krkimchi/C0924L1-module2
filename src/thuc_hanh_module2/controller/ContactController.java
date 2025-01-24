package thuc_hanh_module2.controller;

import thuc_hanh_module2.models.Contact;
import thuc_hanh_module2.services.ContactService;
import thuc_hanh_module2.utils.FileUtils;
import thuc_hanh_module2.view.ContactView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactController {
    private ContactService contactService;
    private ContactView contactView;

    public ContactController() {
        this.contactService = new ContactService();
        this.contactView = new ContactView();
    }

    public void displayContacts() {
        List<Contact> contacts = FileUtils.readContactsFromFile();

        if (contacts.isEmpty()) {
            contactView.showError("Không có danh bạ nào để hiển thị.");
        } else {
            contactView.displayContacts(contacts);
        }
    }

    public void addContact(Contact contact) {
        List<Contact> contacts = FileUtils.readContactsFromFile();
        contacts.add(contact);
        FileUtils.writeContactsToFile(contacts);
        contactView.showSuccess("Contact added successfully!");
    }

    public void updateContact(String phoneNumber, Contact updatedContact) {
        List<Contact> contacts = FileUtils.readContactsFromFile();
        boolean contactFound = false;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.set(i, updatedContact);
                contactFound = true;
                break;
            }
        }

        if (contactFound) {
            FileUtils.writeContactsToFile(contacts);
            System.out.println("Danh bạ đã được cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
        }
    }

    public void deleteContact(String phoneNumber) {
        List<Contact> contacts = FileUtils.readContactsFromFile();
        boolean contactFound = false;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(i);
                contactFound = true;
                break;
            }
        }

        if (contactFound) {
            FileUtils.writeContactsToFile(contacts);
            System.out.println("Danh bạ đã được xóa thành công!");
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
        }
    }

    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> contacts = FileUtils.readContactsFromFile();
        List<Contact> result = new ArrayList<>();
        searchTerm = searchTerm.trim().toLowerCase();

        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().toLowerCase().contains(searchTerm) ||
                    contact.getName().toLowerCase().contains(searchTerm)) {
                result.add(contact);
            }
        }
        return result;
    }


    public void readContactsFromFile() {
        System.out.print("Bạn có chắc chắn muốn cập nhật lại danh bạ từ file? (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            List<Contact> contacts = FileUtils.readContactsFromFile();
            contactService.setContacts(contacts);
            contactView.showSuccess("Danh bạ đã được cập nhật từ file.");
        } else {
            contactView.showError("Quá trình cập nhật danh bạ từ file đã bị hủy.");
        }
    }


    public void saveContactsToFile() {
        System.out.print("Bạn có chắc chắn muốn ghi đè danh bạ vào file? (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            List<Contact> contacts = contactService.getAllContacts();
            FileUtils.writeContactsToFile(contacts);
            contactView.showSuccess("Danh bạ đã được ghi vào file.");
        } else {
            contactView.showError("Quá trình lưu danh bạ vào file đã bị hủy.");
        }
    }


    public void displayContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            contactView.showError("Không có danh bạ nào để hiển thị.");
        } else {
            contactView.displayContacts(contacts);
        }
    }

}
