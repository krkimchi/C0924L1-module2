package ss16_io_text_file.bai_tap.mvc.view;

import ss16_io_text_file.bai_tap.mvc.controller.CustomerController;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        controller.showMenu();
    }
}
