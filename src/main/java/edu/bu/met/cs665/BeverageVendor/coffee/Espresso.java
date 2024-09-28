package edu.bu.met.cs665.BeverageVendor.coffee;
import edu.bu.met.cs665.BeverageVendor.Size;

public class Espresso extends Coffee {
        public Espresso(Size size) {
        super(size);
    }

    @Override
    public String getBaseBeverage() {
        return "Espresso";  // Return the specific beverage type
    }
}
