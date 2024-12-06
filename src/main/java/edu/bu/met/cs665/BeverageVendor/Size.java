package edu.bu.met.cs665.BeverageVendor;

public enum Size {
    SMALL(2.0, 0.0), // Base cost for SMALL is 2.0, no extra cost
    MEDIUM(2.5, 0.1), // Base cost for MEDIUM is 2.5, extra cost is 0.1
    LARGE(3.0, 0.2); // Base cost for LARGE is 3.0, extra cost is 0.2

    private final double baseCost; // Base price of the beverage
    private final double extraCost; // Additional cost for the size

    Size(double baseCost, double extraCost) {
        this.baseCost = baseCost;
        this.extraCost = extraCost;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getExtraCost() {
        return extraCost;
    }
}
