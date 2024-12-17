package ss8_clean_code.service;

import ss8_clean_code.model.Customer;

import java.util.List;

public interface ICustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    boolean deleteCustomerByID(int id);
    boolean updateCustomer(Customer customer);
    Customer getCustomerByID(int id);
}
