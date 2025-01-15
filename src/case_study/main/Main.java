package case_study.main;

import case_study.controllers.VehicleController;
import case_study.views.VehicleView;

public class Main {
    public static void main(String[] args) {
        VehicleView view = new VehicleView();
        VehicleController controller = new VehicleController(view);

        controller.start();
    }
}
