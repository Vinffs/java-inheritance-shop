package org.learning.shop;

public class Smarthphone extends Product{

    private String imei;
    private int storage;
    public Smarthphone(String name, String brand, double price, String imei, int storage) {
        super(name, brand, price);
        this.imei = imei;
        this.storage = storage;
    }

    // GETTERS
    public String getImei() {
        return imei;
    }
    public int getStorage() {
        return storage;
    }

    // SETTERS
    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s", getCode(), getName(), getBrand(), getPrice(), getVat(),
         getGrossPrice(), imei, storage);
    }
}
