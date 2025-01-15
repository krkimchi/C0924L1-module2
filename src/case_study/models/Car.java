package case_study.models;

public class Car extends Vehicle {
    private String carType;
    private int seats;

    public Car(String licensePlate, String manufacturer, int productionYear, String owner, String carType, int seats) {
        super(licensePlate, manufacturer, productionYear, owner);
        this.carType = carType;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return getLicensePlate() + "," +
                getManufacturer() + "," +
                getProductionYear() + "," +
                getOwner() + "," +
                carType + "," +
                seats;
    }
}
