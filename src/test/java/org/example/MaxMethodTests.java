package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class MaxMethodTests {
    @Test
    @DisplayName("For a null returns empty")
    public void testReturnsEmptyForNull() {
        int[] values = null;
        OptionalInt result = MaxMethod.max(values);
        assertEquals(OptionalInt.empty(), result);
    }

    @Test
    @DisplayName("For an empty array return empty")
    void testReturnsEmptyForEmptyArray() {
        int[] values = new int[0];
        OptionalInt result = MaxMethod.max(values);
        assertEquals(OptionalInt.empty(), result);
    }

    @Test
    @DisplayName("For an array of length 1 returns its only value")
    void testReturnArraysSingleValue() {
        int[] values = new int[]{10};
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(values[0], result.getAsInt());
    }

    @Test
    @DisplayName("For an array of negative ints returns correct max")
    void testReturnMaxForNegativeValues() {
        int[] values = new int[]{-4, -3, -3, -10, -2, -145};
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(-2, result.getAsInt());
    }

    @Test
    @DisplayName("For an array containing MAX_VALUE return the value")
    void testReturnIntegerMaxIfArrayContainsIt() {
        int[] values = new int[]{-10, 3, 255528, 0, Integer.MAX_VALUE, 100, 0};
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(Integer.MAX_VALUE, result.getAsInt());
    }

    @Test
    @DisplayName("For an array containing value near to MAX_VALUE return the value")
    void testReturnsValueNearToIntegerMaxIfArrayContainsIt() {
        int diff = 27;
        int toFind = Integer.MAX_VALUE - diff;
        int[] values = new int[]{8332, 0, -123, 44, 23, 924823, toFind};
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(toFind, result.getAsInt());
    }
}
