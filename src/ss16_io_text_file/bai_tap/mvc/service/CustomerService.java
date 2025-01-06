package ss16_io_text_file.bai_tap.mvc.service;

import ss16_io_text_file.bai_tap.mvc.model.Customer;
import ss16_io_text_file.bai_tap.mvc.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private final String FILE_PATH = "data/customers.csv";

    @Override
    public void addCustomer(Customer customer) {
        List<String> data = ReadAndWrite.readFile(FILE_PATH);
        data.add(customer.toCSV());
        ReadAndWrite.writeFile(FILE_PATH, data, false);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<String> data = ReadAndWrite.readFile(FILE_PATH);
        List<Customer> customers = new ArrayList<>();
        for (String line : data) {
            customers.add(Customer.fromCSV(line));
        }
        return customers;
    }

    @Override
    public boolean deleteCustomerByID(int id) {
        List<Customer> customers = getAllCustomers();
        boolean found = false;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            saveAll(customers);
        }
        return found;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        List<Customer> customers = getAllCustomers();
        boolean found = false;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                found = true;
                break;
            }
        }

        if (found) {
            saveAll(customers);
        }
        return found;
    }

    @Override
    public Customer getCustomerByID(int id) {
        List<Customer> customers = getAllCustomers();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    private void saveAll(List<Customer> customers) {
        List<String> data = new ArrayList<>();
        for (Customer customer : customers) {
            data.add(customer.toCSV());
        }
        ReadAndWrite.writeFile(FILE_PATH, data, false);
    }
}
