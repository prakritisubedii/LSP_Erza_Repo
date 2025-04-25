package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding and removing items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     * 
     * @param itemName  the name of the item
     * @param price     the price of the item (must be > 0)
     * @throws IllegalArgumentException if name is empty or price <= 0
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the cart.
     * 
     * @param itemName the name of the item to remove
     * @return true if item was removed, false if not found
     */
    public boolean removeItem(String itemName) {
        return items.remove(itemName) != null;
    }

    /**
     * Returns the number of items in the cart.
     * 
     * @return the cart size
     */
    public int getCartSize() {
        return items.size();
    }

    /**
     * Calculates the total cost after applying discounts.
     * 
     * @return the total cost
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code.
     * 
     * @param code the discount code
     * @throws IllegalArgumentException if code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage.
     * 
     * @return discount percentage
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
