package org.learning.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Television extends Product {
    private int inches;
    private boolean isSmart;

    public Television(String name, String brand, double price, int inches, boolean isSmart, boolean loyaltyCard) {
        super(name, brand, price, loyaltyCard);
        this.inches = inches;
        this.isSmart = isSmart;
    }


    // GETTERS

    @Override
    public BigDecimal getDiscountedPrice(boolean loyaltyCard) {
        BigDecimal grossPrice = getGrossPrice();
        if (loyaltyCard && !isSmart()) {
            discountPercentage = BigDecimal.valueOf(0.10);
        }
        BigDecimal discount = grossPrice.multiply(discountPercentage);
        return grossPrice.subtract(discount).setScale(2, RoundingMode.HALF_UP);
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public boolean isSmart() {
        return isSmart;
    }

    // SETTERS


    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nGross Price: %s\nInches: %s\nSmart: %s", getCode(), getName(), getBrand(), getPrice(), getVat(), getGrossPrice(), inches, isSmart);
    }

}
