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


    }
}

