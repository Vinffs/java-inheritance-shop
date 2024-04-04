package org.learning.shop;

import java.util.Arrays;
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
            }

        }


    }
}

