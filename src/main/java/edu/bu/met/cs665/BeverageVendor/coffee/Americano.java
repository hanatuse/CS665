package edu.bu.met.cs665.BeverageVendor.coffee;
import edu.bu.met.cs665.BeverageVendor.Size;

public class Americano extends Coffee {
        public Americano(Size size) {
        super(size);
    }
    
    @Override
    public String getBaseBeverage() {
        return "Americano";
    }
}
