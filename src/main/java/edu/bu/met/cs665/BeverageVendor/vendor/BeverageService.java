package edu.bu.met.cs665.BeverageVendor.vendor;

import edu.bu.met.cs665.BeverageVendor.Beverage;

// Service interface responsible for beverage operations
public interface BeverageService {
    double getCost(Beverage beverage);

    String getRecipe(Beverage beverage);
}
