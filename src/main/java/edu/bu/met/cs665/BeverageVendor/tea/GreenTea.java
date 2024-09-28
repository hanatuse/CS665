package edu.bu.met.cs665.BeverageVendor.tea;
import edu.bu.met.cs665.BeverageVendor.Size;

public class GreenTea extends Tea {
    public GreenTea(Size size) {
        super(size);
    }


    @Override
    public String getBaseBeverage() {
        return "GreenTea";  // Return specific beverage name
    }
}
