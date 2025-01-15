package case_study.models;

public class Truck extends Vehicle {
    private double payload;

    public Truck(String licensePlate, String manufacturer, int productionYear, String owner, double payload) {
        super(licensePlate, manufacturer, productionYear, owner);
        this.payload = payload;
    }

    @Override
    public String toString() {
        return getLicensePlate() + "," +
                getManufacturer() + "," +
                getProductionYear() + "," +
                getOwner() + "," +
                payload;
    }
}
