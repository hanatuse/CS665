package edu.bu.met.cs665.BeverageVendor;

public enum Size {
    SMALL(0.0), MEDIUM(0.1), LARGE(0.2);

    private final double extraCost;

    Size(double extraCost) {
        this.extraCost = extraCost;
    }

    public double getExtraCost() {
        return extraCost;
    }
}
