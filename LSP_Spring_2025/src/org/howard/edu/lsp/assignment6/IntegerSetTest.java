package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {

    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty(), "The set should be empty after clearing");
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertEquals(2, set.length(), "The length should be 2");
    }

    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2), "The sets should be equal");
    }

    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertTrue(set.contains(1), "The set should contain 1");
        assertFalse(set.contains(2), "The set should not contain 2");
    }

    @Test
    @DisplayName("Test case for largest() with non-empty set")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(5);
        set.add(3);
        assertEquals(5, set.largest(), "The largest element should be 5");
    }

    @Test
    @DisplayName("Test case for largest() with empty set")
    public void testLargestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> set.largest(), "Exception should be thrown when set is empty");
    }

    @Test
    @DisplayName("Test case for smallest() with non-empty set")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(5);
        set.add(3);
        assertEquals(1, set.smallest(), "The smallest element should be 1");
    }

    @Test
    @DisplayName("Test case for smallest() with empty set")
    public void testSmallestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> set.smallest(), "Exception should be thrown when set is empty");
    }

    @Test
    @DisplayName("Test case for add()")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1); // Adding duplicate
        assertEquals(1, set.length(), "The length should be 1 because duplicates are not added");
    }

    @Test
    @DisplayName("Test case for remove()")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1), "The set should not contain 1 after removal");
    }

    @Test
    @DisplayName("Test case for union()")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);

        set1.union(set2);
        assertTrue(set1.contains(1) && set1.contains(2) && set1.contains(3), "Union should contain 1, 2, and 3");
    }

    @Test
    @DisplayName("Test case for intersect()")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        set1.intersect(set2);
        assertTrue(set1.contains(2) && set1.contains(3), "Intersection should contain 2 and 3");
        assertFalse(set1.contains(1), "Intersection should not contain 1");
    }

    @Test
    @DisplayName("Test case for diff()")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);

        set1.diff(set2);
        assertTrue(set1.contains(1), "Difference should contain 1");
        assertFalse(set1.contains(2), "Difference should not contain 2");
        assertFalse(set1.contains(3), "Difference should not contain 3");
    }

    @Test
    @DisplayName("Test case for complement()")
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);

        set1.complement(set2);
        assertTrue(set1.contains(3), "Complement should contain 3");
        assertFalse(set1.contains(2), "Complement should not contain 2");
        assertFalse(set1.contains(1), "Complement should not contain 1");
    }

    @Test
    @DisplayName("Test case for toString()")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals("[1, 2, 3]", set.toString(), "String representation of the set should be correct");
    }
}
 

