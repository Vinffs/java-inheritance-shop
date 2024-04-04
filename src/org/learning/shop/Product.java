package org.learning.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {

    private final double vat = 0.23;
    // ATTRIBUTES
    private int code;
    private String name, brand;
    private BigDecimal price;

    // CONSTRUCTORS

    public Product(String name, String brand, double price) {
        this.code = generateCode();
        this.name = name;
        this.brand = brand;
        this.price = correctPrice(price);
    }


    // METHODS

    // Add a method for calculating discounted price
    public BigDecimal getDiscountedPrice(boolean hasLoyaltyCard) {
        BigDecimal discountPercentage;
        BigDecimal grossPrice = getGrossPrice();
        if (hasLoyaltyCard) {
            discountPercentage = BigDecimal.valueOf(0.02);
            if (this instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) this;
                if (smartphone.getStorage() < 32)
                    discountPercentage = BigDecimal.valueOf(0.05);
            } else if (this instanceof Television) {
                Television television = (Television) this;
                if (!television.isSmart())
                    discountPercentage = BigDecimal.valueOf(0.10);
            } else if (this instanceof Headphone) {
                Headphone headphone = (Headphone) this;
                if (!headphone.isWireless()) {
                    discountPercentage = BigDecimal.valueOf(0.07);
                }
            }
            BigDecimal discount = grossPrice.multiply(discountPercentage);
            return grossPrice.subtract(discount).setScale(2, RoundingMode.HALF_UP);
        } else {
            return grossPrice;
        }

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
