package edu.bu.met.cs665.BeverageVendor;

import java.util.ArrayList;
import java.util.List;

public abstract class BeverageBase implements Beverage {
    private final Size size;
    private final String baseBeverage;
    private final List<Condiment> otherCondiments;

    protected BeverageBase(Size size, String baseBeverage) {
        this.size = size;
        this.baseBeverage = baseBeverage;
        this.otherCondiments = new ArrayList<>();
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String getBaseBeverage() {
        return baseBeverage;
    }

    @Override
    public List<Condiment> getOtherCondiments() {
        return otherCondiments;
    }

    @Override
    public void addOtherCondiments(Condiment condiment) {
        if (canAddCondiment(condiment)) {
            otherCondiments.add(condiment);
        } else {
            throw new IllegalStateException("Cannot add more condiments: Limit is 3 units.");
        }
    }

    @Override
    public boolean canAddCondiment(Condiment condiment) {
        return otherCondiments.size() < 3;
    }

    @Override
    public double getCost() {
        double totalCost = size.getBaseCost();
        for (Condiment condiment : otherCondiments) {
            totalCost += condiment.getExtraCost();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder recipe = new StringBuilder(baseBeverage + " (" + size + ")");
        if (!otherCondiments.isEmpty()) {
            recipe.append(" with ");
            otherCondiments.forEach(condiment -> recipe.append(condiment.getType()).append(", "));
            recipe.setLength(recipe.length() - 2); // Remove trailing comma and space
        }
        return recipe.toString();
    }
}
