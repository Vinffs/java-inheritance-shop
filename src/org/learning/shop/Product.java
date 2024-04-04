package org.learning.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {

    // ATTRIBUTES
    private int code;
    private String name, brand;
    private BigDecimal price;
    private final double vat = 0.23;

    // CONSTRUCTORS

    public Product(String name, String brand, double price) {
        this.code = generateCode();
        this.name = name;
        this.brand = brand;
        this.price = correctPrice(price);
    }


    // METHODS

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

    public BigDecimal getGrossPrice() {
        BigDecimal vat = new BigDecimal(this.vat);
        BigDecimal gross = this.price.add(this.price.multiply(vat));

        return gross.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s", code, name, brand, price, vat);
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public double getVat() {
        return this.vat;
    }

    // SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
