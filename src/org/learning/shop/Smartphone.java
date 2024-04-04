package org.learning.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphone extends Product {

    private String imei;
    private int storage;

    public Smartphone(String name, String brand, double price, String imei, int storage, boolean loyaltyCard) {
        super(name, brand, price, loyaltyCard);
        this.imei = imei;
        this.storage = storage;
    }

    @Override
    public BigDecimal getDiscountedPrice(boolean loyaltyCard) {
        BigDecimal grossPrice = getGrossPrice();
        if (loyaltyCard && getStorage() < 32) {
            discountPercentage = BigDecimal.valueOf(0.05);
        }
        BigDecimal discount = grossPrice.multiply(discountPercentage);
        return grossPrice.subtract(discount).setScale(2, RoundingMode.HALF_UP);
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
