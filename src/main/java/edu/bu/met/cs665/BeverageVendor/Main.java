/**
 * Name: Yingtong Zhou
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/06/2024
 * File Name: Main.java
 * Description: The entry point of the beverage vendor app.
 */

package edu.bu.met.cs665.BeverageVendor;

import edu.bu.met.cs665.BeverageVendor.vendor.BeverageFactory;
import edu.bu.met.cs665.BeverageVendor.vendor.BeverageService;
import edu.bu.met.cs665.BeverageVendor.vendor.CoffeeVendor;
import edu.bu.met.cs665.BeverageVendor.vendor.TeaVendor;

/**
 * Menu class is to create Beverage objects and Condiment objects.
 */
public class Main {
    public static void main(String[] args) {
        // Create coffee using the CoffeeVendor
        BeverageFactory coffeeVendor = new CoffeeVendor();
        BeverageService coffeeService = (BeverageService) coffeeVendor; // Downcast to access service methods
        String[] condimentsCoffee = { "SUGAR", "MILK" };
        try {
            Beverage coffee = coffeeVendor.createBeverage("Espresso", "medium", condimentsCoffee);
            System.out.println("Coffee: " + coffeeService.getRecipe(coffee));
            System.out.println("Cost: $" + coffeeService.getCost(coffee));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Create tea using the TeaVendor
        BeverageFactory teaVendor = new TeaVendor();
        BeverageService teaService = (BeverageService) teaVendor; // Downcast to access service methods
        String[] condimentsTea = { "CREAM", "SUGAR" };
        try {
            Beverage tea = teaVendor.createBeverage("BlackTea", "large", condimentsTea);
            System.out.println("Tea: " + teaService.getRecipe(tea));
            System.out.println("Cost: $" + teaService.getCost(tea));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
