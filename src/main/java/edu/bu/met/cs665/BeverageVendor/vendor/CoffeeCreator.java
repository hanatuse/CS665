package edu.bu.met.cs665.BeverageVendor.vendor;

import edu.bu.met.cs665.BeverageVendor.Beverage;
import edu.bu.met.cs665.BeverageVendor.Condiment;
import edu.bu.met.cs665.BeverageVendor.Size;
import edu.bu.met.cs665.BeverageVendor.coffee.Americano;
import edu.bu.met.cs665.BeverageVendor.coffee.Coffee;
import edu.bu.met.cs665.BeverageVendor.coffee.Espresso;
import edu.bu.met.cs665.BeverageVendor.coffee.LatteMacchiato;

// Concrete factory
public class CoffeeCreator implements BeverageVendor {
    @Override
    public Beverage createBeverage(String name, String size, String[] condiments) {
        Coffee coffee = null;
        Size beverageSize = Size.valueOf(size.toUpperCase());

        // Create coffee based on the type
        switch (name.toLowerCase()) {
            case "espresso":
                coffee = new Espresso(beverageSize);
                break;
            case "americano":
                coffee = new Americano(beverageSize);
                break;
            case "lattemacchiato":
                coffee = new LatteMacchiato(beverageSize);
                break;
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + name);
        }

        // Add condiments
        for (String condiment : condiments) {
            coffee.addOtherCondiments(Condiment.valueOf(condiment.toUpperCase()));
        }

        return coffee;
    }
}
