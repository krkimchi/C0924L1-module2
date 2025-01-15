package case_study.models;

public abstract class Vehicle {
    private String licensePlate;
    private String manufacturer;
    private int productionYear;
    private String owner;

    public Vehicle(String licensePlate, String manufacturer, int productionYear, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return licensePlate + "," + manufacturer + "," + productionYear + "," + owner;
    }
}
