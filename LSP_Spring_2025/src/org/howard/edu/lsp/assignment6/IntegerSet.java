package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * This class represents a set of unique integers.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor initializing an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Constructor initializing the set with given values, ensuring uniqueness.
     * @param set an ArrayList of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(new HashSet<>(set));
    }

    /**
     * Clears the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if the set contains a given value.
     * @param value the integer to check
     * @return true if the value is present, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * @return the largest integer
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     * @return the smallest integer
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if not already present.
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if present.
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union operation with another set.
     * @param intSetb the other IntegerSet
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
    }

    /**
     * Performs the intersection operation with another set.
     * @param intSetb the other IntegerSet
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs the set difference operation (this set - intSetb).
     * @param intSetb the other IntegerSet
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs the complement operation (all elements in intSetb that are not in this set).
     * @param intSetb the universal set
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(this.set);
        this.set = complementSet;
    }

    /**
     * Checks if the set is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Checks if two sets are equal.
     * @param o another Object
     * @return true if sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /**
     * Returns a string representation of the set.
     * @return a string listing the set elements
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
