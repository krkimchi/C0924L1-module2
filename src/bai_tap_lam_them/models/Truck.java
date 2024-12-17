package bai_tap_lam_them.models;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String licensePlate, String manufacturer, int year, String owner, double loadCapacity) {
        super(licensePlate, manufacturer, year, owner);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Xe tải [Biển số: " + getLicensePlate() +
                ", Hãng: " + getManufacturer() +
                ", Năm: " + getYear() +
                ", Tải trọng: " + loadCapacity + " tấn]");
    }
}
