package edu.bu.met.cs665.BeverageVendor.tea;

import java.util.List;
import java.util.Map;

import edu.bu.met.cs665.BeverageVendor.Beverage;
import edu.bu.met.cs665.BeverageVendor.Condiment;
import edu.bu.met.cs665.BeverageVendor.Size;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Tea implements Beverage {
    protected Size size;
    protected String baseBeverage = "Tea";
    protected List<Condiment> otherCondiments = new ArrayList<>();
    // Implement the limit of 3 units
    private Map<Condiment, Integer> condimentCounts = new HashMap<>();

    public Tea(Size size) {
        this.size = size;
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
            condimentCounts.put(condiment, condimentCounts.getOrDefault(condiment, 0) + 1);
        } else {
            throw new IllegalArgumentException("Cannot add more than 3 units of " + condiment);
        }
    }

    @Override
    public boolean canAddCondiment(Condiment condiment) {
        return condimentCounts.getOrDefault(condiment, 0) < 3;
    }

    @Override
    public double getCost() {
        double basePrice = 3.5; // Base price for tea
        double cost = basePrice + size.getExtraCost(); 
        
        // Calculate total condiment cost
        for (Map.Entry<Condiment, Integer> entry : condimentCounts.entrySet()) {
        Condiment condiment = entry.getKey();
        int units = entry.getValue();

        cost += condiment.getExtraCost() * units;
        }
        return cost;
    }

    @Override
    public String toString() {
        return size + " " + getBaseBeverage() + " with " + otherCondiments.toString();
    }
}
