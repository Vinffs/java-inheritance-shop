package org.learning.shop;

public class Headphone extends Product{

    private String color;
    private boolean isWireless;
    public Headphone(String name, String brand, double price, String color, boolean isWireless) {
        super(name, brand, price);
        this.color = color;
        this.isWireless = isWireless;
    }

    // GETTERS
    public String getColor() {
        return this.color;
    }

    public boolean isWireless() {
        return isWireless;
    }

    // SETTERS

    public void setColor(String color) {
        this.color = color;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nGross Price: %s\nColor: %s\nWireless: %s",
                getCode(), getName(), getBrand(), getPrice(), getVat(), getGrossPrice(), color, isWireless);
    }

}
