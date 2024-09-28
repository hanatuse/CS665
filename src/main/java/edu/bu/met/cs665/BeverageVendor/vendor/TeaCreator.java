package edu.bu.met.cs665.BeverageVendor.vendor;

import edu.bu.met.cs665.BeverageVendor.Beverage;
import edu.bu.met.cs665.BeverageVendor.Condiment;
import edu.bu.met.cs665.BeverageVendor.Size;
import edu.bu.met.cs665.BeverageVendor.tea.BlackTea;
import edu.bu.met.cs665.BeverageVendor.tea.GreenTea;
import edu.bu.met.cs665.BeverageVendor.tea.Tea;
import edu.bu.met.cs665.BeverageVendor.tea.YellowTea;

// Concrete factory
public class TeaCreator implements BeverageVendor {
    @Override
    public Beverage createBeverage(String name, String size, String[] condiments) {
        Tea tea = null;
        Size beverageSize = Size.valueOf(size.toUpperCase());

        // Create coffee based on the type
        switch (name.toLowerCase()) {
            case "blacktea":
                tea = new BlackTea(beverageSize);
                break;
            case "greentea":
                tea = new GreenTea(beverageSize);
                break;
            case "yellowtea":
                tea = new YellowTea(beverageSize);
                break;
            default:
                throw new IllegalArgumentException("Unknown tea type: " + name);
        }

        // Add condiments
        for (String condiment : condiments) {
            tea.addOtherCondiments(Condiment.valueOf(condiment.toUpperCase()));
        }

        return tea;
    }
}
