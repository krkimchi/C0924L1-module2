package ss8_clean_code.service;

import ss8_clean_code.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private List<Customer> customerList;

    public CustomerService() {
        customerList = new ArrayList<>();

        customerList.add(new Customer(1, "Nguyễn Văn A", "1/1/2000", "Hà Nội"));
        customerList.add(new Customer(2, "Nguyễn Văn B", "2/2/2000", "Hồ Chí Minh"));
        customerList.add(new Customer(3, "Nguyễn Thị C", "3/3/2000", "Đà Nẵng"));
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerList;
    }

    @Override
    public boolean deleteCustomerByID(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                System.out.println("Xóa khách hàng thành công: " + customerList.get(i));
                customerList.remove(i);
                return true;
            }
        }
        System.out.println("Không tìm thấy khách hàng với ID: " + id);
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == customer.getId()) {
                customerList.get(i).setName(customer.getName());
                customerList.get(i).setDob(customer.getDob());
                customerList.get(i).setAddress(customer.getAddress());
                System.out.println("Cập nhật khách hàng thành công: " + customerList.get(i));
                return true;
            }
        }
        System.out.println("Không tìm thấy khách hàng với ID: " + customer.getId());
        return false;
    }

    @Override
    public Customer getCustomerByID(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
