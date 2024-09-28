package edu.bu.met.cs665.BeverageVendor;

import java.util.List;

public interface Beverage {
    Size getSize();
    String getBaseBeverage();
    List<Condiment> getOtherCondiments();
    void addOtherCondiments(Condiment condiment);
    double getCost();
    String toString();

    // Check condiment limits, no more than 3 units
    boolean canAddCondiment(Condiment condiment);
}
