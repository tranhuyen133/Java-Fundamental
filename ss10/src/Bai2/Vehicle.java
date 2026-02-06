package Bai2;

public abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();

    public String getBrand() {
        return brand;
    }
}

