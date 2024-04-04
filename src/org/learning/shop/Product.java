package org.learning.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {

    private final double vat = 0.23;
    public BigDecimal discountPercentage = BigDecimal.ZERO;
    // ATTRIBUTES
    private int code;
    private String name, brand;
    private BigDecimal price;

    // CONSTRUCTORS

    public Product(String name, String brand, double price, boolean loyaltyCard) {
        this.code = generateCode();
        this.name = name;
        this.brand = brand;
        this.price = correctPrice(price);

        if (loyaltyCard) {
            this.discountPercentage = BigDecimal.valueOf(0.02);
        }

    }


    // METHODS

    public BigDecimal getDiscountedPrice(boolean loyaltyCard) {
        BigDecimal grossPrice = getGrossPrice();
        BigDecimal discount = grossPrice.multiply(discountPercentage);
        return grossPrice.subtract(discount).setScale(2, RoundingMode.HALF_UP);

    }


    private int generateCode() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(99_999_999);
    }

    private BigDecimal correctPrice(double price) {
        return new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
    }

    // GETTERS

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getGrossPrice() {
        BigDecimal vat = new BigDecimal(this.vat);
        BigDecimal gross = this.price.add(this.price.multiply(vat));

        return gross.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nGross Price: %s", code, name, brand, price, vat, getGrossPrice());
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // SETTERS

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getVat() {
        return this.vat;
    }
}
