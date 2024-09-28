package edu.bu.met.cs665.BeverageVendor.tea;
import edu.bu.met.cs665.BeverageVendor.Size;

public class YellowTea extends Tea {
    public YellowTea(Size size) {
        super(size);
    }


    @Override
    public String getBaseBeverage() {
        return "YellowTea";  // Return specific beverage name
    }
}
