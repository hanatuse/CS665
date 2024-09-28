package edu.bu.met.cs665.BeverageVendor.vendor;

import edu.bu.met.cs665.BeverageVendor.Beverage;

// Factory method
public interface BeverageVendor {
    Beverage createBeverage(String name, String size, String[] condiments);
}
