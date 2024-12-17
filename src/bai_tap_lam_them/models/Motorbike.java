package bai_tap_lam_them.models;

public class Motorbike extends Vehicle {
    private int power;

    public Motorbike(String licensePlate, String manufacturer, int year, String owner, int power) {
        super(licensePlate, manufacturer, year, owner);
        this.power = power;
    }

    @Override
    public void displayInfo() {
        System.out.println("Xe máy [Biển số: " + getLicensePlate() +
                ", Hãng: " + getManufacturer() +
                ", Công suất: " + power + " HP]");
    }
}
