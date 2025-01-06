package ss16_io_text_file.bai_tap.mvc.service;

import ss16_io_text_file.bai_tap.mvc.model.Customer;

import java.util.List;

public interface ICustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    boolean deleteCustomerByID(int id);
    boolean updateCustomer(Customer customer);
    Customer getCustomerByID(int id);
}
