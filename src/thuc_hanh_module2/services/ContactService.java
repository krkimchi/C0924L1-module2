package thuc_hanh_module2.services;

import thuc_hanh_module2.models.Contact;
import thuc_hanh_module2.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public void saveContactsToFile() {
        FileUtils.writeContactsToFile(contacts);
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
