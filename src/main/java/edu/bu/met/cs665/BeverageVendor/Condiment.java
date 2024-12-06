package edu.bu.met.cs665.BeverageVendor;

// Class to represent a Condiment with its type and cost
public class Condiment {
    private final CondimentType type;
    private final double extraCost;

    private Condiment(CondimentType type, double extraCost) {
        this.type = type;
        this.extraCost = extraCost;
    }

    public CondimentType getType() {
        return type;
    }

    public double getExtraCost() {
        return extraCost;
    }

    // Static factory method to create condiments
    public static Condiment createCondiment(CondimentType type) {
        switch (type) {
            case MILK:
                return new Condiment(type, 0.5);
            case CREAM:
                return new Condiment(type, 0.5);
            case SUGAR:
                return new Condiment(type, 0.2);
            default:
                throw new IllegalArgumentException("Unknown condiment type: " + type);
        }
    }
}
