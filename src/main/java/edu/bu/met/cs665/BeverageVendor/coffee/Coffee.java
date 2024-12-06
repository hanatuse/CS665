package edu.bu.met.cs665.BeverageVendor.coffee;

import edu.bu.met.cs665.BeverageVendor.BeverageBase;
import edu.bu.met.cs665.BeverageVendor.Size;

public abstract class Coffee extends BeverageBase {
    protected Coffee(Size size, String baseBeverage) {
        super(size, baseBeverage);
    }
}
