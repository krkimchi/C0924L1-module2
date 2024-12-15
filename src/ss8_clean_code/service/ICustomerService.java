package ss8_clean_code.service;

import ss8_clean_code.model.Customer;

public interface ICustomerService {
    void addCustomer(Customer customer);
    void displayCustomers();
    boolean deleteCustomer(int id);
    boolean updateCustomer(Customer customer);
}
