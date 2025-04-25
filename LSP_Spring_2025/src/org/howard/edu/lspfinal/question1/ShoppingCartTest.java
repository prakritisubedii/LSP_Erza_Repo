package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    @DisplayName("Test for adding a valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 999.99);
        assertEquals(999.99, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for adding an item with zero price (expect exception)")
    public void testAddItemZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("FreeItem", 0.0);
        });
    }

    @Test
    @DisplayName("Test for adding an item with negative price (expect exception)")
    public void testAddItemNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("NegativeItem", -50.0);
        });
    }

    @Test
    @DisplayName("Test for adding an item with empty name (expect exception)")
    public void testAddItemWithEmptyName() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("", 20.0);
        });
    }

    @Test
    @DisplayName("Test for applying 'SAVE10' discount code")
    public void testApplyDiscountSave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying 'SAVE20' discount code")
    public void testApplyDiscountSave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying invalid discount code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 50.0);
        cart.addItem("Pen", 2.0);
        assertEquals(52.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Bag", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test for removing an existing item")
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Mouse", 25.0);
        assertTrue(cart.removeItem("Mouse"));
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test for removing a non-existent item")
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Keyboard", 45.0);
        assertFalse(cart.removeItem("Monitor"));
    }

    @Test
    @DisplayName("Test cart size updates correctly after add/remove")
    public void testCartSizeUpdatesCorrectly() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Phone", 600.0);
        cart.addItem("Case", 20.0);
        assertEquals(2, cart.getCartSize());

        cart.removeItem("Phone");
        assertEquals(1, cart.getCartSize());
    }
}
