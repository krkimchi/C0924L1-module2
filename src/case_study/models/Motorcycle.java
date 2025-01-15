package case_study.models;

public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String licensePlate, String manufacturer, int productionYear, String owner, int engineCapacity) {
        super(licensePlate, manufacturer, productionYear, owner);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return getLicensePlate() + "," +
                getManufacturer() + "," +
                getProductionYear() + "," +
                getOwner() + "," +
                engineCapacity;
    }
}
