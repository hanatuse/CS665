package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import edu.bu.met.cs665.BeverageVendor.Beverage;
import edu.bu.met.cs665.BeverageVendor.vendor.BeverageFactory;
import edu.bu.met.cs665.BeverageVendor.vendor.BeverageService;
import edu.bu.met.cs665.BeverageVendor.vendor.CoffeeVendor;
import edu.bu.met.cs665.BeverageVendor.vendor.TeaVendor;

/**
 * Unit tests for Beverage Vendor App.
 */
public class TestBeverageVendor {

    public TestBeverageVendor() {
    }

    // Test creating a coffee with condiments
    @Test
    public void testCreateCoffeeWithCondiments() {
        // Given: a coffee object
        BeverageFactory coffeeVendor = new CoffeeVendor();
        BeverageService coffeeService = (BeverageService) coffeeVendor;

        // When: add condiments within limit
        String[] condiments = { "SUGAR", "MILK" }; // 1 unit of sugar and 1 unit of milk
        Beverage espresso = coffeeVendor.createBeverage("Espresso", "medium", condiments);

        // Then: Check the beverage type and condiments
        assertEquals("Espresso", espresso.getBaseBeverage());
        assertEquals(2, espresso.getOtherCondiments().size());

        // Then: Check the total cost (base price $4.0 + $0.1 for medium size + $0.2 for
        // sugar + $0.5 for milk)
        assertEquals(4.8, coffeeService.getCost(espresso), 0.01);
    }

    // Test creating a tea and calculating its cost
    @Test
    public void testCreateTeaWithCondiments() {
        // Given: a tea object
        BeverageFactory teaVendor = new TeaVendor();
        BeverageService teaService = (BeverageService) teaVendor;

        // When: add condiments within limit
        String[] condiments = { "CREAM", "SUGAR" }; // 1 unit of cream and 1 unit of sugar
        Beverage blackTea = teaVendor.createBeverage("BlackTea", "large", condiments);

        // Then: Check the beverage type and condiments
        assertEquals("BlackTea", blackTea.getBaseBeverage());
        assertEquals(2, blackTea.getOtherCondiments().size());

        // Then: Check the total cost (base price $3.5 + $0.2 for large size + $0.5 for
        // cream + $0.2 for sugar)
        assertEquals(4.4, teaService.getCost(blackTea), 0.01);
    }

    // Test adding condiments beyond the allowed limit (more than 3 units)
    @Test
    public void testCondimentLimitExceeded() {
        // Given: a coffee object
        BeverageFactory coffeeVendor = new CoffeeVendor();

        // When: add condiments beyond the allowed limit
        String[] condiments = { "SUGAR", "SUGAR", "SUGAR", "SUGAR" }; // 4 units of sugar

        // Then: Expect an IllegalArgumentException to be thrown when exceeding the
        // condiment limit
        assertThrows(IllegalArgumentException.class, () -> {
            coffeeVendor.createBeverage("Americano", "medium", condiments);
        });
    }

    // Test the behavior when adding exactly 3 units of a condiment
    @Test
    public void testMaxCondimentLimit() {
        // Given: a coffee object
        BeverageFactory coffeeVendor = new CoffeeVendor();
        BeverageService coffeeService = (BeverageService) coffeeVendor;

        // When: add exactly 3 units of a condiment
        String[] condiments = { "SUGAR", "SUGAR", "SUGAR" }; // 3 units of sugar
        Beverage espresso = coffeeVendor.createBeverage("Espresso", "small", condiments);

        // Then: Check the beverage type and condiments
        assertEquals("Espresso", espresso.getBaseBeverage());
        assertEquals(3, espresso.getOtherCondiments().size());

        // Then: Check the total cost (base price $4.0 + 3 * $0.2 for sugar)
        assertEquals(4.6, coffeeService.getCost(espresso), 0.01);
    }

    // Test creating a tea without any condiments
    @Test
    public void testCreateTeaWithoutCondiments() {
        // Given: a tea object
        BeverageFactory teaVendor = new TeaVendor();
        BeverageService teaService = (BeverageService) teaVendor;

        // When: add no condiments
        String[] noCondiments = {}; // No condiments
        Beverage greenTea = teaVendor.createBeverage("GreenTea", "small", noCondiments);

        // Then: Check the beverage type and condiments
        assertEquals("GreenTea", greenTea.getBaseBeverage());
        assertEquals(0, greenTea.getOtherCondiments().size());

        // Then: Check the total cost (base price $3.5)
        assertEquals(3.5, teaService.getCost(greenTea), 0.01);
    }
}
