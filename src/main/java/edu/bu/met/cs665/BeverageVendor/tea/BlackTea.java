package edu.bu.met.cs665.BeverageVendor.tea;
import edu.bu.met.cs665.BeverageVendor.Size;

public class BlackTea extends Tea {
    public BlackTea(Size size) {
        super(size);
    }

    
    @Override
    public String getBaseBeverage() {
        return "BlackTea";  // Return specific beverage name
    }
}
