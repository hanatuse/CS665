package edu.bu.met.cs665.BeverageVendor;

public enum Condiment {
    MILK(0.5), CREAM(0.5), SUGAR(0.2);

    private final double extraCost;

    Condiment(double extraCost) {
        this.extraCost = extraCost;
    }

    public double getExtraCost() {
        return extraCost;
    }
}
