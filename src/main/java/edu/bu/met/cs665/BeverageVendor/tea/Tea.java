package edu.bu.met.cs665.BeverageVendor.tea;

import edu.bu.met.cs665.BeverageVendor.BeverageBase;
import edu.bu.met.cs665.BeverageVendor.Size;

public abstract class Tea extends BeverageBase {
    protected Tea(Size size, String baseBeverage) {
        super(size, baseBeverage);
    }
}
