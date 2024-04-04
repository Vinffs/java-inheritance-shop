package org.learning.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Headphone extends Product {

    private String color;
    private boolean isWireless;

    public Headphone(String name, String brand, double price, String color, boolean isWireless, boolean loyaltyCard) {
        super(name, brand, price, loyaltyCard);
        this.color = color;
        this.isWireless = isWireless;
    }

    @Override
    public BigDecimal getDiscountedPrice(boolean loyaltyCard) {
        BigDecimal grossPrice = getGrossPrice();
        if (loyaltyCard && !isWireless()) {
            discountPercentage = BigDecimal.valueOf(0.07);
        }
        BigDecimal discount = grossPrice.multiply(discountPercentage);
        return grossPrice.subtract(discount).setScale(2, RoundingMode.HALF_UP);
    }

    // GETTERS
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // SETTERS

    public boolean isWireless() {
        return isWireless;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nGross Price: %s\nColor: %s\nWireless: %s", getCode(), getName(), getBrand(), getPrice(), getVat(), getGrossPrice(), color, isWireless);
    }

}
