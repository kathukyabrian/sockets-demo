package tech.kitucode;

import java.io.Serializable;

public class Car implements Serializable {
    private String brand;

    private String engineSizeInCC;

    private Integer yearOfManufacture;

    public Car(String brand, String engineSizeInCC, Integer yearOfManufacture) {
        this.brand = brand;
        this.engineSizeInCC = engineSizeInCC;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngineSizeInCC() {
        return engineSizeInCC;
    }

    public void setEngineSizeInCC(String engineSizeInCC) {
        this.engineSizeInCC = engineSizeInCC;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", engineSizeInCC='" + engineSizeInCC + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                '}';
    }
}
