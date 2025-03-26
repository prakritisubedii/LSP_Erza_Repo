package org.howard.edu.lsp.assignment5;

/**
 * Driver class to test IntegerSet implementation.
 */
public class Driver {
    /**
     * Main method to execute tests on IntegerSet class.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Value of Set1: " + set1);
        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Value of Set2: " + set2);
        System.out.println("Union of Set1 and Set2");
        set1.union(set2);
        System.out.println("Result of union: " + set1);
    }
}
