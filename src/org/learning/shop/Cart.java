package org.learning.shop;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    boolean flag = false;
    int size = 0;
    Product[] cart = null;
    while(!flag) {
        try {
            System.out.print("Please tell us how many products would you like to add to cart: ");
            size = Integer.parseInt(scan.nextLine());
            flag = true;
        } catch (NumberFormatException e) {
            System.out.println("Error " + e.getMessage());
            System.out.println("invalid input, please insert a number!");
        } finally {
            cart = new Product[size];
        }
    }

        for (int i = 0; i < cart.length ; i++) {
            System.out.println("----------------------");
            System.out.println();

            System.out.println("Product Number: " + (i + 1));

            int product = 0;
            try {
                System.out.println("Please Choose the type of product: \n"+
                        "1. Smartphone \n" +
                        "2. Television \n" +
                        "3. Headphone \n");
                System.out.print("Tell us your choice: ");
                product = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Invalid choice, please select a product by index.");
                i--;
            } finally {
                System.out.print("Name: ");
                String name = scan.nextLine();

                System.out.print("Brand: ");
                String brand = scan.nextLine();

                System.out.print("Price: ");
                double price = Double.parseDouble(scan.nextLine().replaceAll(",", "."));


                switch (product) {
                    case 1:
                        System.out.print("imei: ");
                        String imei = scan.nextLine();

                        System.out.print("Storage (GB): ");
                        int storage = Integer.parseInt(scan.nextLine());

                        Smarthphone smarthphone = new Smarthphone(name, brand, price, imei, storage);
                        cart[i] = smarthphone;
                        break;

                    case 2:
                        System.out.print("inches: ");
                        int inches = Integer.parseInt(scan.nextLine());

                        System.out.print("Is it Smart? Y/N ");
                        boolean isSmart = Objects.equals(scan.nextLine(), "Y");

                        Television television = new Television(name, brand, price, inches, isSmart);
                        cart[i] = television;
                        break;

                    case 3:
                        System.out.print("color: ");
                        String color = scan.nextLine();

                        System.out.print("Is it Wireless? Y/N ");
                        boolean isWireless = Objects.equals(scan.nextLine(), "Y");

                        Headphone headphone = new Headphone(name, brand, price, color, isWireless);

                        cart[i] = headphone;
                        break;

                }
            }

        }

        BigDecimal totalCartSum = BigDecimal.ZERO;
        for (int i = 0; i < cart.length; i++) {
            System.out.println("Product " + (i+1) + ":\n" + cart[i].toString());
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
            BigDecimal price = cart[i].getGrossPrice();
            totalCartSum = totalCartSum.add(price);
        }

        System.out.println("Total Cart (VAT included) : " + totalCartSum + " €");






        scan.close();
    }
}

