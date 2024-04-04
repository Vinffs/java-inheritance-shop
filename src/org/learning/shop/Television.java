package org.learning.shop;

public class Television extends Product{
    private int inches;
    private boolean isSmart;
    public Television(String name, String brand, double price, int inches, boolean isSmart) {
        super(name, brand, price);
        this.inches = inches;
        this.isSmart = isSmart;
    }


    // GETTERS
    public int getInches() {
        return inches;
    }


    public boolean isSmart() {
        return isSmart;
    }

    // SETTERS

    public void setInches(int inches) {
        this.inches = inches;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nName: %s\nBrand: %s\nPrice: %s\nVAT: %s\nGross Price: %s\nInches: %s\nSmart: %s",
                getCode(), getName(), getBrand(), getPrice(), getVat(), getGrossPrice(), inches, isSmart);
    }

}
