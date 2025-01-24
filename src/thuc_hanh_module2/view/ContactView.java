package thuc_hanh_module2.view;

import thuc_hanh_module2.models.Contact;
import java.util.List;

public class ContactView {

    public void displayContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showSuccess(String message) {
        System.out.println("Success: " + message);
    }
}
