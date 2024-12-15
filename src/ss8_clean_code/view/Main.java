package ss8_clean_code.view;

import ss8_clean_code.controller.CustomerController;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        controller.showMenu();
    }
}
