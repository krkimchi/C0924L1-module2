package thuc_hanh_module2.utils;

import thuc_hanh_module2.models.Contact;

import java.io.*;
import java.util.*;

public class FileUtils {

    private static final String FILE_PATH = "src/thuc_hanh_module2/data/contacts.csv";

    public static List<Contact> readContactsFromFile() {
        List<Contact> contacts = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    Contact contact = new Contact(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contacts;
    }

    public static void writeContactsToFile(List<Contact> contacts) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_PATH));
            for (Contact contact : contacts) {
                String line = contact.getPhoneNumber() + "," + contact.getGroup() + "," + contact.getName() + "," +
                        contact.getGender() + "," + contact.getAddress() + "," + contact.getBirthDate() + "," + contact.getEmail();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
