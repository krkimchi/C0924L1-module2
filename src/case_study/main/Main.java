package case_study.main;

import case_study.controllers.VehicleController;
import case_study.services.VehicleService;
import case_study.views.VehicleView;

public class Main {
    public static void main(String[] args) {
        VehicleView view = new VehicleView();
        VehicleService service = new VehicleService();
        VehicleController controller = new VehicleController(view, service);

        controller.start();
    }
}
