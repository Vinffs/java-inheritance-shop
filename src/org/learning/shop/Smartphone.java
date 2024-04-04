package org.learning.shop;

public class Smartphone extends Product {

    private String imei;
    private int storage;

    public Smartphone(String name, String brand, double price, String imei, int storage) {
        super(name, brand, price);
        this.imei = imei;
        this.storage = storage;
    }

    // GETTERS
    public String getImei() {
        return imei;
    }

    // SETTERS
    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nGross Price: %s\nIMEI: %s\nStorage: %s", getCode(), getName(), getBrand(), getPrice(), getVat(), getGrossPrice(), imei, storage);
    }

}
