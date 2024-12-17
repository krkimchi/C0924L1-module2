package bai_tap_lam_them.models;

public class Car extends Vehicle {
    private int seats;
    private String type;

    public Car(String licensePlate, String manufacturer, int year, String owner, int seats, String type) {
        super(licensePlate, manufacturer, year, owner);
        this.seats = seats;
        this.type = type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Ôtô [Biển số: " + getLicensePlate() +
                ", Hãng: " + getManufacturer() +
                ", Năm: " + getYear() +
                ", Chủ sở hữu: " + getOwner() +
                ", Số chỗ: " + seats +
                ", Kiểu xe: " + type + "]");
    }
}
