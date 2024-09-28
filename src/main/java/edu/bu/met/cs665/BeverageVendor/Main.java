/**
 * Name: Yingtong Zhou
 * Course: CS-665 Software Designs & Patterns
 * Date: 09/21/2024
 * File Name: Main.java
 * Description: The entry point of the beverage vendor app.
 */

package edu.bu.met.cs665.BeverageVendor;

import edu.bu.met.cs665.BeverageVendor.vendor.BeverageVendor;
import edu.bu.met.cs665.BeverageVendor.vendor.CoffeeCreator;
import edu.bu.met.cs665.BeverageVendor.vendor.TeaCreator;

/**
 * Menu class is to create Beverage objects and Condiment objects.
 */
public class Main {
    public static void main(String[] args) {
        // Create coffee using the CoffeeCreator
        BeverageVendor coffeeVendor = new CoffeeCreator();
        String[] condimentsCoffee = {"SUGAR", "MILK"};
        try {
            Beverage coffee = coffeeVendor.createBeverage("Espresso", "medium", condimentsCoffee);
            System.out.println("Coffee: " + coffee);
            System.out.println("Cost: $" + coffee.getCost());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); 
        }
        
        // Create tea using the TeaCreator
        BeverageVendor teaVendor = new TeaCreator();
        String[] condimentsTea = {"CREAM", "SUGAR"};
        try {Beverage tea = teaVendor.createBeverage("BlackTea", "large", condimentsTea);
        System.out.println("Tea: " + tea);
        System.out.println("Cost: $" + tea.getCost());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); 
        }
    }
    
}
